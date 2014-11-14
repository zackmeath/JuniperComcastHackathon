package vnd.jssdk.swagdtu.rest.v1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import net.juniper.jmp.interceptors.hateoas.HATEOAS;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import net.juniper.jmp.interceptors.hateoas.HATEOAS.LinkTypeEnum;
import net.juniper.jmp.interceptors.hateoas.Title;
import javax.annotation.Generated;


/***
 * @MediaType application/vnd.jssdk.swag-dtu.ptps/v1
 **/

@XmlRootElement(name = "ptps")
@XmlAccessorType(XmlAccessType.NONE)
@Generated(value = "Generated", comments = "isEnvelope:false,isReference:false,generation:0,checked:pTPs")
public class PTPs {

  public void copyFrom(net.juniper.jmp.PagingResult<vnd.jssdk.swagdtu.PTP> bean) {
    if (bean == null) {
      return;
    }

    // copy collection property: vnd.jssdk.swagdtu.rest.v1.PTPs.PTP vnd.jssdk.swagdtu.PTP
    java.util.Collection<vnd.jssdk.swagdtu.rest.v1.PTPs.PTP> pTPs =
        new java.util.ArrayList<vnd.jssdk.swagdtu.rest.v1.PTPs.PTP>();
    if (bean != null) {
      for (vnd.jssdk.swagdtu.PTP element : bean) {
        vnd.jssdk.swagdtu.rest.v1.PTPs.PTP newelement = new vnd.jssdk.swagdtu.rest.v1.PTPs.PTP();
        newelement.copyFrom(element);
        pTPs.add(newelement);
      }
    }
    this.setPTPs(pTPs);
  }



  @XmlElement(name = "ptp", required = true)
  @HATEOAS(uri = "/{pTPId}", href = "/api/jssdk/swag-dtu/ptps/{pTPId}", context = LinkTypeEnum.GLOBAL)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,title:PTPs,readOnly:false")
  @Title(name = "PTPs")
  private java.util.Collection<vnd.jssdk.swagdtu.rest.v1.PTPs.PTP> pTPs;


  @XmlAttribute(name = "uri", required = false)
  @HATEOAS(uri = "")
  @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:String,readOnly:true")
  private String uri;


  @XmlAttribute(name = "total", required = false)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:int,readOnly:true")
  private Integer totalSize;


  /**
   * @param pTPs
   */
  public void setPTPs(java.util.Collection<vnd.jssdk.swagdtu.rest.v1.PTPs.PTP> pTPs) {
    this.pTPs = pTPs;
  }

  /**
   * @return java.util.Collection<vnd.jssdk.swagdtu.rest.v1.PTPs.PTP>
   */
  public java.util.Collection<vnd.jssdk.swagdtu.rest.v1.PTPs.PTP> getPTPs() {
    return pTPs;
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



  @XmlType(name = "gen_ptps-ptps")
  @XmlAccessorType(XmlAccessType.NONE)
  @Generated(value = "Generated", comments = "isEnvelope:false,unchecked:loopback,source:vnd.jssdk.swagdtu.PTP,isReference:false,generation:0")
  public static class PTP {

    public void copyFrom(vnd.jssdk.swagdtu.PTP bean) {
      if (bean == null) {
        return;
      }
      this.setMtu(bean.getMtu());
      this.setSpeedStr(bean.getSpeedStr());
      this.setManagedDeviceID(bean.getManagedDeviceID());
      this.setSpeed(bean.getSpeed());
      this.setTagging(bean.getTagging());
      this.setAdminStatus(bean.getAdminStatus());
      this.setOperationStatus(bean.getOperationStatus());
      this.setDeviceID(bean.getDeviceID());
      this.setLinkType(bean.getLinkType());
      this.setMacAddress(bean.getMacAddress());
      this.setID(bean.getID());
      this.setPTPId(bean.getPTPId());
      this.setLoopbackEnabled(bean.getLoopbackEnabled());
      this.setManagedDevIpAddress(bean.getManagedDevIpAddress());
      this.setLinkLevelType(bean.getLinkLevelType());
      this.setDescription(bean.getDescription());
      this.setName(bean.getName());
      this.setMtuStr(bean.getMtuStr());
      this.setInfoUrl(bean.getInfoUrl());
      this.setEncapsulation(bean.getEncapsulation());
    }


    /***
     * Mtu
     **/

    @XmlElement(name = "mtu", required = true, type = Integer.class)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Mtu,javaname:int,readOnly:false,defaultValue:0,ejbType:I")
    @Title(name = "Mtu")
    private Integer mtu;

    /***
     * Speed Str
     **/

    @XmlElement(name = "speed-str", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Speed Str,javaname:String,readOnly:false,ejbType:java.lang.String")
    @Title(name = "Speed Str")
    private String speedStr;

    /***
     * Managed Device ID
     **/

    @XmlElement(name = "managed-device-id", required = true, type = Integer.class)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Managed Device ID,javaname:int,readOnly:false,defaultValue:0,ejbType:I")
    @Title(name = "Managed Device ID")
    private Integer managedDeviceID;

    /***
     * Speed
     **/

    @XmlElement(name = "speed", required = true, type = Integer.class)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Speed,javaname:int,readOnly:false,defaultValue:0,ejbType:I")
    @Title(name = "Speed")
    private Integer speed;

    /***
     * Tagging
     **/

    @XmlElement(name = "tagging", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Tagging,javaname:String,readOnly:false,ejbType:java.lang.String")
    @Title(name = "Tagging")
    private String tagging;

    /***
     * Admin Status
     **/

    @XmlElement(name = "admin-status", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Admin Status,javaname:String,readOnly:false,ejbType:java.lang.String")
    @Title(name = "Admin Status")
    private String adminStatus;

    /***
     * Operation Status
     **/

    @XmlElement(name = "operation-status", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Operation Status,javaname:String,readOnly:false,ejbType:java.lang.String")
    @Title(name = "Operation Status")
    private String operationStatus;

    /***
     * Device ID
     **/

    @XmlElement(name = "device-id", required = true, type = Integer.class)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Device ID,javaname:int,readOnly:false,defaultValue:0,ejbType:I")
    @Title(name = "Device ID")
    private Integer deviceID;

    /***
     * Link Type
     **/

    @XmlElement(name = "link-type", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Link Type,javaname:String,readOnly:false,ejbType:java.lang.String")
    @Title(name = "Link Type")
    private String linkType;

    /***
     * Mac Address
     **/

    @XmlElement(name = "mac-address", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Mac Address,javaname:String,readOnly:false,ejbType:java.lang.String")
    @Title(name = "Mac Address")
    private String macAddress;

    /***
     * ID
     **/

    @XmlElement(name = "id", required = true, type = Integer.class)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:ID,javaname:int,readOnly:false,defaultValue:0,ejbType:I")
    @Title(name = "ID")
    private Integer iD;

    /***
     * PTPId
     **/

    @XmlElement(name = "ptpid", required = false, type = Integer.class)
    @Generated(value = "Generated", comments = "title:PTPId,hasDefaultValue:false,javaname:int,readOnly:true,defaultValue:0")
    @Title(name = "PTPId")
    private Integer pTPId;

    /***
     * Loopback Enabled
     **/

    @XmlElement(name = "loopback-enabled", required = true)
    @Generated(value = "Generated", comments = "title:Loopback Enabled,hasDefaultValue:false,javaname:String,readOnly:false")
    @Title(name = "Loopback Enabled")
    private String loopbackEnabled;

    /***
     * Managed Dev IP Address
     **/

    @XmlElement(name = "managed-dev-ip-address", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Managed Dev IP Address,javaname:String,readOnly:false,ejbType:java.lang.String")
    @Title(name = "Managed Dev IP Address")
    private String managedDevIpAddress;

    /***
     * Link Level Type
     **/

    @XmlElement(name = "link-level-type", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Link Level Type,javaname:String,readOnly:false,ejbType:java.lang.String")
    @Title(name = "Link Level Type")
    private String linkLevelType;

    /***
     * Description
     **/

    @XmlElement(name = "description", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Description,javaname:String,readOnly:false,ejbType:java.lang.String")
    @Title(name = "Description")
    private String description;

    /***
     * PTP Name
     **/

    @XmlElement(name = "name", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Name,javaname:String,readOnly:false,ejbType:java.lang.String")
    @Title(name = "Name")
    private String name;

    /***
     * Mtu Str
     **/

    @XmlElement(name = "mtu-str", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Mtu Str,javaname:String,readOnly:false,ejbType:java.lang.String")
    @Title(name = "Mtu Str")
    private String mtuStr;

    /***
     * Info Url
     **/

    @XmlElement(name = "info-url", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Info Url,javaname:String,readOnly:false,ejbType:java.lang.String")
    @Title(name = "Info Url")
    private String infoUrl;

    /***
     * Encapsulation
     **/

    @XmlElement(name = "encapsulation", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Encapsulation,javaname:String,readOnly:false,ejbType:java.lang.String")
    @Title(name = "Encapsulation")
    private String encapsulation;

    /***
     * @HyperlinkTemplate /api/jssdk/swag-dtu/ptps/{pTPId}
     **/

    @XmlAttribute(name = "uri", required = false)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:String,readOnly:true")
    private String uri;

    /***
     * @HyperlinkTemplate /api/jssdk/swag-dtu/ptps/{pTPId}
     **/

    @XmlAttribute(name = "href", required = false)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:String,readOnly:true")
    private String link;


    /**
     * @param mtu
     */
    public void setMtu(Integer mtu) {
      this.mtu = mtu;
    }

    /**
     * @return Integer
     */
    public Integer getMtu() {
      return mtu;
    }

    /**
     * @param speedStr
     */
    public void setSpeedStr(String speedStr) {
      this.speedStr = speedStr;
    }

    /**
     * @return String
     */
    public String getSpeedStr() {
      return speedStr;
    }

    /**
     * @param managedDeviceID
     */
    public void setManagedDeviceID(Integer managedDeviceID) {
      this.managedDeviceID = managedDeviceID;
    }

    /**
     * @return Integer
     */
    public Integer getManagedDeviceID() {
      return managedDeviceID;
    }

    /**
     * @param speed
     */
    public void setSpeed(Integer speed) {
      this.speed = speed;
    }

    /**
     * @return Integer
     */
    public Integer getSpeed() {
      return speed;
    }

    /**
     * @param tagging
     */
    public void setTagging(String tagging) {
      this.tagging = tagging;
    }

    /**
     * @return String
     */
    public String getTagging() {
      return tagging;
    }

    /**
     * @param adminStatus
     */
    public void setAdminStatus(String adminStatus) {
      this.adminStatus = adminStatus;
    }

    /**
     * @return String
     */
    public String getAdminStatus() {
      return adminStatus;
    }

    /**
     * @param operationStatus
     */
    public void setOperationStatus(String operationStatus) {
      this.operationStatus = operationStatus;
    }

    /**
     * @return String
     */
    public String getOperationStatus() {
      return operationStatus;
    }

    /**
     * @param deviceID
     */
    public void setDeviceID(Integer deviceID) {
      this.deviceID = deviceID;
    }

    /**
     * @return Integer
     */
    public Integer getDeviceID() {
      return deviceID;
    }

    /**
     * @param linkType
     */
    public void setLinkType(String linkType) {
      this.linkType = linkType;
    }

    /**
     * @return String
     */
    public String getLinkType() {
      return linkType;
    }

    /**
     * @param macAddress
     */
    public void setMacAddress(String macAddress) {
      this.macAddress = macAddress;
    }

    /**
     * @return String
     */
    public String getMacAddress() {
      return macAddress;
    }

    /**
     * @param iD
     */
    public void setID(Integer iD) {
      this.iD = iD;
    }

    /**
     * @return Integer
     */
    public Integer getID() {
      return iD;
    }

    /**
     * @param pTPId
     */
    public void setPTPId(Integer pTPId) {
      this.pTPId = pTPId;
    }

    /**
     * @return Integer
     */
    public Integer getPTPId() {
      return pTPId;
    }

    /**
     * @param loopbackEnabled
     */
    public void setLoopbackEnabled(String loopbackEnabled) {
      this.loopbackEnabled = loopbackEnabled;
    }

    /**
     * @return String
     */
    public String getLoopbackEnabled() {
      return loopbackEnabled;
    }

    /**
     * @param managedDevIpAddress
     */
    public void setManagedDevIpAddress(String managedDevIpAddress) {
      this.managedDevIpAddress = managedDevIpAddress;
    }

    /**
     * @return String
     */
    public String getManagedDevIpAddress() {
      return managedDevIpAddress;
    }

    /**
     * @param linkLevelType
     */
    public void setLinkLevelType(String linkLevelType) {
      this.linkLevelType = linkLevelType;
    }

    /**
     * @return String
     */
    public String getLinkLevelType() {
      return linkLevelType;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
      this.description = description;
    }

    /**
     * @return String
     */
    public String getDescription() {
      return description;
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
    public String getName() {
      return name;
    }

    /**
     * @param mtuStr
     */
    public void setMtuStr(String mtuStr) {
      this.mtuStr = mtuStr;
    }

    /**
     * @return String
     */
    public String getMtuStr() {
      return mtuStr;
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
     * @param encapsulation
     */
    public void setEncapsulation(String encapsulation) {
      this.encapsulation = encapsulation;
    }

    /**
     * @return String
     */
    public String getEncapsulation() {
      return encapsulation;
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
