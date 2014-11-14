package vnd.jssdk.swagdtu.rest.v1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import net.juniper.jmp.interceptors.hateoas.HATEOAS;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import net.juniper.jmp.interceptors.hateoas.HATEOAS.LinkTypeEnum;
import net.juniper.jmp.parsers.annotations.Sortable;
import net.juniper.jmp.interceptors.hateoas.Title;
import javax.annotation.Generated;


/***
 * @MediaType application/vnd.jssdk.swag-dtu.device-refs/v1
 **/

@XmlRootElement(name = "devices")
@XmlAccessorType(XmlAccessType.NONE)
@Generated(value = "Generated", comments = "isEnvelope:false,isReference:false,generation:0,checked:devices")
public class Device_REFs {

  public void copyFrom(net.juniper.jmp.PagingResult<vnd.jssdk.swagdtu.Device> bean) {
    if (bean == null) {
      return;
    }

    // copy collection property: vnd.jssdk.swagdtu.rest.v1.Device_REFs.Device vnd.jssdk.swagdtu.Device
    java.util.Collection<vnd.jssdk.swagdtu.rest.v1.Device_REFs.Device> devices =
        new java.util.ArrayList<vnd.jssdk.swagdtu.rest.v1.Device_REFs.Device>();
    if (bean != null) {
      for (vnd.jssdk.swagdtu.Device element : bean) {
        vnd.jssdk.swagdtu.rest.v1.Device_REFs.Device newelement =
            new vnd.jssdk.swagdtu.rest.v1.Device_REFs.Device();
        newelement.copyFrom(element);
        devices.add(newelement);
      }
    }
    this.setDevices(devices);
  }



  @XmlElement(name = "device", required = true)
  @HATEOAS(uri = "/{id}", href = "/api/jssdk/swag-dtu/devices/{id}", context = LinkTypeEnum.GLOBAL)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Devices,readOnly:false")
  @Title(name = "Devices")
  private java.util.Collection<vnd.jssdk.swagdtu.rest.v1.Device_REFs.Device> devices;


  @XmlAttribute(name = "uri", required = false)
  @HATEOAS(uri = "")
  @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:String,readOnly:true")
  private String uri;


  @XmlAttribute(name = "total", required = false)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:int,readOnly:true")
  private Integer totalSize;


  /**
   * @param devices
   */
  public void setDevices(java.util.Collection<vnd.jssdk.swagdtu.rest.v1.Device_REFs.Device> devices) {
    this.devices = devices;
  }

  /**
   * @return java.util.Collection<vnd.jssdk.swagdtu.rest.v1.Device_REFs.Device>
   */
  public java.util.Collection<vnd.jssdk.swagdtu.rest.v1.Device_REFs.Device> getDevices() {
    return devices;
  }

  /**
   * @param uri
   */
  public void setUri(String uri) {
    this.uri = uri;
  }

  /**
   * @return String
   */
  public String getUri() {
    return uri;
  }

  /**
   * @param totalSize
   */
  public void setTotalSize(Integer totalSize) {
    this.totalSize = totalSize;
  }

  /**
   * @return Integer
   */
  public Integer getTotalSize() {
    return totalSize;
  }



  public String getAuditDetail() {
    return "";
  }



  @XmlType(name = "gen_devices-devices")
  @XmlAccessorType(XmlAccessType.NONE)
  @Generated(value = "Generated", comments = "isEnvelope:false,unchecked:[platform&#44;ipAddr&#44;status&#44;longitude&#44;latitude&#44;infoUrl],source:vnd.jssdk.swagdtu.Device,isReference:true,generation:0")
  public static class Device {

    public void copyFrom(vnd.jssdk.swagdtu.Device bean) {
      if (bean == null) {
        return;
      }
      this.setId(bean.getId());
      this.setName(bean.getName());
    }


    /***
     * Device ID
     * 
     * @key 
     **/

    @XmlElement(name = "id", required = false, type = Integer.class)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:ID,javaname:int,readOnly:true,defaultValue:0,ejbType:I")
    @Title(name = "ID")
    private Integer id;

    /***
     * Device Name
     **/

    @XmlElement(name = "name", required = false)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Name,javaname:String,readOnly:true,ejbType:java.lang.String")
    @Title(name = "Name")
    private String name;

    /***
     * @HyperlinkTemplate /api/jssdk/swag-dtu/ptps/{id}
     **/

    @XmlAttribute(name = "uri", required = false)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:String,readOnly:true")
    private String uri;

    /***
     * @HyperlinkTemplate /api/jssdk/swag-dtu/devices/{id}
     **/

    @XmlAttribute(name = "href", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:String,readOnly:false")
    private String link;


    /**
     * @param id
     */
    public void setId(Integer id) {
      this.id = id;
    }

    /**
     * @return Integer
     */
    @Sortable(moAttrName = "id")
    public Integer getId() {
      return id;
    }

    /**
     * @param name
     */
    public void setName(String name) {
      this.name = name;
    }

    /**
     * @return String
     */
    @Sortable(moAttrName = "name")
    public String getName() {
      return name;
    }

    /**
     * @param uri
     */
    public void setUri(String uri) {
      this.uri = uri;
    }

    /**
     * @return String
     */
    public String getUri() {
      return uri;
    }

    /**
     * @param link
     */
    public void setLink(String link) {
      this.link = link;
    }

    /**
     * @return String
     */
    public String getLink() {
      return link;
    }



    public String getAuditDetail() {
      return "";
    }

  }
}
