package vnd.jssdk.swagdtu.rest.v1;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import net.juniper.jmp.annotation.rbac.CRUDEnum;
import net.juniper.jmp.annotation.rbac.RBAC;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import net.juniper.jmp.parsers.common.UriContext;
import javax.annotation.Generated;

/*******************************************************************************
 *
 * @ServiceName Swag DTU
 *
 ******************************************************************************/
@Path("")
@Generated(value = "REST Wizard", comments = "sourceInterface:vnd.jssdk.swagdtu.SwagDTU,sourceImplementation:vnd.jssdk.swagdtu.SwagDTUImpl,targetImplementation:/SwagDTUWebSvc/web-src/vnd/jssdk/swagdtu/rest/v1/SwagDTURestImpl.java,version:1")
public interface SwagDTURest {

  /***
   * Get image associated with the platform name.  
   * Image is retrieved from a file on the server and sent back to the client as a byte stream.
   * 
   * @summary Get image associated with the platform name
   * 
   * @param platform Name of platform associated with the image.  
   * For example "/images/SRX1400".
   **/
  @Path("/images/{platform}")
  @GET
  @RBAC(type = {CRUDEnum.READ}, capability = {"HelloSpaceCap"})
  @Produces({"application/octet-stream"})
  @Generated(value = "REST Wizard", comments = "retryEnabled:false,yieldTime:100,response_multipart:&#44;BA&#44;false&#44;_M_R,retryCount:3,audit_detail_enabled:false,generation:0,signature:(QString;)[B")
  public javax.ws.rs.core.Response getImage(@PathParam("platform") String platform)
      throws Exception;

  /***
   * This method schedules a LRR job to get list of all Ptps, to be run
   * 
   * @summary This method schedules a LRR job to get list of all Ptps, to be run
   * 
   * @async
   * 
   * @param apiCtx Api Ctx
   **/
  @Path("/refresh-topology")
  @POST
  @RBAC(type = {CRUDEnum.CREATE}, capability = {"SwagDTUCap"})
  @Produces({"application/vnd.net.juniper.space.job-management.task+xml;version=1;q=0.01",
      "application/vnd.net.juniper.space.job-management.task+json;version=1;q=0.01"})
  @Generated(value = "REST Wizard", comments = "yieldTime:100,retryEnabled:true,retryCount:3,audit_detail_enabled:false,generation:0,signature:(QApiContext;QScheduleContext;)QJobInfoTO;")
  public net.juniper.jmp.cmp.async.Task refreshTopology(@Context UriContext apiCtx)
      throws Exception;

  /***
   * sets up user creds, and uses junos api to get all ptps
   * 
   * @summary sets up user creds, and uses junos api to get all ptps
   * 
   * @outputXML 
   * &lt;ptps total=&quot;Integer&quot; uri=&quot;/api/jssdk/swag-dtu/ptps&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;ptp href=&quot;/api/jssdk/swag-dtu/ptps/{pTPId}&quot; uri=&quot;/api/jssdk/swag-dtu/ptps/{pTPId}&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;mtu&gt;Integer&lt;/mtu&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;speedStr&gt;String&lt;/speedStr&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;managedDeviceId&gt;Integer&lt;/managedDeviceId&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;speed&gt;Integer&lt;/speed&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;tagging&gt;String&lt;/tagging&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;adminStatus&gt;String&lt;/adminStatus&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;operationStatus&gt;String&lt;/operationStatus&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;deviceId&gt;Integer&lt;/deviceId&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;linkType&gt;String&lt;/linkType&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;macAddress&gt;String&lt;/macAddress&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;id&gt;Integer&lt;/id&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;ptpid&gt;Integer&lt;/ptpid&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;loopbackEnabled&gt;String&lt;/loopbackEnabled&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;managed-dev-ip-address&gt;String&lt;/managed-dev-ip-address&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;link-level-type&gt;String&lt;/link-level-type&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;description&gt;String&lt;/description&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;name&gt;String&lt;/name&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;mtuStr&gt;String&lt;/mtuStr&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;info-url&gt;String&lt;/info-url&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;encapsulation&gt;String&lt;/encapsulation&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;/ptp&gt;<br/>
   * &lt;/ptps&gt;
   * 
   * 
   * @outputJSON 
   * {<br/>
   * &nbsp;&nbsp;	&quot;ptps&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;@total&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/ptps&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;ptp&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/ptps/{pTPId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/ptps/{pTPId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;mtu&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;speedStr&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;managedDeviceId&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;speed&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;tagging&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;adminStatus&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;operationStatus&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;deviceId&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;linkType&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;macAddress&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;id&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;ptpid&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;loopbackEnabled&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;managed-dev-ip-address&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;link-level-type&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;description&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;name&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;mtuStr&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;info-url&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;encapsulation&quot; : &quot;String&quot;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	}<br/>
   * &nbsp;&nbsp;	}<br/>
   * }
   * 
   * 
   * @param apic Apic
   **/
  @Path("/ptps")
  @GET
  @RBAC(type = {CRUDEnum.READ}, capability = {"SwagDTUCap"})
  @Produces({"application/vnd.jssdk.swag-dtu.ptps+xml;version=1;q=0.01",
      "application/vnd.jssdk.swag-dtu.ptps+json;version=1;q=0.01"})
  @Generated(value = "REST Wizard", comments = "yieldTime:100,retryEnabled:false,retryCount:3,audit_detail_enabled:false,generation:0,signature:(QApiContext;QPagingContext;)QPagingResult<QPTP;>;")
  public vnd.jssdk.swagdtu.rest.v1.Ptps getAllPtps(@Context UriContext apic) throws Exception;

  /***
   * return current list of Ptps
   * 
   * @summary return current list of Ptps
   * 
   * @outputXML 
   * &lt;ptps total=&quot;Integer&quot; uri=&quot;/api/jssdk/swag-dtu/current-ptp-lists&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;ptp href=&quot;/api/jssdk/swag-dtu/ptps/{pTPId}&quot; uri=&quot;/api/jssdk/swag-dtu/current-ptp-lists/{pTPId}&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;mtu&gt;Integer&lt;/mtu&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;speedStr&gt;String&lt;/speedStr&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;managedDeviceId&gt;Integer&lt;/managedDeviceId&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;speed&gt;Integer&lt;/speed&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;tagging&gt;String&lt;/tagging&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;adminStatus&gt;String&lt;/adminStatus&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;operationStatus&gt;String&lt;/operationStatus&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;deviceId&gt;Integer&lt;/deviceId&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;linkType&gt;String&lt;/linkType&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;macAddress&gt;String&lt;/macAddress&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;id&gt;Integer&lt;/id&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;ptpid&gt;Integer&lt;/ptpid&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;loopbackEnabled&gt;String&lt;/loopbackEnabled&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;managed-dev-ip-address&gt;String&lt;/managed-dev-ip-address&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;link-level-type&gt;String&lt;/link-level-type&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;description&gt;String&lt;/description&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;name&gt;String&lt;/name&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;mtuStr&gt;String&lt;/mtuStr&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;info-url&gt;String&lt;/info-url&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;encapsulation&gt;String&lt;/encapsulation&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;/ptp&gt;<br/>
   * &lt;/ptps&gt;
   * 
   * 
   * @outputJSON 
   * {<br/>
   * &nbsp;&nbsp;	&quot;ptps&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;@total&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/current-ptp-lists&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;ptp&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/ptps/{pTPId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/current-ptp-lists/{pTPId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;mtu&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;speedStr&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;managedDeviceId&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;speed&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;tagging&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;adminStatus&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;operationStatus&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;deviceId&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;linkType&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;macAddress&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;id&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;ptpid&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;loopbackEnabled&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;managed-dev-ip-address&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;link-level-type&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;description&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;name&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;mtuStr&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;info-url&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;encapsulation&quot; : &quot;String&quot;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	}<br/>
   * &nbsp;&nbsp;	}<br/>
   * }
   **/
  @Path("/current-ptp-lists")
  @GET
  @RBAC(type = {CRUDEnum.READ}, capability = {"SwagDTUCap"})
  @Produces({"application/vnd.jssdk.swag-dtu.ptps+xml;version=1;q=0.01",
      "application/vnd.jssdk.swag-dtu.ptps+json;version=1;q=0.01"})
  @Generated(value = "REST Wizard", comments = "yieldTime:100,retryEnabled:false,retryCount:3,audit_detail_enabled:false,generation:0,signature:()QPagingResult<QPTP;>;")
  public vnd.jssdk.swagdtu.rest.v1.Ptps getCurrentPtpList() throws Exception;

  /***
   * Returns list of devices listing their ID ,IP and Name
   * 
   * @summary Returns list of devices listing their ID ,IP and Name
   * 
   * @outputXML 
   * &lt;devices total=&quot;Integer&quot; uri=&quot;/api/jssdk/swag-dtu/devices&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;device href=&quot;/api/jssdk/swag-dtu/devices/{id}&quot; uri=&quot;/api/jssdk/swag-dtu/devices/{id}&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;id&gt;Integer&lt;/id&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;platform&gt;String&lt;/platform&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;ipAddr&gt;String&lt;/ipAddr&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;status&gt;String&lt;/status&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;name&gt;String&lt;/name&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;longitude&gt;Float&lt;/longitude&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;latitude&gt;Float&lt;/latitude&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;info-url&gt;String&lt;/info-url&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;/device&gt;<br/>
   * &lt;/devices&gt;
   * 
   * 
   * @outputJSON 
   * {<br/>
   * &nbsp;&nbsp;	&quot;devices&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;@total&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/devices&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;device&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/devices/{id}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/devices/{id}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;id&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;platform&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;ipAddr&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;status&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;name&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;longitude&quot; : &quot;Float&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;latitude&quot; : &quot;Float&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;info-url&quot; : &quot;String&quot;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	}<br/>
   * &nbsp;&nbsp;	}<br/>
   * }
   * 
   * 
   * @param apic Apic
   **/
  @Path("/devices")
  @GET
  @RBAC(type = {CRUDEnum.READ}, capability = {"SwagDTUCap"})
  @Produces({"application/vnd.jssdk.swag-dtu.devices+xml;version=1;q=0.01",
      "application/vnd.jssdk.swag-dtu.devices+json;version=1;q=0.01"})
  @Generated(value = "REST Wizard", comments = "yieldTime:100,retryEnabled:false,retryCount:3,audit_detail_enabled:false,generation:0,signature:(QApiContext;QPagingContext;)QPagingResult<QDevice;>;")
  public vnd.jssdk.swagdtu.rest.v1.Devices getAllDevices(@Context UriContext apic) throws Exception;

  /***
   * return current list of devices
   * 
   * @summary return current list of devices
   * 
   * @outputXML 
   * &lt;devices total=&quot;Integer&quot; uri=&quot;/api/jssdk/swag-dtu/current-device-lists&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;device href=&quot;/api/jssdk/swag-dtu/devices/{id}&quot; uri=&quot;/api/jssdk/swag-dtu/current-device-lists/{id}&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;id&gt;Integer&lt;/id&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;platform&gt;String&lt;/platform&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;ipAddr&gt;String&lt;/ipAddr&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;status&gt;String&lt;/status&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;name&gt;String&lt;/name&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;longitude&gt;Float&lt;/longitude&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;latitude&gt;Float&lt;/latitude&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;info-url&gt;String&lt;/info-url&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;/device&gt;<br/>
   * &lt;/devices&gt;
   * 
   * 
   * @outputJSON 
   * {<br/>
   * &nbsp;&nbsp;	&quot;devices&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;@total&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/current-device-lists&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;device&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/devices/{id}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/current-device-lists/{id}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;id&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;platform&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;ipAddr&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;status&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;name&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;longitude&quot; : &quot;Float&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;latitude&quot; : &quot;Float&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;info-url&quot; : &quot;String&quot;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	}<br/>
   * &nbsp;&nbsp;	}<br/>
   * }
   **/
  @Path("/current-device-lists")
  @GET
  @RBAC(type = {CRUDEnum.READ}, capability = {"SwagDTUCap"})
  @Produces({"application/vnd.jssdk.swag-dtu.devices+xml;version=1;q=0.01",
      "application/vnd.jssdk.swag-dtu.devices+json;version=1;q=0.01"})
  @Generated(value = "REST Wizard", comments = "yieldTime:100,retryEnabled:false,retryCount:3,audit_detail_enabled:false,generation:0,signature:()QPagingResult<QDevice;>;")
  public vnd.jssdk.swagdtu.rest.v1.Devices getCurrentDeviceList() throws Exception;

  /***
   * get individual device based on ID
   * 
   * @summary get individual device based on ID
   * 
   * @outputXML 
   * &lt;device href=&quot;/api/jssdk/swag-dtu/devices/{id}&quot; uri=&quot;/api/jssdk/swag-dtu/devices/{id}&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;id&gt;Integer&lt;/id&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;platform&gt;String&lt;/platform&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;ipAddr&gt;String&lt;/ipAddr&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;status&gt;String&lt;/status&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;name&gt;String&lt;/name&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;longitude&gt;Float&lt;/longitude&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;latitude&gt;Float&lt;/latitude&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;info-url&gt;String&lt;/info-url&gt;<br/>
   * &lt;/device&gt;
   * 
   * 
   * @outputJSON 
   * {<br/>
   * &nbsp;&nbsp;	&quot;device&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/devices/{id}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/devices/{id}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;id&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;platform&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;ipAddr&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;status&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;name&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;longitude&quot; : &quot;Float&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;latitude&quot; : &quot;Float&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;info-url&quot; : &quot;String&quot;<br/>
   * &nbsp;&nbsp;	}<br/>
   * }
   * 
   * 
   * @param apic Apic
   * @param id ID
   **/
  @Path("/devices/{id}")
  @GET
  @RBAC(type = {CRUDEnum.READ}, capability = {"SwagDTUCap"})
  @Produces({"application/vnd.jssdk.swag-dtu.device+xml;version=1;q=0.01",
      "application/vnd.jssdk.swag-dtu.device+json;version=1;q=0.01"})
  @Generated(value = "REST Wizard", comments = "yieldTime:100,retryEnabled:false,retryCount:3,audit_detail_enabled:false,generation:0,signature:(QApiContext;I)QDevice;")
  public vnd.jssdk.swagdtu.rest.v1.Device getDevice(@Context UriContext apic,
      @PathParam("id") Integer id) throws Exception;

  /***
   * return current list of links
   * 
   * @summary return current list of links
   * 
   * @outputXML 
   * &lt;links total=&quot;Integer&quot; uri=&quot;/api/jssdk/swag-dtu/current-link-lists&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;link href=&quot;/api/jssdk/swag-dtu/current-link-list/{linkId}&quot; uri=&quot;/api/jssdk/swag-dtu/current-link-lists/{linkId}&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;devAIpAddr&gt;String&lt;/devAIpAddr&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;linkColor&gt;String&lt;/linkColor&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;speedStr&gt;String&lt;/speedStr&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;operationStatus&gt;String&lt;/operationStatus&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;devBName&gt;String&lt;/devBName&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;deviceb href=&quot;/api/jssdk/swag-dtu/devices/{id}&quot; uri=&quot;/api/jssdk/swag-dtu/current-link-lists/{linkId}&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 &lt;id&gt;Integer&lt;/id&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 &lt;name&gt;String&lt;/name&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;/deviceb&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;devicea href=&quot;/api/jssdk/swag-dtu/devices/{id}&quot; uri=&quot;/api/jssdk/swag-dtu/current-link-lists/{linkId}&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 &lt;id&gt;Integer&lt;/id&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 &lt;name&gt;String&lt;/name&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;/devicea&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;linkId&gt;String&lt;/linkId&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;currSpeed&gt;Integer&lt;/currSpeed&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;ptpb href=&quot;/api/jssdk/swag-dtu/ptps/{pTPId}&quot; uri=&quot;/api/jssdk/swag-dtu/current-link-lists/{linkId}&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 &lt;ptpid&gt;Integer&lt;/ptpid&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 &lt;name&gt;String&lt;/name&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;/ptpb&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;devAName&gt;String&lt;/devAName&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;ptpa href=&quot;/api/jssdk/swag-dtu/ptps/{pTPId}&quot; uri=&quot;/api/jssdk/swag-dtu/current-link-lists/{linkId}&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 &lt;ptpid&gt;Integer&lt;/ptpid&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 &lt;name&gt;String&lt;/name&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;/ptpa&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;devBIpAddr&gt;String&lt;/devBIpAddr&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;mtuStr&gt;String&lt;/mtuStr&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;devBInterface&gt;String&lt;/devBInterface&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;devAInterface&gt;String&lt;/devAInterface&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;/link&gt;<br/>
   * &lt;/links&gt;
   * 
   * 
   * @outputJSON 
   * {<br/>
   * &nbsp;&nbsp;	&quot;links&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;@total&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/current-link-lists&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;link&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/current-link-list/{linkId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/current-link-lists/{linkId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;devAIpAddr&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;linkColor&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;speedStr&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;operationStatus&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;devBName&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;deviceb&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/devices/{id}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/current-link-lists/{linkId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;id&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;name&quot; : &quot;String&quot;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	} ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;devicea&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/devices/{id}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/current-link-lists/{linkId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;id&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;name&quot; : &quot;String&quot;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	} ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;linkId&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;currSpeed&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;ptpb&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/ptps/{pTPId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/current-link-lists/{linkId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;ptpid&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;name&quot; : &quot;String&quot;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	} ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;devAName&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;ptpa&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/ptps/{pTPId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/current-link-lists/{linkId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;ptpid&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;name&quot; : &quot;String&quot;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	} ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;devBIpAddr&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;mtuStr&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;devBInterface&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;devAInterface&quot; : &quot;String&quot;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	}<br/>
   * &nbsp;&nbsp;	}<br/>
   * }
   **/
  @Path("/current-link-lists")
  @GET
  @RBAC(type = {CRUDEnum.READ}, capability = {"SwagDTUCap"})
  @Produces({"application/vnd.jssdk.swag-dtu.links+xml;version=1;q=0.01",
      "application/vnd.jssdk.swag-dtu.links+json;version=1;q=0.01"})
  @Generated(value = "REST Wizard", comments = "yieldTime:100,retryEnabled:false,retryCount:3,audit_detail_enabled:false,generation:0,signature:()QPagingResult<QLink;>;")
  public vnd.jssdk.swagdtu.rest.v1.Links getCurrentLinkList() throws Exception;

  /***
   * get single device form list
   * /*
   * Get individual link
   * 
   * @summary get single device form list
   * /*
   * Get individual link
   * 
   * @outputXML 
   * &lt;link href=&quot;/api/jssdk/swag-dtu/current-link-list/{linkId}&quot; uri=&quot;/api/jssdk/swag-dtu/links/{linkId}&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;devAIpAddr&gt;String&lt;/devAIpAddr&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;linkColor&gt;String&lt;/linkColor&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;speedStr&gt;String&lt;/speedStr&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;operationStatus&gt;String&lt;/operationStatus&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;devBName&gt;String&lt;/devBName&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;deviceb href=&quot;/api/jssdk/swag-dtu/devices/{id}&quot; uri=&quot;/api/jssdk/swag-dtu/links/{linkId}&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;id&gt;Integer&lt;/id&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;name&gt;String&lt;/name&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;/deviceb&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;devicea href=&quot;/api/jssdk/swag-dtu/devices/{id}&quot; uri=&quot;/api/jssdk/swag-dtu/links/{linkId}&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;id&gt;Integer&lt;/id&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;name&gt;String&lt;/name&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;/devicea&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;linkId&gt;String&lt;/linkId&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;currSpeed&gt;Integer&lt;/currSpeed&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;ptpb href=&quot;/api/jssdk/swag-dtu/ptps/{pTPId}&quot; uri=&quot;/api/jssdk/swag-dtu/links/{linkId}&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;ptpid&gt;Integer&lt;/ptpid&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;name&gt;String&lt;/name&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;/ptpb&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;devAName&gt;String&lt;/devAName&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;ptpa href=&quot;/api/jssdk/swag-dtu/ptps/{pTPId}&quot; uri=&quot;/api/jssdk/swag-dtu/links/{linkId}&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;ptpid&gt;Integer&lt;/ptpid&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;name&gt;String&lt;/name&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;/ptpa&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;devBIpAddr&gt;String&lt;/devBIpAddr&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;mtuStr&gt;String&lt;/mtuStr&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;devBInterface&gt;String&lt;/devBInterface&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;devAInterface&gt;String&lt;/devAInterface&gt;<br/>
   * &lt;/link&gt;
   * 
   * 
   * @outputJSON 
   * {<br/>
   * &nbsp;&nbsp;	&quot;link&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/current-link-list/{linkId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/links/{linkId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;devAIpAddr&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;linkColor&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;speedStr&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;operationStatus&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;devBName&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;deviceb&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/devices/{id}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/links/{linkId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;id&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;name&quot; : &quot;String&quot;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	} ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;devicea&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/devices/{id}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/links/{linkId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;id&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;name&quot; : &quot;String&quot;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	} ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;linkId&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;currSpeed&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;ptpb&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/ptps/{pTPId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/links/{linkId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;ptpid&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;name&quot; : &quot;String&quot;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	} ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;devAName&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;ptpa&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/ptps/{pTPId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/links/{linkId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;ptpid&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;name&quot; : &quot;String&quot;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	} ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;devBIpAddr&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;mtuStr&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;devBInterface&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;devAInterface&quot; : &quot;String&quot;<br/>
   * &nbsp;&nbsp;	}<br/>
   * }
   * 
   * 
   * @param linkId Link ID
   **/
  @Path("/current-link-lists/{linkId}")
  @GET
  @RBAC(type = {CRUDEnum.READ}, capability = {"SwagDTUCap"})
  @Produces({"application/vnd.jssdk.swag-dtu.link+xml;version=1;q=0.01",
      "application/vnd.jssdk.swag-dtu.link+json;version=1;q=0.01"})
  @Generated(value = "REST Wizard", comments = "yieldTime:100,retryEnabled:false,retryCount:3,audit_detail_enabled:false,generation:0,signature:(QString;)QLink;")
  public vnd.jssdk.swagdtu.rest.v1.Link getLink(@PathParam("linkId") String linkId)
      throws Exception;

  /***
   * return the current LSPs and attributes
   * 
   * @summary return the current LSPs and attributes
   * 
   * @outputXML 
   * &lt;lsps total=&quot;Integer&quot; uri=&quot;/api/jssdk/swag-dtu/current-lsp-lists&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;lsp href=&quot;/api/jssdk/swag-dtu/current-lsp-list/{lspId}&quot; uri=&quot;/api/jssdk/swag-dtu/current-lsp-lists/{lspId}&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;num-hops&gt;Integer&lt;/num-hops&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;speed-avg&gt;Integer&lt;/speed-avg&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;lsp-interface&gt;String&lt;/lsp-interface&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;path-usable&gt;Boolean&lt;/path-usable&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;lowest-mtu&gt;Integer&lt;/lowest-mtu&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;lowest-speed&gt;Integer&lt;/lowest-speed&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;lsp-id&gt;Integer&lt;/lsp-id&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;/lsp&gt;<br/>
   * &lt;/lsps&gt;
   * 
   * 
   * @outputJSON 
   * {<br/>
   * &nbsp;&nbsp;	&quot;lsps&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;@total&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/current-lsp-lists&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	&quot;lsp&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/current-lsp-list/{lspId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/current-lsp-lists/{lspId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;num-hops&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;speed-avg&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;lsp-interface&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;path-usable&quot; : &quot;Boolean&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;lowest-mtu&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;lowest-speed&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;lsp-id&quot; : &quot;Integer&quot;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	}<br/>
   * &nbsp;&nbsp;	}<br/>
   * }
   **/
  @Path("/current-lsp-lists")
  @GET
  @RBAC(type = {CRUDEnum.READ}, capability = {"SwagDTUCap"})
  @Produces({"application/vnd.jssdk.swag-dtu.lsps+xml;version=1;q=0.01",
      "application/vnd.jssdk.swag-dtu.lsps+json;version=1;q=0.01"})
  @Generated(value = "REST Wizard", comments = "yieldTime:100,retryEnabled:false,retryCount:3,audit_detail_enabled:false,generation:0,signature:()QPagingResult<QLSP;>;")
  public vnd.jssdk.swagdtu.rest.v1.LSPs getCurrentLspList() throws Exception;

  /**
   * Root Resource.
   */
  @Path("/")
  @GET
  @Produces({"application/vnd.jssdk.swag-dtu+xml;version=1;q=0.01",
      "application/vnd.jssdk.swag-dtu+json;version=1;q=0.01"})
  @RBAC(type = {CRUDEnum.READ}, capability = {"DefaultRead"})
  public SwagDTURest getRoot();
}
