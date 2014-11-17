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
import net.juniper.jmp.ScheduleContext;
import net.juniper.jmp.annotation.scheduler.Schedulable;
import net.juniper.jmp.cmp.jobManager.JobInfoTO;
import net.juniper.jmp.cmp.jobManager.JobManagerCallerInterface3;
import net.juniper.jmp.exception.ForbiddenException;
import net.juniper.jmp.exception.PreconditionFailedException;

 
public interface SwagDTU extends JobManagerCallerInterface3 { 
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
 
	/**
	 * get all Ptp objects
	 * @param apic
	 * @param ctx
	 * @return
	 * @throws PreconditionFailedException
	 * @throws ForbiddenException
	 */
	public PagingResult<PTP> getAllPtps(ApiContext apic, PagingContext ctx) throws PreconditionFailedException, ForbiddenException;
	
	/**
	 * get individual device based on ID
	 * @param apic
	 * @param id
	 * @return
	 * @throws PreconditionFailedException
	 */
	public Device getDevice(ApiContext apic, int id) throws PreconditionFailedException;
	/**
	 * get PTP object based on id
	 * @param apic
	 * @param id
	 * @return
	 * @throws PreconditionFailedException
	 */
	public PTP getPtp(ApiContext apic,int id) throws PreconditionFailedException;
	
	/**
	 * Get image associated with the platform name
	 * @param platform
	 * 			Platform name for looking up platform image
	 * @return
	 * @throws Exception
	 */
	public byte [] getImage(String platform) throws Exception;
	
	/**
	 * Accepts an image, which is a byte array of data, and writes it to 'filename'
	 * @param bytes		- image content
	 * @param fileName	- image file, or platform name
	 */
	public void addImage(byte[] imageFileBytes, String imageFile) throws Exception;
	
	/*
	 * When called will run the method for getting all ptps in background 
	 */
	@Schedulable
	public JobInfoTO refreshTopology(ApiContext apiCtx,ScheduleContext scheduleCtx)throws Exception;
	
	/**
	 * return current list of Ptps
	 */
	public PagingResult<PTP> getCurrentPtpList();
	
	/**
	 * return the current LSPs and attributes
	 */
	public PagingResult<LSP> getCurrentLspList();
	/**
	 * return current list of devices
	 */
	public PagingResult<Device> getCurrentDeviceList();
	
	/**
	 * return current list of links
	 */
	public PagingResult<Link> getCurrentLinkList();
	
	/**
	 * get single device form list
	 
	/*
	 * Get individual link
	 */
	public Link getLink(String linkId);
}   