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
 * @MediaType application/vnd.jssdk.swag-dtu.lsps/v1
 **/

@XmlRootElement(name = "lsps")
@XmlAccessorType(XmlAccessType.NONE)
@Generated(value = "Generated", comments = "isEnvelope:false,isReference:false,generation:0,checked:lSPs")
public class LSPs {

  public void copyFrom(net.juniper.jmp.PagingResult<vnd.jssdk.swagdtu.LSP> bean) {
    if (bean == null) {
      return;
    }

    // copy collection property: vnd.jssdk.swagdtu.rest.v1.LSPs.LSP vnd.jssdk.swagdtu.LSP
    java.util.Collection<vnd.jssdk.swagdtu.rest.v1.LSPs.LSP> lSPs =
        new java.util.ArrayList<vnd.jssdk.swagdtu.rest.v1.LSPs.LSP>();
    if (bean != null) {
      for (vnd.jssdk.swagdtu.LSP element : bean) {
        vnd.jssdk.swagdtu.rest.v1.LSPs.LSP newelement = new vnd.jssdk.swagdtu.rest.v1.LSPs.LSP();
        newelement.copyFrom(element);
        lSPs.add(newelement);
      }
    }
    this.setLSPs(lSPs);
  }



  @XmlElement(name = "lsp", required = true)
  @HATEOAS(uri = "/{lspId}", href = "/api/jssdk/swag-dtu/current-lsp-list/{lspId}", context = LinkTypeEnum.GLOBAL)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,title:LSPs,readOnly:false")
  @Title(name = "LSPs")
  private java.util.Collection<vnd.jssdk.swagdtu.rest.v1.LSPs.LSP> lSPs;


  @XmlAttribute(name = "uri", required = false)
  @HATEOAS(uri = "")
  @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:String,readOnly:true")
  private String uri;


  @XmlAttribute(name = "total", required = false)
  @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:int,readOnly:true")
  private Integer totalSize;


  /**
   * @param lSPs
   */
  public void setLSPs(java.util.Collection<vnd.jssdk.swagdtu.rest.v1.LSPs.LSP> lSPs) {
    this.lSPs = lSPs;
  }

  /**
   * @return java.util.Collection<vnd.jssdk.swagdtu.rest.v1.LSPs.LSP>
   */
  public java.util.Collection<vnd.jssdk.swagdtu.rest.v1.LSPs.LSP> getLSPs() {
    return lSPs;
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



  @XmlType(name = "gen_lsps-lsps")
  @XmlAccessorType(XmlAccessType.NONE)
  @Generated(value = "Generated", comments = "isEnvelope:false,source:vnd.jssdk.swagdtu.LSP,isReference:false,generation:0,checked:[numHops&#44;speedAvg&#44;lspInterface&#44;pathUsable&#44;lowestMtu&#44;lowestSpeed&#44;lspId]")
  public static class LSP {

    public void copyFrom(vnd.jssdk.swagdtu.LSP bean) {
      if (bean == null) {
        return;
      }
      this.setNumHops(bean.getNumHops());
      this.setSpeedAvg(bean.getSpeedAvg());
      this.setLspInterface(bean.getLspInterface());
      this.setPathUsable(bean.isPathUsable());
      this.setLowestMtu(bean.getLowestMtu());
      this.setLowestSpeed(bean.getLowestSpeed());
      this.setLspId(bean.getLspId());
    }


    /***
     * Num Hops
     **/

    @XmlElement(name = "num-hops", required = true, type = Integer.class)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Num Hops,javaname:int,readOnly:false,defaultValue:0,ejbType:I")
    @Title(name = "Num Hops")
    private Integer numHops;

    /***
     * Speed Avg
     **/

    @XmlElement(name = "speed-avg", required = true, type = Integer.class)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Speed Avg,javaname:int,readOnly:false,defaultValue:0,ejbType:I")
    @Title(name = "Speed Avg")
    private Integer speedAvg;

    /***
     * Lsp Interface
     **/

    @XmlElement(name = "lsp-interface", required = true)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Lsp Interface,javaname:String,readOnly:false,ejbType:java.lang.String")
    @Title(name = "Lsp Interface")
    private String lspInterface;

    /***
     * Path Usable
     **/

    @XmlElement(name = "path-usable", required = true, type = Boolean.class)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Path Usable,javaname:boolean,readOnly:false,defaultValue:false,ejbType:Z")
    @Title(name = "Path Usable")
    private Boolean pathUsable;

    /***
     * Lowest Mtu
     **/

    @XmlElement(name = "lowest-mtu", required = true, type = Integer.class)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Lowest Mtu,javaname:int,readOnly:false,defaultValue:0,ejbType:I")
    @Title(name = "Lowest Mtu")
    private Integer lowestMtu;

    /***
     * Lowest Speed
     **/

    @XmlElement(name = "lowest-speed", required = true, type = Integer.class)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Lowest Speed,javaname:int,readOnly:false,defaultValue:0,ejbType:I")
    @Title(name = "Lowest Speed")
    private Integer lowestSpeed;

    /***
     * Lsp ID
     **/

    @XmlElement(name = "lsp-id", required = false, type = Integer.class)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,title:Lsp ID,javaname:int,readOnly:true,defaultValue:0,ejbType:I")
    @Title(name = "Lsp ID")
    private Integer lspId;

    /***
     * @HyperlinkTemplate /api/jssdk/swag-dtu/current-lsp-lists/{lspId}
     **/

    @XmlAttribute(name = "uri", required = false)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:String,readOnly:true")
    private String uri;

    /***
     * @HyperlinkTemplate /api/jssdk/swag-dtu/current-lsp-list/{lspId}
     **/

    @XmlAttribute(name = "href", required = false)
    @Generated(value = "Generated", comments = "hasDefaultValue:false,javaname:String,readOnly:true")
    private String link;


    /**
     * @param numHops
     */
    public void setNumHops(Integer numHops) {
      this.numHops = numHops;
    }

    /**
     * @return Integer
     */
    public Integer getNumHops() {
      return numHops;
    }

    /**
     * @param speedAvg
     */
    public void setSpeedAvg(Integer speedAvg) {
      this.speedAvg = speedAvg;
    }

    /**
     * @return Integer
     */
    public Integer getSpeedAvg() {
      return speedAvg;
    }

    /**
     * @param lspInterface
     */
    public void setLspInterface(String lspInterface) {
      this.lspInterface = lspInterface;
    }

    /**
     * @return String
     */
    public String getLspInterface() {
      return lspInterface;
    }

    /**
     * @param pathUsable
     */
    public void setPathUsable(Boolean pathUsable) {
      this.pathUsable = pathUsable;
    }

    /**
     * @return Boolean
     */
    public Boolean isPathUsable() {
      return pathUsable;
    }

    /**
     * @param lowestMtu
     */
    public void setLowestMtu(Integer lowestMtu) {
      this.lowestMtu = lowestMtu;
    }

    /**
     * @return Integer
     */
    public Integer getLowestMtu() {
      return lowestMtu;
    }

    /**
     * @param lowestSpeed
     */
    public void setLowestSpeed(Integer lowestSpeed) {
      this.lowestSpeed = lowestSpeed;
    }

    /**
     * @return Integer
     */
    public Integer getLowestSpeed() {
      return lowestSpeed;
    }

    /**
     * @param lspId
     */
    public void setLspId(Integer lspId) {
      this.lspId = lspId;
    }

    /**
     * @return Integer
     */
    public Integer getLspId() {
      return lspId;
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
