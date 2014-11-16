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
 * @MediaType application/vnd.jssdk.swag-dtu.links/v1
 **/

@XmlRootElement(name = "links")
@XmlAccessorType(XmlAccessType.NONE)
@Generated(value = "Generated", comments = "isEnvelope:false,isReference:false,generation:0,checked:links")
public class Links {

  public void copyFrom(net.juniper.jmp.PagingResult<vnd.jssdk.swagdtu.Link> bean) {
    if (bean == null) {
      return;
    }

    // copy collection property: vnd.jssdk.swagdtu.rest.v1.Links.Link vnd.jssdk.swagdtu.Link
    java.util.Collection<vnd.jssdk.swagdtu.rest.v1.Links.Link> links =
        new java.util.ArrayList<vnd.jssdk.swagdtu.rest.v1.Links.Link>();
    if (bean != null) {
      for (vnd.jssdk.swagdtu.Link element : bean) {
        vnd.jssdk.swagdtu.rest.v1.Links.Link newelement =
            new vnd.jssdk.swagdtu.rest.v1.Links.Link();
        newelement.copyFrom(element);
        links.add(newelement);
      }
    }
    this.setLinks(links);
  }



  @XmlElement(name = "link", required = true)
  @HATEOAS(uri = "/{linkId}", href = "/api/jssdk/swag-dtu/current-link-list/{linkId}", context = LinkTypeEnum.GLOBAL)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Links,readOnly:false")
  @Title(name = "Links")
  private java.util.Collection<vnd.jssdk.swagdtu.rest.v1.Links.Link> links;


  @XmlAttribute(name = "uri", required = false)
  @HATEOAS(uri = "")
  @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:String,readOnly:true")
  private String uri;


  @XmlAttribute(name = "total", required = false)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:int,readOnly:true")
  private Integer totalSize;


  /**
   * @param links
   */
  public void setLinks(java.util.Collection<vnd.jssdk.swagdtu.rest.v1.Links.Link> links) {
    this.links = links;
  }

  /**
   * @return java.util.Collection<vnd.jssdk.swagdtu.rest.v1.Links.Link>
   */
  public java.util.Collection<vnd.jssdk.swagdtu.rest.v1.Links.Link> getLinks() {
    return links;
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



  @XmlType(name = "gen_links-links")
  @XmlAccessorType(XmlAccessType.NONE)
  @Generated(value = "Generated", comments = "isEnvelope:false,unchecked:[mtu&#44;levelType&#44;speedStr&#44;speed&#44;mtuStr&#44;down&#44;encapsulation],source:vnd.jssdk.swagdtu.Link,isReference:false,generation:0")
  public static class Link {

    public void copyFrom(vnd.jssdk.swagdtu.Link bean) {
      if (bean == null) {
        return;
      }
      this.setLinkId(bean.getLinkId());

      // copy property: ptpB : vnd.jssdk.swagdtu.rest.v1.Links.Link.PtpB : vnd.jssdk.swagdtu.PTP
      vnd.jssdk.swagdtu.rest.v1.Links.Link.PtpB ptpB =
          new vnd.jssdk.swagdtu.rest.v1.Links.Link.PtpB();
      ptpB.copyFrom(bean.getPtpB());
      this.setPtpB(ptpB);

      // copy property: ptpA : vnd.jssdk.swagdtu.rest.v1.Links.Link.PtpA : vnd.jssdk.swagdtu.PTP
      vnd.jssdk.swagdtu.rest.v1.Links.Link.PtpA ptpA =
          new vnd.jssdk.swagdtu.rest.v1.Links.Link.PtpA();
      ptpA.copyFrom(bean.getPtpA());
      this.setPtpA(ptpA);

      // copy property: deviceB : vnd.jssdk.swagdtu.rest.v1.Links.Link.DeviceB : vnd.jssdk.swagdtu.Device
      vnd.jssdk.swagdtu.rest.v1.Links.Link.DeviceB deviceB =
          new vnd.jssdk.swagdtu.rest.v1.Links.Link.DeviceB();
      deviceB.copyFrom(bean.getDeviceB());
      this.setDeviceB(deviceB);

      // copy property: deviceA : vnd.jssdk.swagdtu.rest.v1.Links.Link.DeviceA : vnd.jssdk.swagdtu.Device
      vnd.jssdk.swagdtu.rest.v1.Links.Link.DeviceA deviceA =
          new vnd.jssdk.swagdtu.rest.v1.Links.Link.DeviceA();
      deviceA.copyFrom(bean.getDeviceA());
      this.setDeviceA(deviceA);
    }


    /***
     * Link ID
     * 
     * @key 
     **/

    @XmlElement(name = "linkId", required = false)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Link ID,javaname:String,readOnly:true,ejbType:java.lang.String")
    @Title(name = "Link ID")
    private String linkId;


    @XmlElement(name = "ptpb", required = true)
    @HATEOAS(uri = "", href = "/api/jssdk/swag-dtu/ptps/{pTPId}", context = LinkTypeEnum.GLOBAL)
    @Generated(value = "Generated", comments = "title:PtpB,hasDefaultValue:false,readOnly:false,ejbType:vnd.jssdk.swagdtu.PTP")
    @Title(name = "PtpB")
    private vnd.jssdk.swagdtu.rest.v1.Links.Link.PtpB ptpB;


    @XmlElement(name = "ptpa", required = true)
    @HATEOAS(uri = "", href = "/api/jssdk/swag-dtu/ptps/{pTPId}", context = LinkTypeEnum.GLOBAL)
    @Generated(value = "Generated", comments = "title:PtpA,hasDefaultValue:false,readOnly:false,ejbType:vnd.jssdk.swagdtu.PTP")
    @Title(name = "PtpA")
    private vnd.jssdk.swagdtu.rest.v1.Links.Link.PtpA ptpA;


    @XmlElement(name = "deviceb", required = true)
    @HATEOAS(uri = "", href = "/api/jssdk/swag-dtu/devices/{id}", context = LinkTypeEnum.GLOBAL)
    @Generated(value = "Generated", comments = "title:DeviceB,hasDefaultValue:false,readOnly:false,ejbType:vnd.jssdk.swagdtu.Device")
    @Title(name = "DeviceB")
    private vnd.jssdk.swagdtu.rest.v1.Links.Link.DeviceB deviceB;


    @XmlElement(name = "devicea", required = true)
    @HATEOAS(uri = "", href = "/api/jssdk/swag-dtu/devices/{id}", context = LinkTypeEnum.GLOBAL)
    @Generated(value = "Generated", comments = "title:DeviceA,hasDefaultValue:false,readOnly:false,ejbType:vnd.jssdk.swagdtu.Device")
    @Title(name = "DeviceA")
    private vnd.jssdk.swagdtu.rest.v1.Links.Link.DeviceA deviceA;

    /***
     * @HyperlinkTemplate /api/jssdk/swag-dtu/current-link-lists/{linkId}
     **/

    @XmlAttribute(name = "uri", required = false)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:String,readOnly:true")
    private String uri;

    /***
     * @HyperlinkTemplate /api/jssdk/swag-dtu/current-link-list/{linkId}
     **/

    @XmlAttribute(name = "href", required = false)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:String,readOnly:true")
    private String link;


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
     * @param ptpB
     */
    public void setPtpB(vnd.jssdk.swagdtu.rest.v1.Links.Link.PtpB ptpB) {
      this.ptpB = ptpB;
    }

    /**
     * @return vnd.jssdk.swagdtu.rest.v1.Links.Link.PtpB
     */
    public vnd.jssdk.swagdtu.rest.v1.Links.Link.PtpB getPtpB() {
      return ptpB;
    }

    /**
     * @param ptpA
     */
    public void setPtpA(vnd.jssdk.swagdtu.rest.v1.Links.Link.PtpA ptpA) {
      this.ptpA = ptpA;
    }

    /**
     * @return vnd.jssdk.swagdtu.rest.v1.Links.Link.PtpA
     */
    public vnd.jssdk.swagdtu.rest.v1.Links.Link.PtpA getPtpA() {
      return ptpA;
    }

    /**
     * @param deviceB
     */
    public void setDeviceB(vnd.jssdk.swagdtu.rest.v1.Links.Link.DeviceB deviceB) {
      this.deviceB = deviceB;
    }

    /**
     * @return vnd.jssdk.swagdtu.rest.v1.Links.Link.DeviceB
     */
    public vnd.jssdk.swagdtu.rest.v1.Links.Link.DeviceB getDeviceB() {
      return deviceB;
    }

    /**
     * @param deviceA
     */
    public void setDeviceA(vnd.jssdk.swagdtu.rest.v1.Links.Link.DeviceA deviceA) {
      this.deviceA = deviceA;
    }

    /**
     * @return vnd.jssdk.swagdtu.rest.v1.Links.Link.DeviceA
     */
    public vnd.jssdk.swagdtu.rest.v1.Links.Link.DeviceA getDeviceA() {
      return deviceA;
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



    @XmlType(name = "gen_links-links-ptpb")
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



    @XmlType(name = "gen_links-links-ptpa")
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



    @XmlType(name = "gen_links-links-deviceb")
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



    @XmlType(name = "gen_links-links-devicea")
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
  }
}
