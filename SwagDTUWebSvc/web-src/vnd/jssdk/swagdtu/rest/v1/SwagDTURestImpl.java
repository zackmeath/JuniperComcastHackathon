package vnd.jssdk.swagdtu.rest.v1;

import net.juniper.jmp.parsers.common.UriContext;
import net.juniper.jmp.interceptors.hateoas.HATEOASMethodObject;
import javax.xml.bind.annotation.XmlElement;
import net.juniper.jmp.interceptors.hateoas.HATEOASMethod;
import org.apache.log4j.Logger;
import javax.annotation.Generated;
import javax.ws.rs.WebApplicationException;
import javax.ejb.EJBException;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.ws.rs.core.Response;
import net.juniper.jmp.cmp.system.JxServiceLocator;
import net.juniper.jmp.websvc.helper.JSAuditlogHelper;
import net.juniper.jmp.cmp.async.Task;
import net.juniper.jmp.websvc.common.WebSvcAbstract;
import javax.persistence.OptimisticLockException;

/*******************************************************************************
 *
 * @ServiceName Swag DTU
 *
 ******************************************************************************/
@XmlRootElement(name = "swag-dtu")
@XmlAccessorType(XmlAccessType.NONE)
@Generated(value = "Rest Implementation", comments = "invalid:")
public class SwagDTURestImpl extends WebSvcAbstract implements SwagDTURest {

  /**
   * logger instance to log messages
   **/
  @SuppressWarnings("unused")
  private static final Logger logger = Logger.getLogger(SwagDTURestImpl.class);
  vnd.jssdk.swagdtu.SwagDTU swagdtu = null;
  @Generated(value = "REST Wizard", comments = "source:vnd.jssdk.swagdtu.rest.v1.SwagDTURest,type:collection")
  @HATEOASMethod(href = "/current-link-lists", description = "current-link-lists")
  @XmlElement(name = "current-link-lists")
  private HATEOASMethodObject getgetCurrentLinkListlinks;
  @Generated(value = "REST Wizard", comments = "source:vnd.jssdk.swagdtu.rest.v1.SwagDTURest,type:collection")
  @HATEOASMethod(href = "/ptps", description = "ptps")
  @XmlElement(name = "ptps")
  private HATEOASMethodObject getgetAllPtpsptps;
  @Generated(value = "REST Wizard", comments = "source:vnd.jssdk.swagdtu.rest.v1.SwagDTURest,type:collection")
  @HATEOASMethod(href = "/current-ptp-lists", description = "current-ptp-lists")
  @XmlElement(name = "current-ptp-lists")
  private HATEOASMethodObject getgetCurrentPtpListptps;
  @Generated(value = "REST Wizard", comments = "source:vnd.jssdk.swagdtu.rest.v1.SwagDTURest,type:method")
  @HATEOASMethod(href = "/refresh-topology", description = "refresh-topology")
  @XmlElement(name = "refresh-topology")
  private HATEOASMethodObject postrefreshTopology;
  @Generated(value = "REST Wizard", comments = "source:vnd.jssdk.swagdtu.rest.v1.SwagDTURest,type:collection")
  @HATEOASMethod(href = "/current-device-lists", description = "current-device-lists")
  @XmlElement(name = "current-device-lists")
  private HATEOASMethodObject getgetCurrentDeviceListdevices;
  @Generated(value = "REST Wizard", comments = "source:vnd.jssdk.swagdtu.rest.v1.SwagDTURest,type:collection")
  @HATEOASMethod(href = "/devices", description = "devices")
  @XmlElement(name = "devices")
  private HATEOASMethodObject getgetAllDevicesdevices;

  /**
   * default constructor
   */
  public SwagDTURestImpl() {
    swagdtu = getBean();
  }

  /**
   * <pre>
   * <b>Method:</b>getImage
   *
   * <b>Description:</b> This is an  auto generated method with stub
   * implementation which uses the <code>vnd.jssdk.swagdtu.SwagDTU</code> EJB bean and exposes
   * it's method with Rest web services interface.
   * @param platform String
   * @return vnd.jssdk.swagdtu.rest.v1.Images
   */
  public javax.ws.rs.core.Response getImage(String platform) throws Exception {
    //MultiPartImplementationMethodGenerator
    javax.ws.rs.core.Response retResponseBuilder = null;
    try {

      // Call bean method: getImage
      byte[] beanMultiPart = null;
      beanMultiPart = getBean().getImage(platform);

      if (beanMultiPart != null) {
        javax.ws.rs.core.Response.ResponseBuilder retResponseBuilderBuilder =
            javax.ws.rs.core.Response.ok(new java.io.ByteArrayInputStream(beanMultiPart));
        retResponseBuilder = retResponseBuilderBuilder.build();
      }
    } catch (WebApplicationException e) {
      Response response = e.getResponse();
      JSAuditlogHelper.addDescriptionToAuditLog((response != null && response.getEntity() != null)
          ? response.getEntity().toString()
          : e.getMessage());
      throw e;
    } catch (EJBException e) {
      if (e.getCause() instanceof WebApplicationException) {
        Response response = ((WebApplicationException) e.getCause()).getResponse();
        JSAuditlogHelper
            .addDescriptionToAuditLog((response != null && response.getEntity() != null) ? response
                .getEntity().toString() : ((WebApplicationException) e.getCause()).getMessage());
        throw (WebApplicationException) e.getCause();
      }
      JSAuditlogHelper.addDescriptionToAuditLog(e.getMessage());
      throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
          .entity(e.getMessage()).build());
    } catch (Exception e) {
      JSAuditlogHelper.addDescriptionToAuditLog(e.getMessage());
      throw e;
    }

    return retResponseBuilder;
  }

  /**
   * <pre>
   * <b>Method:</b>refreshTopology
   *
   * <b>Description:</b> This is an  auto generated method with stub
   * implementation which uses the <code>vnd.jssdk.swagdtu.SwagDTU</code> EJB bean and exposes
   * it's method with Rest web services interface.
   * @param apiCtx UriContext
   */
  public Task refreshTopology(UriContext apiCtx) throws Exception {
    //GeneralMethodGenerator
    Task task = null;
    try {

      // Call bean method: refreshTopology
      net.juniper.jmp.cmp.jobManager.JobInfoTO ejbJobInfoTO = null;
      for (int i = 0; i < 3; i++) {
        try {
          ejbJobInfoTO =
              getBean().refreshTopology(
                  apiCtx.getApicontext(),
                  org.jboss.resteasy.spi.ResteasyProviderFactory
                      .getContextData(net.juniper.jmp.ScheduleContext.class));
          break;
        } catch (java.lang.Exception e) {
          if (net.juniper.jmp.cmp.jobManager.InfoSender.isOptimisticLockException(e)) {
            if ((i + 1) == 3) {
              throw new OptimisticLockException("EJB method call fails after 3 retries", e);
            }
            Thread.sleep(100);
            continue;
          }
          throw e;
        }
      }

      task = new net.juniper.jmp.cmp.async.Task();
      task.setId(ejbJobInfoTO.getId());
    } catch (WebApplicationException e) {
      Response response = e.getResponse();
      JSAuditlogHelper.addDescriptionToAuditLog((response != null && response.getEntity() != null)
          ? response.getEntity().toString()
          : e.getMessage());
      throw e;
    } catch (EJBException e) {
      if (e.getCause() instanceof WebApplicationException) {
        Response response = ((WebApplicationException) e.getCause()).getResponse();
        JSAuditlogHelper
            .addDescriptionToAuditLog((response != null && response.getEntity() != null) ? response
                .getEntity().toString() : ((WebApplicationException) e.getCause()).getMessage());
        throw (WebApplicationException) e.getCause();
      }
      JSAuditlogHelper.addDescriptionToAuditLog(e.getMessage());
      throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
          .entity(e.getMessage()).build());
    } catch (Exception e) {
      JSAuditlogHelper.addDescriptionToAuditLog(e.getMessage());
      throw e;
    }

    return task;
  }

  /**
   * <pre>
   * <b>Method:</b>getAllPtps
   *
   * <b>Description:</b> This is an  auto generated method with stub
   * implementation which uses the <code>vnd.jssdk.swagdtu.SwagDTU</code> EJB bean and exposes
   * it's method with Rest web services interface.
   * @param apic UriContext
   * @return vnd.jssdk.swagdtu.rest.v1.Ptps
   */
  public Ptps getAllPtps(UriContext apic) throws Exception {
    //GeneralMethodGenerator
    vnd.jssdk.swagdtu.rest.v1.Ptps ptps = new vnd.jssdk.swagdtu.rest.v1.Ptps();
    try {

      // Call bean method: getAllPtps
      net.juniper.jmp.PagingResult<vnd.jssdk.swagdtu.PTP> ejbPTPList = null;
      ejbPTPList = getBean().getAllPtps(apic.getApicontext(), apic.getPagingCtxt());

      java.util.ArrayList<vnd.jssdk.swagdtu.rest.v1.Ptps.PTP> restPtps =
          new java.util.ArrayList<vnd.jssdk.swagdtu.rest.v1.Ptps.PTP>();
      if (ejbPTPList != null) {
        for (vnd.jssdk.swagdtu.PTP ptp : ejbPTPList) {
          vnd.jssdk.swagdtu.rest.v1.Ptps.PTP restPTP = new vnd.jssdk.swagdtu.rest.v1.Ptps.PTP();
          restPTP.copyFrom(ptp);
          restPtps.add(restPTP);
        }
        ptps.setTotalSize(ejbPTPList.getPagingContext().getTotalRecords());
      } else
        ptps.setTotalSize(0);
      ptps.setPTPs(restPtps);
    } catch (WebApplicationException e) {
      Response response = e.getResponse();
      JSAuditlogHelper.addDescriptionToAuditLog((response != null && response.getEntity() != null)
          ? response.getEntity().toString()
          : e.getMessage());
      throw e;
    } catch (EJBException e) {
      if (e.getCause() instanceof WebApplicationException) {
        Response response = ((WebApplicationException) e.getCause()).getResponse();
        JSAuditlogHelper
            .addDescriptionToAuditLog((response != null && response.getEntity() != null) ? response
                .getEntity().toString() : ((WebApplicationException) e.getCause()).getMessage());
        throw (WebApplicationException) e.getCause();
      }
      JSAuditlogHelper.addDescriptionToAuditLog(e.getMessage());
      throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
          .entity(e.getMessage()).build());
    } catch (Exception e) {
      JSAuditlogHelper.addDescriptionToAuditLog(e.getMessage());
      throw e;
    }

    return ptps;
  }

  /**
   * <pre>
   * <b>Method:</b>getCurrentPtpList
   *
   * <b>Description:</b> This is an  auto generated method with stub
   * implementation which uses the <code>vnd.jssdk.swagdtu.SwagDTU</code> EJB bean and exposes
   * it's method with Rest web services interface.
   * @return vnd.jssdk.swagdtu.rest.v1.Ptps
   */
  public Ptps getCurrentPtpList() throws Exception {
    //GeneralMethodGenerator
    vnd.jssdk.swagdtu.rest.v1.Ptps ptps = new vnd.jssdk.swagdtu.rest.v1.Ptps();
    try {

      // Call bean method: getCurrentPtpList
      net.juniper.jmp.PagingResult<vnd.jssdk.swagdtu.PTP> ejbPTPList = null;
      ejbPTPList = getBean().getCurrentPtpList();

      java.util.ArrayList<vnd.jssdk.swagdtu.rest.v1.Ptps.PTP> restPtps =
          new java.util.ArrayList<vnd.jssdk.swagdtu.rest.v1.Ptps.PTP>();
      if (ejbPTPList != null) {
        for (vnd.jssdk.swagdtu.PTP ptp : ejbPTPList) {
          vnd.jssdk.swagdtu.rest.v1.Ptps.PTP restPTP = new vnd.jssdk.swagdtu.rest.v1.Ptps.PTP();
          restPTP.copyFrom(ptp);
          restPtps.add(restPTP);
        }
        ptps.setTotalSize(ejbPTPList.getPagingContext().getTotalRecords());
      } else
        ptps.setTotalSize(0);
      ptps.setPTPs(restPtps);
    } catch (WebApplicationException e) {
      Response response = e.getResponse();
      JSAuditlogHelper.addDescriptionToAuditLog((response != null && response.getEntity() != null)
          ? response.getEntity().toString()
          : e.getMessage());
      throw e;
    } catch (EJBException e) {
      if (e.getCause() instanceof WebApplicationException) {
        Response response = ((WebApplicationException) e.getCause()).getResponse();
        JSAuditlogHelper
            .addDescriptionToAuditLog((response != null && response.getEntity() != null) ? response
                .getEntity().toString() : ((WebApplicationException) e.getCause()).getMessage());
        throw (WebApplicationException) e.getCause();
      }
      JSAuditlogHelper.addDescriptionToAuditLog(e.getMessage());
      throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
          .entity(e.getMessage()).build());
    } catch (Exception e) {
      JSAuditlogHelper.addDescriptionToAuditLog(e.getMessage());
      throw e;
    }

    return ptps;
  }

  /**
   * <pre>
   * <b>Method:</b>getAllDevices
   *
   * <b>Description:</b> This is an  auto generated method with stub
   * implementation which uses the <code>vnd.jssdk.swagdtu.SwagDTU</code> EJB bean and exposes
   * it's method with Rest web services interface.
   * @param apic UriContext
   * @return vnd.jssdk.swagdtu.rest.v1.Devices
   */
  public Devices getAllDevices(UriContext apic) throws Exception {
    //GeneralMethodGenerator
    vnd.jssdk.swagdtu.rest.v1.Devices devices = new vnd.jssdk.swagdtu.rest.v1.Devices();
    try {

      // Call bean method: getAllDevices
      net.juniper.jmp.PagingResult<vnd.jssdk.swagdtu.Device> ejbDeviceList = null;
      ejbDeviceList = getBean().getAllDevices(apic.getApicontext(), apic.getPagingCtxt());

      java.util.ArrayList<vnd.jssdk.swagdtu.rest.v1.Devices.Device> restDevices =
          new java.util.ArrayList<vnd.jssdk.swagdtu.rest.v1.Devices.Device>();
      if (ejbDeviceList != null) {
        for (vnd.jssdk.swagdtu.Device device : ejbDeviceList) {
          vnd.jssdk.swagdtu.rest.v1.Devices.Device restDevice =
              new vnd.jssdk.swagdtu.rest.v1.Devices.Device();
          restDevice.copyFrom(device);
          restDevices.add(restDevice);
        }
        devices.setTotalSize(ejbDeviceList.getPagingContext().getTotalRecords());
      } else
        devices.setTotalSize(0);
      devices.setDevices(restDevices);
    } catch (WebApplicationException e) {
      Response response = e.getResponse();
      JSAuditlogHelper.addDescriptionToAuditLog((response != null && response.getEntity() != null)
          ? response.getEntity().toString()
          : e.getMessage());
      throw e;
    } catch (EJBException e) {
      if (e.getCause() instanceof WebApplicationException) {
        Response response = ((WebApplicationException) e.getCause()).getResponse();
        JSAuditlogHelper
            .addDescriptionToAuditLog((response != null && response.getEntity() != null) ? response
                .getEntity().toString() : ((WebApplicationException) e.getCause()).getMessage());
        throw (WebApplicationException) e.getCause();
      }
      JSAuditlogHelper.addDescriptionToAuditLog(e.getMessage());
      throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
          .entity(e.getMessage()).build());
    } catch (Exception e) {
      JSAuditlogHelper.addDescriptionToAuditLog(e.getMessage());
      throw e;
    }

    return devices;
  }

  /**
   * <pre>
   * <b>Method:</b>getCurrentDeviceList
   *
   * <b>Description:</b> This is an  auto generated method with stub
   * implementation which uses the <code>vnd.jssdk.swagdtu.SwagDTU</code> EJB bean and exposes
   * it's method with Rest web services interface.
   * @return vnd.jssdk.swagdtu.rest.v1.Devices
   */
  public Devices getCurrentDeviceList() throws Exception {
    //GeneralMethodGenerator
    vnd.jssdk.swagdtu.rest.v1.Devices devices = new vnd.jssdk.swagdtu.rest.v1.Devices();
    try {

      // Call bean method: getCurrentDeviceList
      net.juniper.jmp.PagingResult<vnd.jssdk.swagdtu.Device> ejbDeviceList = null;
      ejbDeviceList = getBean().getCurrentDeviceList();

      java.util.ArrayList<vnd.jssdk.swagdtu.rest.v1.Devices.Device> restDevices =
          new java.util.ArrayList<vnd.jssdk.swagdtu.rest.v1.Devices.Device>();
      if (ejbDeviceList != null) {
        for (vnd.jssdk.swagdtu.Device device : ejbDeviceList) {
          vnd.jssdk.swagdtu.rest.v1.Devices.Device restDevice =
              new vnd.jssdk.swagdtu.rest.v1.Devices.Device();
          restDevice.copyFrom(device);
          restDevices.add(restDevice);
        }
        devices.setTotalSize(ejbDeviceList.getPagingContext().getTotalRecords());
      } else
        devices.setTotalSize(0);
      devices.setDevices(restDevices);
    } catch (WebApplicationException e) {
      Response response = e.getResponse();
      JSAuditlogHelper.addDescriptionToAuditLog((response != null && response.getEntity() != null)
          ? response.getEntity().toString()
          : e.getMessage());
      throw e;
    } catch (EJBException e) {
      if (e.getCause() instanceof WebApplicationException) {
        Response response = ((WebApplicationException) e.getCause()).getResponse();
        JSAuditlogHelper
            .addDescriptionToAuditLog((response != null && response.getEntity() != null) ? response
                .getEntity().toString() : ((WebApplicationException) e.getCause()).getMessage());
        throw (WebApplicationException) e.getCause();
      }
      JSAuditlogHelper.addDescriptionToAuditLog(e.getMessage());
      throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
          .entity(e.getMessage()).build());
    } catch (Exception e) {
      JSAuditlogHelper.addDescriptionToAuditLog(e.getMessage());
      throw e;
    }

    return devices;
  }

  /**
   * <pre>
   * <b>Method:</b>getCurrentLinkList
   *
   * <b>Description:</b> This is an  auto generated method with stub
   * implementation which uses the <code>vnd.jssdk.swagdtu.SwagDTU</code> EJB bean and exposes
   * it's method with Rest web services interface.
   * @return vnd.jssdk.swagdtu.rest.v1.Links
   */
  public Links getCurrentLinkList() throws Exception {
    //GeneralMethodGenerator
    vnd.jssdk.swagdtu.rest.v1.Links links = new vnd.jssdk.swagdtu.rest.v1.Links();
    try {

      // Call bean method: getCurrentLinkList
      net.juniper.jmp.PagingResult<vnd.jssdk.swagdtu.Link> ejbLinkList = null;
      ejbLinkList = getBean().getCurrentLinkList();

      java.util.ArrayList<vnd.jssdk.swagdtu.rest.v1.Links.Link> restLinks =
          new java.util.ArrayList<vnd.jssdk.swagdtu.rest.v1.Links.Link>();
      if (ejbLinkList != null) {
        for (vnd.jssdk.swagdtu.Link link : ejbLinkList) {
          vnd.jssdk.swagdtu.rest.v1.Links.Link restLink =
              new vnd.jssdk.swagdtu.rest.v1.Links.Link();
          restLink.copyFrom(link);
          restLinks.add(restLink);
        }
        links.setTotalSize(ejbLinkList.getPagingContext().getTotalRecords());
      } else
        links.setTotalSize(0);
      links.setLinks(restLinks);
    } catch (WebApplicationException e) {
      Response response = e.getResponse();
      JSAuditlogHelper.addDescriptionToAuditLog((response != null && response.getEntity() != null)
          ? response.getEntity().toString()
          : e.getMessage());
      throw e;
    } catch (EJBException e) {
      if (e.getCause() instanceof WebApplicationException) {
        Response response = ((WebApplicationException) e.getCause()).getResponse();
        JSAuditlogHelper
            .addDescriptionToAuditLog((response != null && response.getEntity() != null) ? response
                .getEntity().toString() : ((WebApplicationException) e.getCause()).getMessage());
        throw (WebApplicationException) e.getCause();
      }
      JSAuditlogHelper.addDescriptionToAuditLog(e.getMessage());
      throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
          .entity(e.getMessage()).build());
    } catch (Exception e) {
      JSAuditlogHelper.addDescriptionToAuditLog(e.getMessage());
      throw e;
    }

    return links;
  }

  /**
   * Create the bean instance
   * @return vnd.jssdk.swagdtu.SwagDTU
   */
  private vnd.jssdk.swagdtu.SwagDTU getBean() {
    if (swagdtu == null) {
      swagdtu = JxServiceLocator.lookup("SwagDTU");
    }
    return swagdtu;
  }

  /**
   * Return the new instance
   * @return SwagDTURest
   */
  public SwagDTURest getRoot() {
    return new SwagDTURestImpl();
  }
}
