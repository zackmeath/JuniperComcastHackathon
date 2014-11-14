/*******************************************************************************  
 * FILE NAME: HelloSpaceConstants.java  
 * PURPOSE:   This Class contains Java Constant used to create Media Type 
 *   
 * Revision History:  
 * DATE:                             AUTHOR:             CHANGE:    
 * Mon Jun 20 16:16:10 PDT 2011      Auto Generated      Initial creation  
 *******************************************************************************/ 
package vnd; 

/**
 * Created by Junos Space SDK.
 * User: alexk
 * Date: Mon Jun 20 16:16:10 PDT 2011
 */
public interface AppConstants { 
	/**
	 * This is the vendor ID field used in REST code for generating media type string
	 * in Produces and Consumes, This field's value should be in sync with your Vendor ID.
	 * This constant should be used to get vendor id in case of SDK installation or SDK repair.
	 */
	public static final String VENDOR_ID = "jssdk";
	public static final String API_URL_PREFIX = "/api";
	public static final String APPLICATION_VND = "application/vnd";
	public static final String JUNIPER_VND = APPLICATION_VND + ".net.juniper.space";
	public static final String SPACE_URL_PREFIX = API_URL_PREFIX + "/space";
	public static final String SPACE_DATATYPE_PREFIX = APPLICATION_VND + ".net.juniper.space";
	public static final String APP_PREFIX = "hello-space";
	public static final String APP_URL_PREFIX = API_URL_PREFIX + "/" + VENDOR_ID + "/" + APP_PREFIX;
	public static final String APP_DATATYPE_PREFIX = APPLICATION_VND + "." + VENDOR_ID + "." + APP_PREFIX;
}  