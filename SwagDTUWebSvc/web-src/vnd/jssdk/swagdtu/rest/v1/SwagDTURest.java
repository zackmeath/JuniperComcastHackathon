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
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;speed-str&gt;String&lt;/speed-str&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;managed-device-id&gt;Integer&lt;/managed-device-id&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;speed&gt;Integer&lt;/speed&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;tagging&gt;String&lt;/tagging&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;admin-status&gt;String&lt;/admin-status&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;operation-status&gt;String&lt;/operation-status&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;device-id&gt;Integer&lt;/device-id&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;link-type&gt;String&lt;/link-type&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;mac-address&gt;String&lt;/mac-address&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;id&gt;Integer&lt;/id&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;ptpid&gt;Integer&lt;/ptpid&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;loopback-enabled&gt;String&lt;/loopback-enabled&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;managed-dev-ip-address&gt;String&lt;/managed-dev-ip-address&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;link-level-type&gt;String&lt;/link-level-type&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;description&gt;String&lt;/description&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;name&gt;String&lt;/name&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;mtu-str&gt;String&lt;/mtu-str&gt;<br/>
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
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;speed-str&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;managed-device-id&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;speed&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;tagging&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;admin-status&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;operation-status&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;device-id&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;link-type&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;mac-address&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;id&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;ptpid&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;loopback-enabled&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;managed-dev-ip-address&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;link-level-type&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;description&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;name&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;mtu-str&quot; : &quot;String&quot; ,<br/>
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
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;speed-str&gt;String&lt;/speed-str&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;managed-device-id&gt;Integer&lt;/managed-device-id&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;speed&gt;Integer&lt;/speed&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;tagging&gt;String&lt;/tagging&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;admin-status&gt;String&lt;/admin-status&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;operation-status&gt;String&lt;/operation-status&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;device-id&gt;Integer&lt;/device-id&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;link-type&gt;String&lt;/link-type&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;mac-address&gt;String&lt;/mac-address&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;id&gt;Integer&lt;/id&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;ptpid&gt;Integer&lt;/ptpid&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;loopback-enabled&gt;String&lt;/loopback-enabled&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;managed-dev-ip-address&gt;String&lt;/managed-dev-ip-address&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;link-level-type&gt;String&lt;/link-level-type&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;description&gt;String&lt;/description&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;name&gt;String&lt;/name&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;mtu-str&gt;String&lt;/mtu-str&gt;<br/>
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
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;speed-str&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;managed-device-id&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;speed&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;tagging&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;admin-status&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;operation-status&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;device-id&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;link-type&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;mac-address&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;id&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;ptpid&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;loopback-enabled&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;managed-dev-ip-address&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;link-level-type&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;description&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;name&quot; : &quot;String&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;mtu-str&quot; : &quot;String&quot; ,<br/>
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
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;ip-addr&gt;String&lt;/ip-addr&gt;<br/>
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
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;ip-addr&quot; : &quot;String&quot; ,<br/>
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
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;ip-addr&gt;String&lt;/ip-addr&gt;<br/>
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
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;ip-addr&quot; : &quot;String&quot; ,<br/>
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
   * return current list of links
   * 
   * @summary return current list of links
   * 
   * @outputXML 
   * &lt;links total=&quot;Integer&quot; uri=&quot;/api/jssdk/swag-dtu/current-link-lists&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;	 &lt;link href=&quot;/api/jssdk/swag-dtu/current-link-list&quot; uri=&quot;/api/jssdk/swag-dtu/current-link-lists&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;ptpb href=&quot;/api/jssdk/swag-dtu/ptps/{pTPId}&quot; uri=&quot;/api/jssdk/swag-dtu/current-link-lists&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 &lt;ptpid&gt;Integer&lt;/ptpid&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 &lt;name&gt;String&lt;/name&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;/ptpb&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;ptpa href=&quot;/api/jssdk/swag-dtu/ptps/{pTPId}&quot; uri=&quot;/api/jssdk/swag-dtu/current-link-lists&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 &lt;ptpid&gt;Integer&lt;/ptpid&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 &lt;name&gt;String&lt;/name&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;/ptpa&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;deviceb href=&quot;/api/jssdk/swag-dtu/devices/{id}&quot; uri=&quot;/api/jssdk/swag-dtu/current-link-lists&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 &lt;id&gt;Integer&lt;/id&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 &lt;name&gt;String&lt;/name&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;/deviceb&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;devicea href=&quot;/api/jssdk/swag-dtu/devices/{id}&quot; uri=&quot;/api/jssdk/swag-dtu/current-link-lists&quot;&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 &lt;id&gt;Integer&lt;/id&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 &lt;name&gt;String&lt;/name&gt;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&lt;/devicea&gt;<br/>
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
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/current-link-list&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/current-link-lists&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;ptpb&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/ptps/{pTPId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/current-link-lists&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;ptpid&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;name&quot; : &quot;String&quot;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	} ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;ptpa&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/ptps/{pTPId}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/current-link-lists&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;ptpid&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;name&quot; : &quot;String&quot;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	} ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;deviceb&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/devices/{id}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/current-link-lists&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;id&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;name&quot; : &quot;String&quot;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	} ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;devicea&quot; : {<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@href&quot; : &quot;/api/jssdk/swag-dtu/devices/{id}&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;@uri&quot; : &quot;/api/jssdk/swag-dtu/current-link-lists&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;id&quot; : &quot;Integer&quot; ,<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&quot;name&quot; : &quot;String&quot;<br/>
   * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	}<br/>
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
