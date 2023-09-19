package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.dao.VendorDAO;
import com.accenture.lkm.entity.VendorEntity;

@Service
public class VendorServiceImpl implements VendorService{

	private static final Logger logger = LoggerFactory.getLogger(VendorServiceImpl.class);
	
	/*
	 * Autowire VendorDAO object
	 * 
	 * */
	@Autowired
	private VendorDAO vendorDAO;
	
	
	// Your Code Here

	
	/*
	 * Method - getVendorDetails()
	 * Use the VendorDAO to get all the vendors
	 * Check if vendors is not empty then 
	 * 		Declare VendorBean object with null value
	 * 		Loop through all the vendors 
	 * 			Create a new bean object 
	 * 			Copy each property value of entity object to bean object
	 * 			Add the bean object to the vendorBeans list
	 * */

	@Override
	public List<VendorBean> getVendorDetails() {
		List<VendorBean> vendorBeans = null;
		
		// Your Code Here
		List<VendorEntity> vendorEntityList = vendorDAO.findAll(); 

		if(vendorEntityList != null) { 

			vendorBeans = new ArrayList<VendorBean>(); 

			for(VendorEntity entity : vendorEntityList) { 

				VendorBean bean = new VendorBean(); 

				BeanUtils.copyProperties(entity, bean); 

				vendorBeans.add(bean); 

			} 

		} 
		
		return vendorBeans;
	} 

}
