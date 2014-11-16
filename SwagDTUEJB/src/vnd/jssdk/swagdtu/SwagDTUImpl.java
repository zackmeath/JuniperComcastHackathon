/*******************************************************************************  
 * FILE NAME: SwagDTUImpl.java  
 * PURPOSE:   This class implements SwagDTU interface.  
 *   
 * Revision History:  
 * DATE:                             AUTHOR:             CHANGE:    
 * Wed Nov 12 16:16:16 EST 2014   ${USERNAME}      Initial creation  
 *******************************************************************************/  
package vnd.jssdk.swagdtu; 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Random;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.core.Response;

import net.juniper.jmp.ApiContext;
import net.juniper.jmp.PagingContext;
import net.juniper.jmp.PagingResult;
import net.juniper.jmp.ScheduleContext;
import net.juniper.jmp.annotation.scheduler.JobData;
import net.juniper.jmp.annotation.scheduler.Schedulable;
import net.juniper.jmp.cmp.cursor.InternalPagingContext;
import net.juniper.jmp.cmp.jobManager.InternalScheduleContext;
import net.juniper.jmp.cmp.jobManager.JobInfoTO;
import net.juniper.jmp.cmp.jobManager.JobManager;
import net.juniper.jmp.cmp.jobManager.JobStatus;
import net.juniper.jmp.cmp.jobManager.JobWorker;
import net.juniper.jmp.cmp.serviceApiCommon.InternalApiContext;
import net.juniper.jmp.cmp.system.JxServiceLocator;
import net.juniper.jmp.exception.ForbiddenException;
import net.juniper.jmp.exception.PreconditionFailedException;
import net.juniper.jmp.security.JSRestClient2;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.jboss.vfs.VirtualFile;


import vnd.AppConstants;

//lold
@Stateless(name = "SwagDTU")
@Remote(SwagDTU.class)
@Local(SwagDTULocal.class)
public class SwagDTUImpl extends JobWorker implements SwagDTU, SwagDTULocal { 
	static Random random = new Random();
	private static JobManager jobMgr = JxServiceLocator
			.lookup("cmp.JobManagerEJB");
	private static final String NO_DEVICE = "No Device found in database";
	private static final String NO_PTP ="No Ptp found in database";
	private static final String ERROR_DATA = "Could not obtain the device details";
	private static final String ERROR_INITCLIENT = "Error intializing jersey client";
	private static final String DEVICE_LIST_ERROR = "Error in retreiving device list";
	private static final String PTP_LIST_ERROR = "Error in retrieving PTPS";
	private static final String DEVICE_COUNT = "Count devices.@size:";
	private static final String PTP_COUNT = "Count ptps.@size";
	private static final String NO_RESPONSE = "Unable to get response";
	private PagingResult<Device> deviceCollection = null;
	private PagingResult<PTP> ptpCollection = null;
	private static PagingResult<Link> linkListGettable=new PagingResult<Link>();
	private static PagingResult<Device> deviceListGettable=null;
	private static PagingResult<PTP> ptpListGettable= null;
	private String JSON_STRING_DATA = "Could not obtain the json string for key: ";
	private String JSON_INT_DATA = "Could not obtain the json int for key: ";
	private String DEVICES_URL = AppConstants.SPACE_URL_PREFIX + "/device-management/devices";
	private String PTP_URL= AppConstants.SPACE_URL_PREFIX+"/managed-domain/ptps";
	private String JSON_DEVICES = AppConstants.SPACE_DATATYPE_PREFIX + ".device-management.devices+json;version=1";
	private String JSON_DEVICE = AppConstants.SPACE_DATATYPE_PREFIX + ".device-management.device+json;version=1";
	private String JSON_PTPS = AppConstants.SPACE_DATATYPE_PREFIX+".managed-domain.ptps+json;version=1";
	private String JSON_PTP=AppConstants.SPACE_DATATYPE_PREFIX+".managed-domain.ptp+json;version=1";
	private String ptpQueueURL="/api/hornet-q/queues/jms.queue.ptpQueue";
	private String linkQueueURL="/api/hornet-q/queues/jms.queue.linkQueue";
	private JSRestClient2 client;
	/**
	 * Instance Logger to log messages
	 **/
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(SwagDTUImpl.class);
	
	/**
	 * sets up user creds, and uses junos api to get all ptps
	 * @param apiCtx
	 * @param pagingCtx
	 * @return PagingResult<PTP>
	 * @throws PreconditionFailedException
	 * @throws ForbiddenException
	 */
	
	/**
	 * This method schedules a LRR job to get list of all Ptps, to be run
	 * @return JobInfoTO reference to JobInfoTo
	 */
	@JobData(
			name = "Refresh Topology", iconFileName = "/tmp/mx960.png"
			)
	@Schedulable
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public JobInfoTO refreshTopology(ApiContext apiCtx, ScheduleContext scheduleCtx) throws Exception{
		 int jobInstanceId=-1;
		 InternalScheduleContext iSctx=null;
		 
		if (scheduleCtx != null) {
             iSctx = (InternalScheduleContext) scheduleCtx;
             jobInstanceId = iSctx.getJobInstanceId();
     } else {
             logger.error("ScheduleContext is null");
             return null;
     }
		JobInfoTO jobinfo = new JobInfoTO();
		jobinfo.setId(jobInstanceId);
		jobinfo.setPercentComplete(10);
		jobinfo.setDetails("Getting Devices");
		PagingResult<Device> deviceObject = getAllDevices(apiCtx,new InternalPagingContext());
		logger.info("Got Devices succesfully!"+this.toString());
		if (deviceObject!=null){
			logger.info("got all devices");
			SwagDTUImpl.deviceListGettable=deviceObject;
		}else{
			logger.error("Failed to retrieve the data.");
			jobMgr.setJobInstanceResult(jobInstanceId,"Long running request failed",JobStatus.FAILURE,null);
		}
		
		jobinfo.setPercentComplete(40);
		jobinfo.setDetails("Getting Ptps");
		PagingResult<PTP> ptpObject = getAllPtps(apiCtx, new InternalPagingContext());
		logger.info("Got the ptps succesfully!"+this.toString());			
		if(ptpObject!= null){
			logger.info("Got ptps completely");
			SwagDTUImpl.ptpListGettable=ptpObject;			
		}else{
			logger.error("Failed to retrieve ptps.");
			jobMgr.setJobInstanceResult(jobInstanceId,"Long running request failed",JobStatus.FAILURE,null);
		}
		
		//Now this should create the array of links
		jobinfo.setPercentComplete(70);
		
		jobinfo.setDetails("Getting Links");
		PagingResult<Link> linkObject = getAllLinks(apiCtx, new InternalPagingContext());
		logger.info("got links?");
		jobinfo.setPercentComplete(100);
		if(linkObject!=null){
			logger.info("Got Links completely");
			SwagDTUImpl.linkListGettable=linkObject;
		}else{
			logger.error("Failed to retrieve links.");
			jobMgr.setJobInstanceResult(jobInstanceId,"Long running request failed",JobStatus.FAILURE,null);
		}
		
		jobinfo.setDetails("generating links");
		jobMgr.setJobInstanceResult(jobInstanceId,ptpObject,JobStatus.SUCCESS);
		return jobinfo;
	}
	
	public PagingResult<Device> getCurrentDeviceList(){
		return SwagDTUImpl.deviceListGettable;
	}
	/**
	public Device getCurrentDevice(int id){
		return SwagDTUImpl.deviceListGettable.get(id);
	}
	*/
	public PagingResult<PTP> getCurrentPtpList(){
		return SwagDTUImpl.ptpListGettable;
	}
	
	public PagingResult<Link> getCurrentLinkList(){
		return SwagDTUImpl.linkListGettable;
	}
	/**
	 * Gets all ptps from the apis
	 */
	public PagingResult<PTP> getAllPtps(ApiContext apiCtx, 
		PagingContext pagingCtx) throws PreconditionFailedException,ForbiddenException{
		
		PagingResult<PTP> result = null;

		// Set up user credentials
		try {
			setupHttpClient(apiCtx);
		} catch (Exception e) {
			// This will result in HTTP error code 412, instead of 500.
			throw new PreconditionFailedException(e.getLocalizedMessage());
		}
		
		InternalApiContext iac = (InternalApiContext) apiCtx;
		
		String url = PTP_URL;
		boolean usedQuestionMark = false;
		if (pagingCtx.getPageSize() > 0) {
			url += "?start=" + (pagingCtx.getPageNumber()*pagingCtx.getPageSize()) + "&limit=" + pagingCtx.getPageSize();
			usedQuestionMark = true;
		}
		if (pagingCtx.getSortByAttrName() != null)
			url += (usedQuestionMark?"&":"?") + "sortby=(" + pagingCtx.getSortByAttrName() + "(" +pagingCtx.getSortDirection().name().toLowerCase() + "))";

		// Get response from the service
		HttpResponse response = get(url, JSON_PTPS);
		if (response != null) {

			int status = response.getStatusLine().getStatusCode();

			// Convert error code to EJB exceptions - these would be properly handled by the REST layer
			if (status == Response.Status.NO_CONTENT.getStatusCode()) {
				return null; 
			} else if (status == Response.Status.UNAUTHORIZED.getStatusCode()) {
				throw new ForbiddenException(response.getStatusLine().getReasonPhrase());		// Since client had access to run this API, we should never hit this.
			} else if (status == Response.Status.OK.getStatusCode()) {
				result = getJSONPtpObject(response, pagingCtx,apiCtx);
			} else {
				throw new PreconditionFailedException(response.getStatusLine().getReasonPhrase());
			}
		}
		return result;
			
	}
	
	private ArrayList<PTP> swapArrayPosPTP(ArrayList<PTP> list, int a, int b ) {
		PTP temp = list.get(a);
		list.set(a, list.get(b));
		list.set(b, temp);
		return list;
	}
	
	private Boolean ptpMatch(ApiContext apic, PTP a, PTP b) {
		try {
			Device devicea = getDevice(apic, a.getDeviceID());
			Device deviceb = getDevice(apic, b.getDeviceID());
			return devicea.getName() == b.getDescription() && deviceb.getName() == a.getDescription();
		} catch (Exception Ex) {
			return null;
		}
	}
	
	public PagingResult<Link> getAllLinks(ApiContext apiCtx,
			PagingContext pagingCtx) throws PreconditionFailedException {
		PagingResult<Link> resultLinks = new PagingResult<Link>();
		resultLinks.setPagingContext(pagingCtx);
		String connection;
		boolean preExistingLink;
		//Start by going through the static device list
		for (Device tmpDevice : deviceListGettable){
			//set name of device iterating on. This should be equivalent to any ptps description if involved in link
			String name = tmpDevice.getName();
			//iterate through all ptps
			for (PTP tmpPtp : ptpListGettable){				
				//set connection as the description of ptp,
				connection = tmpPtp.getDescription();
				if (name.equalsIgnoreCase(connection)){					
					preExistingLink = false;
					//should indicate that there is already a link created.
					//if(!resultLinks.isEmpty()){
					//	for (Link link : resultLinks){
					//		if((tmpDevice.equals(link.getDeviceA()) || tmpDevice.equals(link.getDeviceB())) 
					//				&& (tmpPtp.getDeviceID()==link.getDeviceB().getId() || tmpPtp.getDeviceID()==link.getDeviceA().getId())){								
					//			preExistingLink=true;
					//		}
					//	}
					//}
					Link existingLink = new Link();
					if(!resultLinks.isEmpty()) {
						for (Link link : resultLinks) {
							if ((    tmpDevice.getId() == link.getDeviceA().getId() || tmpDevice.getId() == link.getDeviceB().getId())  &&  
									(tmpPtp.getDeviceID() == link.getDeviceB().getId() || tmpPtp.getDeviceID() == link.getDeviceA().getId())
							   ) {								
								preExistingLink = true;
								existingLink=link;
							}
						}
					}
					//if PreExistingLink isn't true, then create new link and set device A and other attributes.
					Device devB = getDevice(apiCtx,tmpPtp.deviceID);
					String tmpLinkId;
					if(!preExistingLink){
						Link tmplink = new Link();
						tmplink.setDeviceA(tmpDevice);
						tmplink.setDeviceB(devB);
						tmplink.setPtpB(tmpPtp);	
						//Link ID will be the id of the two devices added together.						
						//so that the larger id is always in front
						if(devB.getId() > tmpDevice.getId()){
							tmpLinkId = devB.getId()+""+tmpDevice.getId();
						}else{
							tmpLinkId=tmpDevice.getId()+""+devB.getId();
						}
						
						tmplink.setlinkId(tmpLinkId);
						resultLinks.add(tmplink);						
					}else{
						//Link already exists, so we need to get it from the list and populate it with the ptpa
						if(devB.getId() > tmpDevice.getId()){
							tmpLinkId = devB.getId()+""+tmpDevice.getId();
						}else{
							tmpLinkId=tmpDevice.getId()+""+devB.getId();
						}
						existingLink.setPtpA(tmpPtp);
						resultLinks.remove(existingLink);
						resultLinks.add(existingLink);
						
					}
				}
			}
					
		}
		
		/**
		//ArrayList<Link> list = new ArrayList<Link>();
		//Logic to compare all of the ptps to each other:
		for (int i = 0; i < ptpCollection.size(); i += 2) {
			PTP ii = ptpCollection.get(i);
			for (int j = i; j < ptpCollection.size(); j++) {
				PTP jj = ptpCollection.get(j);
				if (ptpMatch(apiCtx, ii, jj)){
					result.add(new Link(ii, getDevice(apiCtx, ii.getDeviceID()), jj, getDevice(apiCtx, jj.getDeviceID())));
					swapArrayPosPTP(ptpCollection, (i + 1), j);
					break;
				} else {
					continue;
				}
			}
		}
		*/
		//after all matches are found
		//get it into json and stuff and things
		return resultLinks;
	}
	
	/**
	 * Description: This method set up HTTP Client and calls JUNOS SPACE API and
	 * return the list of JUNOS devices.
	 * 
	 * @param apiCtx
	 *            Reference of ApiContext - used for passing in user credentials
	 *            and base url
	 * @param pagingCtx
	 *            Reference of PagingContext - used for filtering, paging,
	 *            sorting, etc.
	 * 
	 * @return PagingResult<Device> paging result of list of devices
	 * 
	 */
	public PagingResult<Device> getAllDevices(ApiContext apiCtx,
			PagingContext pagingCtx) throws PreconditionFailedException, ForbiddenException {

		PagingResult<Device> result = null;
		// Set up user credentials
		try {
			setupHttpClient(apiCtx);
		} catch (Exception e) {
			// This will result in HTTP error code 412, instead of 500.
			throw new PreconditionFailedException(e.getLocalizedMessage());
		}

		InternalApiContext iac = (InternalApiContext) apiCtx;
		String url = DEVICES_URL;
		boolean usedQuestionMark = false;
		if (pagingCtx.getPageSize() > 0) {
			url += "?start=" + (pagingCtx.getPageNumber()*pagingCtx.getPageSize()) + "&limit=" + pagingCtx.getPageSize();
			usedQuestionMark = true;
		}
		if (pagingCtx.getSortByAttrName() != null)
			url += (usedQuestionMark?"&":"?") + "sortby=(" + pagingCtx.getSortByAttrName() + "(" +pagingCtx.getSortDirection().name().toLowerCase() + "))";

		// Get response from the service
		HttpResponse response = get(url, JSON_DEVICES);
		if (response != null) {

			int status = response.getStatusLine().getStatusCode();

			// Convert error code to EJB exceptions - these would be properly handled by the REST layer
			if (status == Response.Status.NO_CONTENT.getStatusCode()) {
				return null; 
			} else if (status == Response.Status.UNAUTHORIZED.getStatusCode()) {
				throw new ForbiddenException(response.getStatusLine().getReasonPhrase());		// Since client had access to run this API, we should never hit this.
			} else if (status == Response.Status.OK.getStatusCode()) {
				result = getJSONDeviceObject(response, pagingCtx);
			} else {
				throw new PreconditionFailedException(response.getStatusLine().getReasonPhrase());
			}
		}
		return result;
	}

	/**
	 * This method is used to create a JSServiceClient instance. 
	 * The APIContext will provide the User credentials.
	 * @param apiCtx
	 *            Reference of ApiContext - used for passing in user credentials
	 *            and base url.
	 * 				
	 */
	private void setupHttpClient(ApiContext apic) throws Exception {

		// Create an instance of JSServiceClient using ApiContext
		try {
			InternalApiContext iac = (InternalApiContext) apic;
			client = new JSRestClient2();
			client.login();
		} catch (Exception exc) {
			logger.error(ERROR_INITCLIENT);
			logger.error(exc);
			throw exc;
		}

	}
	/**
	 * 
	 * This method is an utility method to call the service GET method and
	 * receive the response
	 * 
	 * @param url
	 *            URL to fetch the data from.
	 * @return response String representation of the data received from the
	 *         service
	 */

	private HttpResponse get(String url, String mediaType) {
		HttpResponse response = null;
		try {
			HttpGet request = new HttpGet(url);
			request.setHeader("Accept", mediaType);

			response = client.getClient().request(request);

		} catch (Exception e) {
			logger.error(NO_RESPONSE);
			logger.error(e);
		}
		return response;
	}
	/**
	 * Returns a String entity from the response body
	 * @param response
	 * @return
	 */
	private String getEntity(HttpResponse response) {
		HttpEntity entity = response.getEntity();
		String responseJson = null;
		try {
			responseJson = entity != null ? EntityUtils.toString(entity) : null;
		} catch (ParseException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return responseJson;
	}
	/**
	 * 
	 * This method will give integer value corresponding to the key passed, from
	 * JSONObject
	 * 
	 * @param jsonObject
	 *            JSONObject from which value is to be fetched
	 * @param key
	 *            String represents the key for which value to be fetched
	 * 
	 * @return int value from JSONObject, returns 0 if value for the key not
	 *         found or unable to find
	 * 
	 */
	private int getInt(JSONObject jsonObject, String key) {
		try {
			return jsonObject.getInt(key);
		} catch (JSONException ex) {
			logger.warn(JSON_INT_DATA + key);
		}
		return 0;
	}
	/**
	 * 
	 * This method will give String corresponding to the key passed, from
	 * JSONObject
	 * 
	 * @param jsonObject
	 *            JSONObject from which value is to be fetched
	 * @param key
	 *            String represents the key for which value to be fetched
	 * 
	 * @return String from JSONObject, returns null if value for the key not
	 *         found or unable to find
	 * 
	 */
	private String getString(JSONObject jsonObject, String key) {
		try {
			return jsonObject.getString(key);
		} catch (JSONException ex) {
			logger.warn(JSON_STRING_DATA + key);
		}
		return null;
	}
	
	
	
	
	
	
	
	/**
	 * Given a platform name set the info url for the platform in the device object.
	 * @param device
	 * @param platform
	 */
	private void setInfoUrlForDevice(Device device, String platform) {
		if (platform.equals("EX4200-24T"))
			device.setInfoUrl("http://www.juniper.net/us/en/products-services/switching/ex-series/ex4200/");
		else if (platform.equals("M7I"))
			device.setInfoUrl("http://www.juniper.net/us/en/products-services/routing/m-series/m7i/");
		else if (platform.equals("MX80"))
			device.setInfoUrl("http://www.juniper.net/us/en/products-services/routing/mx-series/mx80/");
		else if (platform.equals("MX960"))
			device.setInfoUrl("http://www.juniper.net/us/en/products-services/routing/mx-series/mx960/");
		else if (platform.equals("SRX220H"))
			device.setInfoUrl("http://www.juniper.net/us/en/products-services/security/srx-series/srx220/");
		else
			device.setInfoUrl("http://www.juniper.net/us/en/products-services/");
	}
	
	
	
	
	/**
	 * This method converts the response into JSON Object and returns collection of PTPs
	 */
	private PagingResult<PTP> getJSONPtpObject(HttpResponse response,PagingContext ctx,ApiContext apic){
		ptpCollection = new PagingResult<PTP>();
		ptpCollection.setPagingContext(ctx);
		String responseJson = getEntity(response);
		if (responseJson != null) {
			JSONObject jsonObject;
			try {
				jsonObject = new JSONObject(responseJson);
				JSONObject jsonPtps = (JSONObject) jsonObject.get("ptps");
				if (jsonPtps != null) {
					JSONArray array = null;
					int ptpCount = getInt(jsonPtps, "@size");
					logger.info(PTP_COUNT + ptpCount);
					// Handle if JSON response contains only one device.
					if (ptpCount == 1) {
						JSONObject jsonPtp = (JSONObject) jsonPtps.get("ptp");
						ArrayList<JSONObject> jsonList = new ArrayList<JSONObject>();
						jsonList.add(jsonPtp);
						array = new JSONArray(jsonList);
					}// Handle if the JSON response contains more than one.
					else if (ptpCount > 1) {
						try {
							array = jsonPtps.getJSONArray("ptp");

						} catch (JSONException e) {
							JSONObject jsonPtp = (JSONObject) jsonPtps.get("ptp");
							ArrayList<JSONObject> jsonList = new ArrayList<JSONObject>();
							jsonList.add(jsonPtp);
							array = new JSONArray(jsonList);
						}
					} else {
						logger.warn(NO_PTP);
						return null;

					}
					if (array != null) {
						ctx.setTotalRecords(ptpCount);
						for (int i = 0; i < array.length(); i++) {
							//NEW
							//Populates the ptp collection with the complete details of every PTP							
							JSONObject jsonPtp = array.getJSONObject(i);
							PTP ptp = new PTP();
							String uri = getString(jsonPtp, "@uri");			
													
							// IF device uri is in response, get all possible attributes from the ptp
							if (uri != null) {
								response = get(uri, JSON_PTP);
								int status = response.getStatusLine()
										.getStatusCode();
								if (response != null) {
									if (status != Response.Status.OK
											.getStatusCode()) {
										logger.error(ERROR_DATA + uri);
										continue;
									}
									responseJson = getEntity(response);
									JSONObject jsonObj = new JSONObject(
											responseJson);
									JSONObject ptpObj = (JSONObject) jsonObj
											.get("ptp");
									ptp.setID(getInt(ptpObj, "id"));
									//new
									ptp=getPtp(apic,ptp.getID());
								}
							//if the uri isn't in the response, just get what we can	
							}else{
								// Set queried Device data
								ptp.setName(getString(jsonPtp, "name"));
								ptp.setID(getInt(jsonPtp, "id"));
								ptp.setDescription(getString(jsonPtp, "description"));
								ptp.setDeviceID(getInt(jsonPtp,"deviceId"));
								ptp.setLoopbackEnabled(getString(jsonPtp,"looback"));
								ptp.setEncapsulation(getString(jsonPtp,"encapsulation"));
								//ptp.setTagging(getString(jsonPtp,"tagging"));
								ptp.setAdminStatus(getString(jsonPtp,"adminStatus"));
								ptp.setOperationStatus(getString(jsonPtp,"operationStatus"));
								ptp.setLinkLevelType(getString(jsonPtp,"linkLevelType"));
								ptp.setLinkType(getString(jsonPtp,"linkType"));
								ptp.setSpeed(getInt(jsonPtp,"speed"));
								ptp.setSpeedStr(getString(jsonPtp,"speedStr"));
								ptp.setMtu(getInt(jsonPtp,"mtu"));
								ptp.setMtuStr(getString(jsonPtp,"mtuStr"));
								ptp.setMtuStr(getString(jsonPtp,"hardwarePhysicalAddress"));								
							}							
							ptpCollection.add(ptp);
						
						}
					}
				}
			} catch (JSONException ex) {
				logger.error(PTP_LIST_ERROR);
				logger.error(ex);

			} catch (Exception ex) {
				logger.error(ERROR_DATA);
				logger.error(ex);

			}
		} else {
			logger.warn(NO_PTP);
			return null;
		}
		return ptpCollection;
	}	

	
	/**
	 * 
	 * This method return a Device based on the ID passed.
	 * 
	 * @param apiCtx
	 *            InternalApiContext to retrieve the base URL
	 * 
	 * @param serviceURL
	 *            URL for the device collection. Should be
	 *            "/api/space/device-management/devices"
	 * 
	 * @param id
	 *            id of the device that needs to be fetched.
	 * 
	 * @return Device from response, returns null if device is not found.
	 * 
	 */
	public Device getDevice(ApiContext apiCtx, int id) throws PreconditionFailedException {
		// Set up HTTP Client.
		String deviceUri = DEVICES_URL + "/" + id;
		try {
			setupHttpClient(apiCtx);
		} catch (Exception e) {
			// This will result in HTTP error code 412, instead of 500.
			throw new PreconditionFailedException(e.getLocalizedMessage());
		}		

		InternalApiContext iac = (InternalApiContext) apiCtx;
		HttpResponse response;
		Device device = new Device();
		try {
			response = get(deviceUri, JSON_DEVICE);
			int status = response.getStatusLine().getStatusCode();
			if (status != Response.Status.OK.getStatusCode()) {
				logger.error(ERROR_DATA);
				return null;
			}

			String deviceJson = getEntity(response);
			device.setId(id);
			JSONObject deviceObj;
			// populating device object with device data.
			if (deviceJson != null) {
				deviceObj = (JSONObject) new JSONObject(deviceJson).get("device");
				device.setName(deviceObj.getString("name"));
				device.setIpAddr(deviceObj.getString("ipAddr"));
				String platform = deviceObj.getString("platform");
				device.setPlatform(platform);
				setInfoUrlForDevice(device, platform);				
				String cStatus = deviceObj.getJSONObject("connection-status").getString("status");						
				device.setStatus(cStatus);	
			}
		} catch (JSONException ex) {
			logger.error(ex);
			return null;

		} catch (Exception ex) {
			logger.error(ex);
			return null;
		}

		return device;
	}

	

	/**
	 * 
	 * This method return a Ptp based on the ID passed.
	 * 
	 * @param apiCtx
	 *            InternalApiContext to retrieve the base URL
	 * 
	 * @param serviceURL
	 *            URL for the device collection. Should be
	 *            "/api/space/device-management/devices"
	 * 
	 * @param id
	 *            id of the device that needs to be fetched.
	 * 
	 * @return Device from response, returns null if device is not found.
	 * 
	 */
	public PTP getPtp(ApiContext apiCtx, int id) throws PreconditionFailedException {
		// Set up HTTP Client.
		String PtpUri = PTP_URL + "/" + id;
		try {
			setupHttpClient(apiCtx);
		} catch (Exception e) {
			// This will result in HTTP error code 412, instead of 500.
			throw new PreconditionFailedException(e.getLocalizedMessage());
		}		

		InternalApiContext iac = (InternalApiContext) apiCtx;
		HttpResponse response;
		PTP ptp =new PTP();
		try {
			response = get(PtpUri, JSON_PTP);
			int status = response.getStatusLine().getStatusCode();
			if (status != Response.Status.OK.getStatusCode()) {
				logger.error(ERROR_DATA);
				return null;
			}

			String ptpJson = getEntity(response);
			ptp.setID(id);
			JSONObject ptpObj;
			String ptpDescription;
			// populating ptp object with ptp data.
			if (ptpJson != null) {
				ptpObj = (JSONObject) new JSONObject(ptpJson).get("ptp");
				ptp.setName(ptpObj.getString("name"));
				ptp.setDeviceID(ptpObj.getInt("deviceId"));
				ptp.setLoopbackEnabled(ptpObj.getString("loopback"));
				ptp.setEncapsulation(ptpObj.getString("encapsulation"));
				ptp.setAdminStatus(ptpObj.getString("adminStatus"));
				ptp.setOperationStatus(ptpObj.getString("operationStatus"));
				ptp.setSpeed(ptpObj.getInt("speed"));
				ptp.setSpeedStr(ptpObj.getString("speedStr"));
				ptp.setMtu(ptpObj.getInt("mtu"));				
				if (ptpObj.has("description")){
					ptp.setDescription(ptpObj.getString("description"));
					
				}			
				if(ptpObj.has("hardwarePhysicalAddress")){
					ptp.setMacAddress(ptpObj.getString("hardwarePhysicalAddress"));
				}
				if (ptpObj.has("linkLevelType")){
					ptp.setLinkType(ptpObj.getString("linkLevelType"));
				}
				if(ptpObj.has("mtuStr")){
					ptp.setMtuStr(ptpObj.getString("mtuStr"));					
				}
				
				
				/*
				String managedElementURL=ptpObj.getJSONObject("managed-element").getString("href");
				int managedDevId = ptpObj.getJSONObject("managed-element").getInt("id");
				String managedDevIp = ptpObj.getJSONObject("managed-element").getString("ipAddr");
				ptp.setManagedDeviceID(managedDevId);
				ptp.setManagedDevIpAddress(managedDevIp);
				*/
			}
		} catch (JSONException ex) {
			logger.error(ex);
			return null;

		} catch (Exception ex) {
			logger.error(ex);
			return null;
		}

		return ptp;
	}
	
	
	/**
	 * Private method to write a byte array to a temporary file
	 * @param content
	 * @param filename
	 * @throws IOException
	 */
	private void writeFile(byte[] content, String filename) throws IOException {

		File file = new File(filename);

		if (!file.exists()) {
			file.createNewFile();
		}

		FileOutputStream fop = new FileOutputStream(file);

		fop.write(content);
		fop.flush();
		fop.close();

	}	

	/**
	 * Accepts an image, which is a byte array of data and writes it to 'filename'
	 * @param bytes - image bytes
	 * @param fileName- image file (or platform) name
	 */
	public void addImage(byte[] imageFileBytes, String imageFile) throws Exception {

		//constructs upload file path
		String tmpFile = "/tmp/" + imageFile;
		writeFile(imageFileBytes, tmpFile);

	}
	
	
	
	/**
	 * Get the image associated with the platform name
	 * @param platform
	 * @return
	 * @throws Exception
	 */
	public byte [] getImage(String platform) throws Exception {
		File imageFile = getImageFile(platform);
		if (imageFile == null || !imageFile.exists())
			return null;
		return readFile(imageFile);
	}

	
	/**
	 * Construct a file name and return the image file for the give platform
	 * @param platform
	 * @return
	 */
	private File getImageFile(String platform) {
		try {
			File imageFile = new File("/tmp/" + platform + ".png");
			if (imageFile.exists())
				return imageFile;
			imageFile = new File("/tmp/" + platform + ".jpg");
			if (imageFile.exists())
				return imageFile;
			URL fileURL = getClass().getClassLoader().getResource("./images/devices/" + platform + ".jpg");
			if (fileURL == null) {
				fileURL = getClass().getClassLoader().getResource("./images/devices/router.jpg");
			}
			if (fileURL == null) {
				return null;
			}
			if (fileURL.getPath().indexOf("!") > 0 || fileURL.getProtocol().equals("vfs")) {
				URLConnection conn = fileURL.openConnection();
				VirtualFile vf = (VirtualFile)conn.getContent();
				  File contentsFile = vf.getPhysicalFile();
				  File dir = contentsFile.getParentFile();
				  File physicalFile = new File(dir, contentsFile.getName());
				  return physicalFile;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Read a file and return byte content
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private static byte[] readFile(File file) throws IOException {
		// Open file
		RandomAccessFile f = new RandomAccessFile(file, "r");
		try {
			// Get and check length
			long longlength = f.length();
			int length = (int) longlength;
			if (length != longlength)
				throw new IOException("File size >= 2 GB");
			// Read file and return data
			byte[] data = new byte[length];
			f.readFully(data);
			return data;
		} finally {
			f.close();
		}
	}
	
	/**
	 * get individual link from ID
	 */
	public Link getLink(String id){
		for (Link link : linkListGettable){
			if (link.getLinkId().equals(id)){
				return link;
			}
		}
		return null;
	}


	/**
	 * Description: This method converts the response into the JSON object and
	 * returns a collection of devices with pagination applied on the result.
	 * 
	 * @param ctx
	 *            Reference of PagingContext
	 * @param ClientResponse
	 *            Response from the client.
	 * 
	 * @exception Exception
	 * 
	 * @return PagingResult<Device> paging result of collection of devices
	 * 
	 */

	private PagingResult<Device> getJSONDeviceObject(HttpResponse response, PagingContext ctx) {

		deviceCollection = new PagingResult<Device>();
		deviceCollection.setPagingContext(ctx);
		
		String responseJson = getEntity(response);
		if (responseJson != null) {
			JSONObject jsonObject;
			try {
				jsonObject = new JSONObject(responseJson);
				JSONObject jsonDevices = (JSONObject) jsonObject.get("devices");
				if (jsonDevices != null) {
					JSONArray array = null;
					int deviceCount = getInt(jsonDevices, "@size");
					logger.info(DEVICE_COUNT + deviceCount);
					// Handle if JSON response contains only one device.
					if (deviceCount == 1) {
						JSONObject jsonDevice = (JSONObject) jsonDevices.get("device");
						ArrayList<JSONObject> jsonList = new ArrayList<JSONObject>();
						jsonList.add(jsonDevice);
						array = new JSONArray(jsonList);
					}// Handle if the JSON response contains more than one.
					else if (deviceCount > 1) {
						try {
							array = jsonDevices.getJSONArray("device");

						} catch (JSONException e) {
							JSONObject jsonDevice = (JSONObject) jsonDevices.get("device");
							ArrayList<JSONObject> jsonList = new ArrayList<JSONObject>();
							jsonList.add(jsonDevice);
							array = new JSONArray(jsonList);
						}
					} else {
						logger.warn(NO_DEVICE);
						return null;

					}
					if (array != null) {
						ctx.setTotalRecords(deviceCount);
						for (int i = 0; i < array.length(); i++) {
							JSONObject jsonDevice = array.getJSONObject(i);
							String uri = getString(jsonDevice, "@uri");
							Device device = new Device();
							// Set queried Device data
							device.setName(getString(jsonDevice, "name"));
							device.setId(getInt(jsonDevice, "id"));
							device.setIpAddr(getString(jsonDevice, "ipAddr"));
							device.setPlatform(getString(jsonDevice, "platform"));
							device.setStatus(getString(jsonDevice, "connectionStatus"));

							setInfoUrlForDevice(device, getString(jsonDevice, "platform"));
							

							// Handle if device URI is in response.
							if (uri != null) {
								response = get(uri, JSON_DEVICE);
								int status = response.getStatusLine()
										.getStatusCode();
								if (response != null) {
									if (status != Response.Status.OK
											.getStatusCode()) {
										logger.error(ERROR_DATA + uri);
										continue;
									}
									responseJson = getEntity(response);
									JSONObject jsonObj = new JSONObject(
											responseJson);
									JSONObject deviceObj = (JSONObject) jsonObj
											.get("device");
									device.setId(getInt(deviceObj, "id"));
								}
							}
							//setLocation(device);
							deviceCollection.add(device);
						}
					}
				}
			} catch (JSONException ex) {
				logger.error(DEVICE_LIST_ERROR);
				logger.error(ex);

			} catch (Exception ex) {
				logger.error(ERROR_DATA);
				logger.error(ex);

			}
		} else {
			logger.warn(NO_DEVICE);
			return null;
		}
		return deviceCollection;
	}

} 
