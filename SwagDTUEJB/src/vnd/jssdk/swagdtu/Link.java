//     .---_   _--._---.__                 Get it?
//    /   _ \/\     \     ''-.                its Link.java...
//   |   / \ | \      '.     '.     .'¯|           
//   |  / __\|  '.      '.     '    \ _|
//   | | |_  .-'_'.      .    _.-|  $$
//   | | \U\\ .¯U' '..    _.-' .'  $$
//    \| /¯ /  ¯¯     ' |'   .'|   $$
//      \| '-          '|  .'  |  $$
//        \ --         /.      \ $$
//         \          .'   __   |$$
//          '.   ___.'  | ////¯¯''.._
//            ¯|¯      _'.//_ ..   ||||
//       _ .-¯|\|----¯¯¯  |\|¯¯|---||||
//    .-¯.'  |  X      .''  \  |       ''.
//   '    ''..      .''__... |/           '.
//   | |    .|   .' .-   / \|              |
//  /  '      '.'...'   /  /               |
// /_ |        '       /  /     |          |
//  |¯|                '  '     \| __.-.___.'
//  | |              /  /        |\         \
//  | .             /  /           |        .
//  | '            '  '            |        '
//   \ .        /  /               '        |
//   /  '      '  '                 |       \
//  /   '                           |        |


package vnd.jssdk.swagdtu;

import net.juniper.jmp.ApiContext;

public class Link {
	private static final long serialVersionUID = -719368919349306773L;
	private PTP ptpA;
	private PTP ptpB;
	private Device deviceA;
	private Device deviceB;
	private String linkId;	
	private int currSpeed;
	private String speedStr;
	private String mtuStr;
	private String devAIpAddr;
	private String devBIpAddr;
	private String devAName;
	private String devBName;
	private String devBInterface;
	private String devAInterface;
	private String operationStatus;
	
//getters and setters
	public void setlinkId(String tmpLinkId){
		this.linkId = tmpLinkId;
	}
	public String getLinkId(){
		return linkId;
	}	
	public PTP getPtpA() {
		return ptpA;
	}
	public void setPtpA(PTP ptpA) {
		this.ptpA = ptpA;
	}
	public PTP getPtpB() {
		return ptpB;
	}
	public void setPtpB(PTP ptpB) {
		this.ptpB = ptpB;
	}
	public Device getDeviceA() {
		return deviceA;
	}
	public void setDeviceA(Device deviceA) {
		this.deviceA = deviceA;
	}
	public Device getDeviceB() {
		return deviceB;
	}
	public void setDeviceB(Device deviceB) {
		this.deviceB = deviceB;
	}
//
	public int getCurrSpeed() {
		return currSpeed;
	}
	public void setCurrSpeed(int currSpeed) {
		this.currSpeed = currSpeed;
	}
	public String getSpeedStr() {
		return speedStr;
	}
	public void setSpeedStr(String speedStr) {
		this.speedStr = speedStr;
	}
	public String getMtuStr() {
		return mtuStr;
	}
	public void setMtuStr(String string) {
		this.mtuStr = string;
	}
	public String getDevAIpAddr() {
		return devAIpAddr;
	}
	public void setDevAIpAddr(String devAIpAddr) {
		this.devAIpAddr = devAIpAddr;
	}
	public String getDevBIpAddr() {
		return devBIpAddr;
	}
	public void setDevBIpAddr(String devBIpAddr) {
		this.devBIpAddr = devBIpAddr;
	}
	public String getDevAName() {
		return devAName;
	}
	public void setDevAName(String devAName) {
		this.devAName = devAName;
	}
	public String getDevBName() {
		return devBName;
	}
	public void setDevBName(String devBName) {
		this.devBName = devBName;
	}
	public String getDevBInterface() {
		return devBInterface;
	}
	public void setDevBInterface(String devBInterface) {
		this.devBInterface = devBInterface;
	}
	public String getOperationStatus() {
		return operationStatus;
	}
	public void setOperationStatus(String operationStatus) {
		this.operationStatus = operationStatus;
	}
	public String getDevAInterface() {
		return devAInterface;
	}
	public void setDevAInterface(String devAInterface) {
		this.devAInterface = devAInterface;
	}
	

}
