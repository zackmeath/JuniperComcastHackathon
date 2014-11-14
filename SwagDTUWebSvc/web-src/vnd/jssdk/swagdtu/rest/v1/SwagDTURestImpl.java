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
  @Generated(value = "REST Wizard", comments = "source:vnd.jssdk.swagdtu.rest.v1.SwagDTURest,type:method")
  @HATEOASMethod(href = "/images", description = "images")
  @XmlElement(name = "images")
  private HATEOASMethodObject postaddImage;
  @Generated(value = "REST Wizard", comments = "source:vnd.jssdk.swagdtu.rest.v1.SwagDTURest,type:collection")
  @HATEOASMethod(href = "/ptps", description = "ptps")
  @XmlElement(name = "ptps")
  private HATEOASMethodObject getgetAllPtpsptps;
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
   * <b>Method:</b>getAllPtps
   *
   * <b>Description:</b> This is an  auto generated method with stub
   * implementation which uses the <code>vnd.jssdk.swagdtu.SwagDTU</code> EJB bean and exposes
   * it's method with Rest web services interface.
   * @param apic UriContext
   * @return vnd.jssdk.swagdtu.rest.v1.PTPs
   */
  public PTPs getAllPtps(UriContext apic) throws Exception {
    //GeneralMethodGenerator
    vnd.jssdk.swagdtu.rest.v1.PTPs pTPs = new vnd.jssdk.swagdtu.rest.v1.PTPs();
    try {

      // Call bean method: getAllPtps
      net.juniper.jmp.PagingResult<vnd.jssdk.swagdtu.PTP> ejbPTPList = null;
      ejbPTPList = getBean().getAllPtps(apic.getApicontext(), apic.getPagingCtxt());

      java.util.ArrayList<vnd.jssdk.swagdtu.rest.v1.PTPs.PTP> restPTPs =
          new java.util.ArrayList<vnd.jssdk.swagdtu.rest.v1.PTPs.PTP>();
      if (ejbPTPList != null) {
        for (vnd.jssdk.swagdtu.PTP ptp : ejbPTPList) {
          vnd.jssdk.swagdtu.rest.v1.PTPs.PTP restPTP = new vnd.jssdk.swagdtu.rest.v1.PTPs.PTP();
          restPTP.copyFrom(ptp);
          restPTPs.add(restPTP);
        }
        pTPs.setTotalSize(ejbPTPList.getPagingContext().getTotalRecords());
      } else
        pTPs.setTotalSize(0);
      pTPs.setPTPs(restPTPs);
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

    return pTPs;
  }

  /**
   * <pre>
   * <b>Method:</b>getDevice
   *
   * <b>Description:</b> This is an  auto generated method with stub
   * implementation which uses the <code>vnd.jssdk.swagdtu.SwagDTU</code> EJB bean and exposes
   * it's method with Rest web services interface.
   * @param apic UriContext
   * @param id Integer
   * @return vnd.jssdk.swagdtu.rest.v1.Device
   */
  public Device getDevice(UriContext apic, Integer id) throws Exception {
    //GeneralMethodGenerator
    vnd.jssdk.swagdtu.rest.v1.Device retDevice = new vnd.jssdk.swagdtu.rest.v1.Device();
    try {

      // Call bean method: getDevice
      vnd.jssdk.swagdtu.Device beanDevice = null;
      beanDevice = getBean().getDevice(apic.getApicontext(), id == null ? 0 : id);

      // Prepare return value: retDevice
      retDevice.copyFrom(beanDevice);
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

    return retDevice;
  }

  /**
   * <pre>
   * <b>Method:</b>getPtp
   *
   * <b>Description:</b> This is an  auto generated method with stub
   * implementation which uses the <code>vnd.jssdk.swagdtu.SwagDTU</code> EJB bean and exposes
   * it's method with Rest web services interface.
   * @param apic UriContext
   * @param id Integer
   * @return vnd.jssdk.swagdtu.rest.v1.PTP
   */
  public PTP getPtp(UriContext apic, Integer id) throws Exception {
    //GeneralMethodGenerator
    vnd.jssdk.swagdtu.rest.v1.PTP retPTP = new vnd.jssdk.swagdtu.rest.v1.PTP();
    try {

      // Call bean method: getPtp
      vnd.jssdk.swagdtu.PTP beanPTP = null;
      beanPTP = getBean().getPtp(apic.getApicontext(), id == null ? 0 : id);

      // Prepare return value: retPTP
      retPTP.copyFrom(beanPTP);
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

    return retPTP;
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
   * <b>Method:</b>addImage
   *
   * <b>Description:</b> This is an  auto generated method with stub
   * implementation which uses the <code>vnd.jssdk.swagdtu.SwagDTU</code> EJB bean and exposes
   * it's method with Rest web services interface.
   * @param imageFileBytes org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput
   * @param imageFile String
   */
  public void addImage(
      org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput imageFileBytes,
      String imageFile) throws Exception {
    //MultiPartImplementationMethodGenerator
    try {

      // Prepare EJB parameter: ejbImageFileBytes (by imageFileBytes)
      byte[] ejbImageFileBytes = null;
      java.util.Map<String, java.util.List<org.jboss.resteasy.plugins.providers.multipart.InputPart>> uploadForm =
          imageFileBytes.getFormDataMap();
      java.util.List<org.jboss.resteasy.plugins.providers.multipart.InputPart> imageFileBytesInputParts =
          uploadForm.values().iterator().next();
      if (imageFileBytesInputParts.size() > 0) {
        org.jboss.resteasy.plugins.providers.multipart.InputPart inputPart =
            imageFileBytesInputParts.get(0);
        java.io.InputStream inputStream = inputPart.getBody(java.io.InputStream.class, null);
        byte[] bytes = org.apache.commons.io.IOUtils.toByteArray(inputStream);
        ejbImageFileBytes = bytes;
      }

      // Call bean method: addImage
      for (int i = 0; i < 3; i++) {
        try {
          getBean().addImage(ejbImageFileBytes, imageFile);
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
