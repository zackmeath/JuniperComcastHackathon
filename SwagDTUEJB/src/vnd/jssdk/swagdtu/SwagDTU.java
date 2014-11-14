/*******************************************************************************  
 * FILE NAME: SwagDTU.java  
 * PURPOSE:   This interface exposes SwagDTU application's services as a remote interface.  
 *   
 * Revision History:  
 * DATE:                             AUTHOR:             CHANGE:    
 * Wed Nov 12 16:16:16 EST 2014   ${USERNAME}      Initial creation  
 *******************************************************************************/ 
package vnd.jssdk.swagdtu; 

import net.juniper.jmp.ApiContext;
import net.juniper.jmp.PagingContext;
import net.juniper.jmp.PagingResult;
import net.juniper.jmp.exception.ForbiddenException;
import net.juniper.jmp.exception.PreconditionFailedException;

 
public interface SwagDTU  { 
	/**
	 * Returns list of devices listing their ID ,IP and Name
	 * 
	 * @param ctx
	 *            Reference of PagingContext
	 * @param queryString
	 * 			  URL Query String passed into the web service           
	 * 
	 * @exception Exception
	 * 
	 * @return PagingResult<Device> paging result of list of Devices
	 * @throws PreconditionFailedException 
	 * @throws ForbiddenException 
	 */
	public PagingResult<Device> getAllDevices(ApiContext apic, PagingContext ctx) throws PreconditionFailedException, ForbiddenException;
 

	public PagingResult<PTP> getAllPtps(ApiContext apic, PagingContext ctx) throws PreconditionFailedException, ForbiddenException;
	

	public Device getDevice(ApiContext apic, int id) throws PreconditionFailedException;
	
	public PTP getPtp(ApiContext apic,int id) throws PreconditionFailedException;
	 
}  