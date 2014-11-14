package vnd.jssdk.swagdtu;

import java.io.Serializable;

public class PTP implements Serializable{
	private static final long serialVersionUID= -719368919349306773L;	
	/*
	 * PTP id
	 */
	int id;
		
	//ptp infourl
	String infoUrl;
	/*
	 * Ptp name
	 */
	String name;
	
	//managed device Ipaddress
	String managedDevIpAddress;
	
	//encapsulation
	String encapsulation;
	
	//description
	String description;
	
	//deviceID
	int deviceID;
	
	//is it loopback?
	String loopback;
	
	//Tagging
	String tagging;
	
	//adminStatus
	String adminStatus;
	
	//operationStatus
	String operationStatus;
	
	//linkLevelType
	String linkLevelType;
	
	//link type
	String linkType;
	
	//Speed
	int speed;
	
	//Speed Str
	String speedStr;
	
	//mtu
	int mtu;
	
	//mtu Str
	String mtuStr;
	
	//mac address
	String macAddress;
	
	//managedDevice id
	int managedDeviceId;
	
	
	public void setID(int id){
		this.id=id;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setManagedDevIpAddress(String ipAddress){
		this.managedDevIpAddress=ipAddress;
	}
	public void setEncapsulation(String encapsulation){
		this.encapsulation=encapsulation;
	}
	public void setDescription(String description){
		this.description=description;
	}
	public void setPTPId(int id){
		this.id=id;
	}
	public void setTagging(String tagging){
		this.tagging=tagging;
	}
	public void setAdminStatus(String adminStatus){
		this.adminStatus=adminStatus;
	}
	public void setOperationStatus(String operationStatus){
		this.operationStatus=operationStatus;
	}
	public void setLinkLevelType(String type){
		this.linkLevelType=type;
	}
	public void setLoopbackEnabled(String loopback){
		this.loopback=loopback;
	}
	public void setLinkType(String linkType){
		this.linkType=linkType;
	}
	public void setSpeed(int speed){
		this.speed=speed;
	}
	public void setSpeedStr(String speedStr){
		this.speedStr=speedStr;
	}
	public void setMtu(int mtu){
		this.mtu=mtu;
	}
	public void setMtuStr(String mtuStr){
		this.mtuStr=mtuStr;
	}
	public void setMacAddress(String macAddress){
		this.macAddress=macAddress;
	}
	public void setinfoUrl(String infoUrl){
		this.infoUrl=infoUrl;
	}
	public void setDeviceID(int deviceID){
		this.deviceID=deviceID;
	}
	public void setManagedDeviceID(int manDevId){
		this.managedDeviceId=manDevId;
	}
	
	
	public int getManagedDeviceID(){
		return managedDeviceId;
	}
	public int getID(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getManagedDevIpAddress(){
		return managedDevIpAddress;
	}
	public String getEncapsulation(){
		return encapsulation;
	}
	public String getDescription(){
		return description;
	}
	public int getPTPId(){
		return id;
	}
	public String getTagging(){
		return tagging;
	}
	public String getAdminStatus(){
		return adminStatus;
	}
	public String getOperationStatus(){
		return operationStatus;
	}
	public String getLinkLevelType(){
		return linkLevelType;
	}
	public String getLoopbackEnabled(){
		return loopback;
	}
	public String getLinkType(){
		return linkType;
	}
	public int getSpeed(){
		return speed;
	}
	public String getSpeedStr(){
		return speedStr;
	}
	public int getMtu(){
		return mtu;
	}
	public String getMtuStr(){
		return mtuStr;
	}
	public String getMacAddress(){
		return macAddress;
	}
	public String getInfoUrl(){
		return infoUrl;
	}
	public int getDeviceID(){
		return deviceID;
	}
}
