package com.accenture.lkm.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.dao.MaterialCategoryDAOWrapper;
import com.accenture.lkm.dao.MaterialTypeDAOWrapper;
import com.accenture.lkm.dao.UnitDAOWrapper;

@Service
public class MaterialServiceImpl implements MaterialService {

	private static final Logger logger = LoggerFactory.getLogger(MaterialServiceImpl.class);
	/*
	 * Autowire MaterialCategoryDAO object
	 * 
	 * */

	@Autowired
	MaterialCategoryDAOWrapper materialCategoryDAOWrapper; 
	
	@Autowired
	MaterialTypeDAOWrapper materialTypeDAOWrapper; 

	@Autowired
	UnitDAOWrapper unitDAOWrapper; 


	/*
	 * Method - getMaterialCategoryById()
	 * Use MaterialCategoryDAO object findById method to fetch the entity by --> categoryId
	 * Check if the entity is present
	 * 		initialized the materialCategoryBean object
	 * 		copy the properties value from entity to materialCategoryBean object
	 * */

//	--------------------Material Category Service----------------------
	@Override
	public MaterialCategoryBean getMaterialCategoryById(String categoryId) {
		MaterialCategoryBean materialCategoryBean = null;
		materialCategoryBean = materialCategoryDAOWrapper.getMaterialCategoryById(categoryId);
        return materialCategoryBean;
	}

	
	/*
	 * Method - getMaterialCategories()
	 * Use the MaterialCategoryDAO to get all the MaterialCategoryEntity objects
	 * Check if list is not empty then 
	 * 		Declare a MaterialCategoryBean object with null value
	 * 		Loop through all the material categories
	 * 			Initialize a new MaterialCategoryBean object 
	 * 			Copy each property value of entity object to bean object
	 * 			Add the bean object to the materialCategoryBeans list
	 * */

	
	@Override
	public List<MaterialCategoryBean> getMaterialCategories() 
	{
		List<MaterialCategoryBean> materialCategoryBean = materialCategoryDAOWrapper.getMaterialCategories();
			return materialCategoryBean;
	}
	
// 	--------------------Material Type Service----------------------
	
	@Override
	public List<MaterialTypeBean> getMaterialTypeById(String categoryId) {
		List<MaterialTypeBean> materialTypeBean = null;
		materialTypeBean = materialTypeDAOWrapper.getMaterialTypeById(categoryId);
        return materialTypeBean;
	}

	@Override
	public List<MaterialTypeBean> getMaterialTypes() 
	{
		List<MaterialTypeBean> materialTypeBean = materialTypeDAOWrapper.getMaterialTypes();
			return materialTypeBean;
	}
	
	
//	--------------------Unit Service----------------------
	@Override
	public List<UnitBean> getUnitById(String categoryId) {
		List<UnitBean> unitBean = null;
		unitBean = unitDAOWrapper.getUnitById(categoryId);
        return unitBean;
	}

	@Override
	public List<UnitBean> getUnits() 
	{
		List<UnitBean> unitBean = unitDAOWrapper.getUnits();
			return unitBean;
	}
	
}
