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
 * @MediaType application/vnd.jssdk.swag-dtu.devices/v1
 **/

@XmlRootElement(name = "devices")
@XmlAccessorType(XmlAccessType.NONE)
@Generated(value = "Generated", comments = "isEnvelope:false,isReference:false,generation:0,checked:devices")
public class Devices {

  public void copyFrom(net.juniper.jmp.PagingResult<vnd.jssdk.swagdtu.Device> bean) {
    if (bean == null) {
      return;
    }

    // copy collection property: vnd.jssdk.swagdtu.rest.v1.Devices.Device vnd.jssdk.swagdtu.Device
    java.util.Collection<vnd.jssdk.swagdtu.rest.v1.Devices.Device> devices =
        new java.util.ArrayList<vnd.jssdk.swagdtu.rest.v1.Devices.Device>();
    if (bean != null) {
      for (vnd.jssdk.swagdtu.Device element : bean) {
        vnd.jssdk.swagdtu.rest.v1.Devices.Device newelement =
            new vnd.jssdk.swagdtu.rest.v1.Devices.Device();
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
  private java.util.Collection<vnd.jssdk.swagdtu.rest.v1.Devices.Device> devices;


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
  public void setDevices(java.util.Collection<vnd.jssdk.swagdtu.rest.v1.Devices.Device> devices) {
    this.devices = devices;
  }

  /**
   * @return java.util.Collection<vnd.jssdk.swagdtu.rest.v1.Devices.Device>
   */
  public java.util.Collection<vnd.jssdk.swagdtu.rest.v1.Devices.Device> getDevices() {
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
  @Generated(value = "Generated", comments = "isEnvelope:false,source:vnd.jssdk.swagdtu.Device,isReference:false,generation:0,checked:[id&#44;platform&#44;ipAddr&#44;status&#44;name&#44;longitude&#44;latitude&#44;infoUrl]")
  public static class Device {

    public void copyFrom(vnd.jssdk.swagdtu.Device bean) {
      if (bean == null) {
        return;
      }
      this.setId(bean.getId());
      this.setPlatform(bean.getPlatform());
      this.setIpAddr(bean.getIpAddr());
      this.setStatus(bean.getStatus());
      this.setName(bean.getName());
      this.setLongitude(bean.getLongitude());
      this.setLatitude(bean.getLatitude());
      this.setInfoUrl(bean.getInfoUrl());
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
     * Platform
     **/

    @XmlElement(name = "platform", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Platform,javaname:String,readOnly:false,ejbType:java.lang.String")
    @Title(name = "Platform")
    private String platform;

    /***
     * IP Addr
     **/

    @XmlElement(name = "ip-addr", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:IP Addr,javaname:String,readOnly:false,ejbType:java.lang.String")
    @Title(name = "IP Addr")
    private String ipAddr;

    /***
     * Device status (up or down)
     **/

    @XmlElement(name = "status", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Status,javaname:String,readOnly:false,ejbType:java.lang.String")
    @Title(name = "Status")
    private String status;

    /***
     * Device Name
     **/

    @XmlElement(name = "name", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Name,javaname:String,readOnly:false,ejbType:java.lang.String")
    @Title(name = "Name")
    private String name;

    /***
     * Longitude of device location
     **/

    @XmlElement(name = "longitude", required = true, type = Float.class)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Longitude,javaname:float,readOnly:false,defaultValue:0.0,ejbType:F")
    @Title(name = "Longitude")
    private Float longitude;

    /***
     * Latitude of device location
     **/

    @XmlElement(name = "latitude", required = true, type = Float.class)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Latitude,javaname:float,readOnly:false,defaultValue:0.0,ejbType:F")
    @Title(name = "Latitude")
    private Float latitude;

    /***
     * Info Url
     **/

    @XmlElement(name = "info-url", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Info Url,javaname:String,readOnly:false,ejbType:java.lang.String")
    @Title(name = "Info Url")
    private String infoUrl;

    /***
     * @HyperlinkTemplate /api/jssdk/swag-dtu/devices/{id}
     **/

    @XmlAttribute(name = "uri", required = false)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:String,readOnly:true")
    private String uri;

    /***
     * @HyperlinkTemplate /api/jssdk/swag-dtu/devices/{id}
     **/

    @XmlAttribute(name = "href", required = false)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:String,readOnly:true")
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
     * @param platform
     */
    public void setPlatform(String platform) {
      this.platform = platform;
    }

    /**
     * @return String
     */
    @Sortable(moAttrName = "platform")
    public String getPlatform() {
      return platform;
    }

    /**
     * @param ipAddr
     */
    public void setIpAddr(String ipAddr) {
      this.ipAddr = ipAddr;
    }

    /**
     * @return String
     */
    @Sortable(moAttrName = "ipAddr")
    public String getIpAddr() {
      return ipAddr;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
      this.status = status;
    }

    /**
     * @return String
     */
    public String getStatus() {
      return status;
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
     * @param longitude
     */
    public void setLongitude(Float longitude) {
      this.longitude = longitude;
    }

    /**
     * @return Float
     */
    public Float getLongitude() {
      return longitude;
    }

    /**
     * @param latitude
     */
    public void setLatitude(Float latitude) {
      this.latitude = latitude;
    }

    /**
     * @return Float
     */
    public Float getLatitude() {
      return latitude;
    }

    /**
     * @param infoUrl
     */
    public void setInfoUrl(String infoUrl) {
      this.infoUrl = infoUrl;
    }

    /**
     * @return String
     */
    public String getInfoUrl() {
      return infoUrl;
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
