package vnd.jssdk.swagdtu;

/*******************************************************************************
 * FILE NAME: Device.java  
 * PURPOSE:  This class represent the Device DTO  
 *
 *
 * Revision History: 
 * DATE:           							  AUTHOR:              CHANGE:  
 * Mon Jun 13 14:43:28 IST 2011               Auto generated       Initial Version  
 * 
 * 
 ******************************************************************************/


import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import net.juniper.jmp.annotation.paging.Sortable;



/**
 * Created by Junos Space SDK
 * User: ${USERNAME}
 * Date: Mar 10, 2011
 * PURPOSE:  This class represent 
 * the Device DTO  
 */

public class Device implements Serializable  {
	private static final long serialVersionUID = -719368919349306773L;
	
	/*
	 * Device ID
	 */
	int id;
	
	/*
	 * Device name
	 */
	String name;
	/*
	 * Device IP address
	 */
	String ipAddr;

	/*
	 * Platform
	 */
	String platform;
	/**
	 * @return id
	 */
	
	/*
	 * Device Info Url
	 */
	String infoUrl;
	
	/**
	 * Device status (up or down)
	 */
	private String status;
	
	/**
	 * Latitude of device location
	 */
	private float latitude;
	
	/**
	 * Longitude of device location
	 */
	private float longitude;
	
    @Sortable(entityAttrName = "id")	
	public int getId() {
		return id;
	}
	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return name
	 */
    @Sortable(entityAttrName = "name")		
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return IP
	 */
    @Sortable(entityAttrName = "ipAddr")		
	public String getIpAddr() {
		return ipAddr;
	}
	/**
	 * @param IP
	 */
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	/**
	 * @return platform
	 */
    @Sortable(entityAttrName = "platform")		
	public String getPlatform() {
		return platform;
	}
	/**
	 * @param platform
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	/**
	 * @return infoUrl
	 */
	public String getInfoUrl() {
		return infoUrl;
	}
	/**
	 * @param infoUrl
	 */
	public void setInfoUrl(String infoUrl) {
		this.infoUrl = infoUrl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
}
