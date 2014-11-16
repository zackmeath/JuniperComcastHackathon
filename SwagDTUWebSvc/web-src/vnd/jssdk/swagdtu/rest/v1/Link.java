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
 * @MediaType application/vnd.jssdk.swag-dtu.link/v1
 **/

@XmlRootElement(name = "link")
@XmlAccessorType(XmlAccessType.NONE)
@Generated(value = "Generated", comments = "isEnvelope:false,source:vnd.jssdk.swagdtu.Link,isReference:false,generation:0,checked:[devAIpAddr&#44;speedStr&#44;operationStatus&#44;devBName&#44;deviceB&#44;deviceA&#44;linkId&#44;currSpeed&#44;ptpB&#44;devAName&#44;ptpA&#44;devBIpAddr&#44;mtuStr&#44;devBInterface&#44;devAInterface]")
public class Link {

  public void copyFrom(vnd.jssdk.swagdtu.Link bean) {
    if (bean == null) {
      return;
    }
    this.setDevAIpAddr(bean.getDevAIpAddr());
    this.setSpeedStr(bean.getSpeedStr());
    this.setOperationStatus(bean.getOperationStatus());
    this.setDevBName(bean.getDevBName());
    this.setLinkId(bean.getLinkId());
    this.setCurrSpeed(bean.getCurrSpeed());
    this.setDevAName(bean.getDevAName());
    this.setDevBIpAddr(bean.getDevBIpAddr());
    this.setMtuStr(bean.getMtuStr());
    this.setDevBInterface(bean.getDevBInterface());
    this.setDevAInterface(bean.getDevAInterface());

    // copy property: deviceB : vnd.jssdk.swagdtu.rest.v1.Link.DeviceB : vnd.jssdk.swagdtu.Device
    vnd.jssdk.swagdtu.rest.v1.Link.DeviceB deviceB = new vnd.jssdk.swagdtu.rest.v1.Link.DeviceB();
    deviceB.copyFrom(bean.getDeviceB());
    this.setDeviceB(deviceB);

    // copy property: deviceA : vnd.jssdk.swagdtu.rest.v1.Link.DeviceA : vnd.jssdk.swagdtu.Device
    vnd.jssdk.swagdtu.rest.v1.Link.DeviceA deviceA = new vnd.jssdk.swagdtu.rest.v1.Link.DeviceA();
    deviceA.copyFrom(bean.getDeviceA());
    this.setDeviceA(deviceA);

    // copy property: ptpB : vnd.jssdk.swagdtu.rest.v1.Link.PtpB : vnd.jssdk.swagdtu.PTP
    vnd.jssdk.swagdtu.rest.v1.Link.PtpB ptpB = new vnd.jssdk.swagdtu.rest.v1.Link.PtpB();
    ptpB.copyFrom(bean.getPtpB());
    this.setPtpB(ptpB);

    // copy property: ptpA : vnd.jssdk.swagdtu.rest.v1.Link.PtpA : vnd.jssdk.swagdtu.PTP
    vnd.jssdk.swagdtu.rest.v1.Link.PtpA ptpA = new vnd.jssdk.swagdtu.rest.v1.Link.PtpA();
    ptpA.copyFrom(bean.getPtpA());
    this.setPtpA(ptpA);
  }


  /***
   * Dev A IP Addr
   **/

  @XmlElement(name = "dev-a-ip-addr", required = true)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Dev A IP Addr,javaname:String,readOnly:false,ejbType:java.lang.String")
  @Title(name = "Dev A IP Addr")
  private String devAIpAddr;

  /***
   * Speed Str
   **/

  @XmlElement(name = "speed-str", required = true)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Speed Str,javaname:String,readOnly:false,ejbType:java.lang.String")
  @Title(name = "Speed Str")
  private String speedStr;

  /***
   * Operation Status
   **/

  @XmlElement(name = "operation-status", required = true)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Operation Status,javaname:String,readOnly:false,ejbType:java.lang.String")
  @Title(name = "Operation Status")
  private String operationStatus;

  /***
   * Dev B Name
   **/

  @XmlElement(name = "dev-b-name", required = true)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Dev B Name,javaname:String,readOnly:false,ejbType:java.lang.String")
  @Title(name = "Dev B Name")
  private String devBName;


  @XmlElement(name = "deviceb", required = true)
  @HATEOAS(href = "/api/jssdk/swag-dtu/devices/{id}", context = LinkTypeEnum.GLOBAL)
  @Generated(value = "Generated", comments = "title:DeviceB,hasDefaultValue:false,readOnly:false,ejbType:vnd.jssdk.swagdtu.Device")
  @Title(name = "DeviceB")
  private vnd.jssdk.swagdtu.rest.v1.Link.DeviceB deviceB;


  @XmlElement(name = "devicea", required = true)
  @HATEOAS(href = "/api/jssdk/swag-dtu/devices/{id}", context = LinkTypeEnum.GLOBAL)
  @Generated(value = "Generated", comments = "title:DeviceA,hasDefaultValue:false,readOnly:false,ejbType:vnd.jssdk.swagdtu.Device")
  @Title(name = "DeviceA")
  private vnd.jssdk.swagdtu.rest.v1.Link.DeviceA deviceA;

  /***
   * Link ID
   * 
   * @key 
   **/

  @XmlElement(name = "linkId", required = false)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Link ID,javaname:String,readOnly:true,ejbType:java.lang.String")
  @Title(name = "Link ID")
  private String linkId;

  /***
   * Curr Speed
   **/

  @XmlElement(name = "curr-speed", required = true, type = Integer.class)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Curr Speed,javaname:int,readOnly:false,defaultValue:0,ejbType:I")
  @Title(name = "Curr Speed")
  private Integer currSpeed;


  @XmlElement(name = "ptpb", required = true)
  @HATEOAS(href = "/api/jssdk/swag-dtu/ptps/{pTPId}", context = LinkTypeEnum.GLOBAL)
  @Generated(value = "Generated", comments = "title:PtpB,hasDefaultValue:false,readOnly:false,ejbType:vnd.jssdk.swagdtu.PTP")
  @Title(name = "PtpB")
  private vnd.jssdk.swagdtu.rest.v1.Link.PtpB ptpB;

  /***
   * Dev A Name
   **/

  @XmlElement(name = "dev-a-name", required = true)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Dev A Name,javaname:String,readOnly:false,ejbType:java.lang.String")
  @Title(name = "Dev A Name")
  private String devAName;


  @XmlElement(name = "ptpa", required = true)
  @HATEOAS(href = "/api/jssdk/swag-dtu/ptps/{pTPId}", context = LinkTypeEnum.GLOBAL)
  @Generated(value = "Generated", comments = "title:PtpA,hasDefaultValue:false,readOnly:false,ejbType:vnd.jssdk.swagdtu.PTP")
  @Title(name = "PtpA")
  private vnd.jssdk.swagdtu.rest.v1.Link.PtpA ptpA;

  /***
   * Dev B IP Addr
   **/

  @XmlElement(name = "dev-b-ip-addr", required = true)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Dev B IP Addr,javaname:String,readOnly:false,ejbType:java.lang.String")
  @Title(name = "Dev B IP Addr")
  private String devBIpAddr;

  /***
   * Mtu Str
   **/

  @XmlElement(name = "mtu-str", required = true)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Mtu Str,javaname:String,readOnly:false,ejbType:java.lang.String")
  @Title(name = "Mtu Str")
  private String mtuStr;

  /***
   * Dev B Interface
   **/

  @XmlElement(name = "dev-b-interface", required = true)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Dev B Interface,javaname:String,readOnly:false,ejbType:java.lang.String")
  @Title(name = "Dev B Interface")
  private String devBInterface;

  /***
   * Dev A Interface
   **/

  @XmlElement(name = "dev-a-interface", required = true)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Dev A Interface,javaname:String,readOnly:false,ejbType:java.lang.String")
  @Title(name = "Dev A Interface")
  private String devAInterface;

  /***
   * @HyperlinkTemplate /api/jssdk/swag-dtu/current-link-lists/{linkId}
   **/

  @XmlAttribute(name = "uri", required = false)
  @HATEOAS(uri = "")
  @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:String,readOnly:true")
  private String uri;

  /***
   * @HyperlinkTemplate /api/jssdk/swag-dtu/current-link-list/{linkId}
   **/

  @XmlAttribute(name = "href", required = false)
  @HATEOAS(uri = "", href = "/api/jssdk/swag-dtu/current-link-list/{linkId}", context = LinkTypeEnum.GLOBAL)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:String,readOnly:true")
  private String link;


  /**
   * @param devAIpAddr
   */
  public void setDevAIpAddr(String devAIpAddr) {
    this.devAIpAddr = devAIpAddr;
  }

  /**
   * @return String
   */
  public String getDevAIpAddr() {
    return devAIpAddr;
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
   * @param devBName
   */
  public void setDevBName(String devBName) {
    this.devBName = devBName;
  }

  /**
   * @return String
   */
  public String getDevBName() {
    return devBName;
  }

  /**
   * @param deviceB
   */
  public void setDeviceB(vnd.jssdk.swagdtu.rest.v1.Link.DeviceB deviceB) {
    this.deviceB = deviceB;
  }

  /**
   * @return vnd.jssdk.swagdtu.rest.v1.Link.DeviceB
   */
  public vnd.jssdk.swagdtu.rest.v1.Link.DeviceB getDeviceB() {
    return deviceB;
  }

  /**
   * @param deviceA
   */
  public void setDeviceA(vnd.jssdk.swagdtu.rest.v1.Link.DeviceA deviceA) {
    this.deviceA = deviceA;
  }

  /**
   * @return vnd.jssdk.swagdtu.rest.v1.Link.DeviceA
   */
  public vnd.jssdk.swagdtu.rest.v1.Link.DeviceA getDeviceA() {
    return deviceA;
  }

  /**
   * @param linkId
   */
  public void setLinkId(String linkId) {
    this.linkId = linkId;
  }

  /**
   * @return String
   */
  public String getLinkId() {
    return linkId;
  }

  /**
   * @param currSpeed
   */
  public void setCurrSpeed(Integer currSpeed) {
    this.currSpeed = currSpeed;
  }

  /**
   * @return Integer
   */
  public Integer getCurrSpeed() {
    return currSpeed;
  }

  /**
   * @param ptpB
   */
  public void setPtpB(vnd.jssdk.swagdtu.rest.v1.Link.PtpB ptpB) {
    this.ptpB = ptpB;
  }

  /**
   * @return vnd.jssdk.swagdtu.rest.v1.Link.PtpB
   */
  public vnd.jssdk.swagdtu.rest.v1.Link.PtpB getPtpB() {
    return ptpB;
  }

  /**
   * @param devAName
   */
  public void setDevAName(String devAName) {
    this.devAName = devAName;
  }

  /**
   * @return String
   */
  public String getDevAName() {
    return devAName;
  }

  /**
   * @param ptpA
   */
  public void setPtpA(vnd.jssdk.swagdtu.rest.v1.Link.PtpA ptpA) {
    this.ptpA = ptpA;
  }

  /**
   * @return vnd.jssdk.swagdtu.rest.v1.Link.PtpA
   */
  public vnd.jssdk.swagdtu.rest.v1.Link.PtpA getPtpA() {
    return ptpA;
  }

  /**
   * @param devBIpAddr
   */
  public void setDevBIpAddr(String devBIpAddr) {
    this.devBIpAddr = devBIpAddr;
  }

  /**
   * @return String
   */
  public String getDevBIpAddr() {
    return devBIpAddr;
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
   * @param devBInterface
   */
  public void setDevBInterface(String devBInterface) {
    this.devBInterface = devBInterface;
  }

  /**
   * @return String
   */
  public String getDevBInterface() {
    return devBInterface;
  }

  /**
   * @param devAInterface
   */
  public void setDevAInterface(String devAInterface) {
    this.devAInterface = devAInterface;
  }

  /**
   * @return String
   */
  public String getDevAInterface() {
    return devAInterface;
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



  @XmlType(name = "gen_link-deviceb")
  @XmlAccessorType(XmlAccessType.NONE)
  @Generated(value = "Generated", comments = "isEnvelope:false,unchecked:[platform&#44;ipAddr&#44;status&#44;longitude&#44;latitude&#44;infoUrl],source:vnd.jssdk.swagdtu.Device,isReference:true,generation:0")
  public static class DeviceB {

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



  @XmlType(name = "gen_link-devicea")
  @XmlAccessorType(XmlAccessType.NONE)
  @Generated(value = "Generated", comments = "isEnvelope:false,unchecked:[platform&#44;ipAddr&#44;status&#44;longitude&#44;latitude&#44;infoUrl],source:vnd.jssdk.swagdtu.Device,isReference:true,generation:0")
  public static class DeviceA {

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



  @XmlType(name = "gen_link-ptpb")
  @XmlAccessorType(XmlAccessType.NONE)
  @Generated(value = "Generated", comments = "isEnvelope:false,unchecked:[loopback&#44;mtu&#44;speedStr&#44;managedDeviceID&#44;speed&#44;tagging&#44;adminStatus&#44;operationStatus&#44;deviceID&#44;linkType&#44;macAddress&#44;iD&#44;loopbackEnabled&#44;managedDevIpAddress&#44;linkLevelType&#44;description&#44;mtuStr&#44;infoUrl&#44;encapsulation],source:vnd.jssdk.swagdtu.PTP,isReference:true,generation:0")
  public static class PtpB {

    public void copyFrom(vnd.jssdk.swagdtu.PTP bean) {
      if (bean == null) {
        return;
      }
      this.setPTPId(bean.getPTPId());
      this.setName(bean.getName());
    }


    /***
     * PTPId
     **/

    @XmlElement(name = "ptpid", required = false, type = Integer.class)
    @Generated(value = "Generated", comments = "title:PTPId,hasDefaultValue:false,javaname:int,readOnly:true,defaultValue:0")
    @Title(name = "PTPId")
    private Integer pTPId;

    /***
     * PTP Name
     **/

    @XmlElement(name = "name", required = false)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Name,javaname:String,readOnly:true,ejbType:java.lang.String")
    @Title(name = "Name")
    private String name;

    /***
     * @HyperlinkTemplate /api/jssdk/swag-dtu/ptps/{pTPId}
     **/

    @XmlAttribute(name = "href", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:String,readOnly:false")
    private String link;


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



  @XmlType(name = "gen_link-ptpa")
  @XmlAccessorType(XmlAccessType.NONE)
  @Generated(value = "Generated", comments = "isEnvelope:false,unchecked:[loopback&#44;mtu&#44;speedStr&#44;managedDeviceID&#44;speed&#44;tagging&#44;adminStatus&#44;operationStatus&#44;deviceID&#44;linkType&#44;macAddress&#44;iD&#44;loopbackEnabled&#44;managedDevIpAddress&#44;linkLevelType&#44;description&#44;mtuStr&#44;infoUrl&#44;encapsulation],source:vnd.jssdk.swagdtu.PTP,isReference:true,generation:0")
  public static class PtpA {

    public void copyFrom(vnd.jssdk.swagdtu.PTP bean) {
      if (bean == null) {
        return;
      }
      this.setPTPId(bean.getPTPId());
      this.setName(bean.getName());
    }


    /***
     * PTPId
     **/

    @XmlElement(name = "ptpid", required = false, type = Integer.class)
    @Generated(value = "Generated", comments = "title:PTPId,hasDefaultValue:false,javaname:int,readOnly:true,defaultValue:0")
    @Title(name = "PTPId")
    private Integer pTPId;

    /***
     * PTP Name
     **/

    @XmlElement(name = "name", required = false)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Name,javaname:String,readOnly:true,ejbType:java.lang.String")
    @Title(name = "Name")
    private String name;

    /***
     * @HyperlinkTemplate /api/jssdk/swag-dtu/ptps/{pTPId}
     **/

    @XmlAttribute(name = "href", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:String,readOnly:false")
    private String link;


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
