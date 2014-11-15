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
	
	private PTP ptpA;
	private PTP ptpB;
	private Device deviceA;
	private Device deviceB;
	
	public Link(PTP pa, Device a, PTP pb, Device b) {
		this.deviceA = a;
		this.deviceB = b;
		this.ptpA = pa;
		this.ptpB = pb; // & J!
	}
	
//getters and setters
	public Boolean isDown() {
		return (ptpA.getOperationStatus().compareTo("up") != 0 || ptpB.getOperationStatus().compareTo("up") != 0);
	}
	public String getType(){
		return ptpA.getLinkType();
	}
	public String getLevelType(){
		return ptpA.getLinkLevelType();
	}
	public int getSpeed(){
		return ptpA.getSpeed();
	}
	public String getSpeedStr(){
		return ptpA.getSpeedStr();
	}
	public int getMtu(){
		return ptpA.getMtu();
	}
	public String getMtuStr(){
		return ptpA.getMtuStr();
	}
	public int getEncapsulation(){
		return ptpA.getMtu();
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
	

}
