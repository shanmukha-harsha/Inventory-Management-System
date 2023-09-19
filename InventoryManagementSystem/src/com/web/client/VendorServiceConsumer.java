package com.accenture.lkm.web.client; 

import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.LinkedHashMap; 
import java.util.List; 
import java.util.Map; 

import org.apache.log4j.Logger; 
import org.springframework.beans.factory.annotation.Value; 
import org.springframework.stereotype.Service; 
import org.springframework.web.client.RestTemplate; 
  
import com.accenture.lkm.business.bean.VendorBean; 
import com.accenture.lkm.exceptions.MicroServiceException; 
import com.fasterxml.jackson.databind.ObjectMapper; 
  

@Service 
public class VendorServiceConsumer { 

	private static Logger LOGGER = Logger.getLogger(VendorServiceConsumer.class);   

	@Value("${VendorServiceConsumer.serviceURL}") 
	private String serviceURL; 

	@Value("${VendorServiceConsumer.apiURL}") 
	private String apiURL; 

	private List<VendorBean> vendorBeanList; 
  
	private Map<String, VendorBean> vendorMap; 

	private RestTemplate restTemplate; 

	public List<VendorBean> getVendorBeanList() throws MicroServiceException { 
		hitGetVendorDetails(); 
		return vendorBeanList; 
	} 

	public Map<String, VendorBean> getVendorMap() { 
		return vendorMap; 
	} 

	public VendorServiceConsumer() { 
		restTemplate = new RestTemplate(); 
	} 
  

	/** 
	 * This method is hitting vendor microservice to get the list of vendors 
	 *  
	 * @return 
	 * @throws MicroServiceException 
	 */ 

	@SuppressWarnings("unchecked") 
	private void hitGetVendorDetails() throws MicroServiceException { 
		List<LinkedHashMap<String, Object>> vendorMapList = restTemplate.getForObject(serviceURL + apiURL, List.class); 
		
		ObjectMapper mapper = new ObjectMapper(); 

		List<VendorBean> vendorList = new ArrayList<VendorBean>(); 

		if(vendorMapList != null) { 
			for(LinkedHashMap<String, Object> map : vendorMapList) { 
				VendorBean vendorBean = mapper.convertValue(map, VendorBean.class); 
				vendorList.add(vendorBean); 
			} 
			this.vendorBeanList = vendorList; 
			System.out.println("Vendor List: " + this.vendorBeanList); 
		} 
		else { 
			System.out.println("No vendor retrieved"); 
		} 
	} 

} 