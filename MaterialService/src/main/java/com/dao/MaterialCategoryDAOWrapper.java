package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.entity.MaterialCategoryEntity;

@Repository
public class MaterialCategoryDAOWrapper 
{
	@Autowired
	private MaterialCategoryDAO materialCategoryDAO;
	
	public MaterialCategoryBean getMaterialCategoryById(String categoryId) 
	{

		MaterialCategoryBean materialCategoryBean = null;

		MaterialCategoryEntity materialCategoryEntity = new MaterialCategoryEntity();
		materialCategoryEntity = materialCategoryDAO.findByCategoryId(categoryId);
		if (materialCategoryEntity != null) {
			materialCategoryBean = convertEntityToBean(materialCategoryEntity);
		}
		return materialCategoryBean;
	}
	
	public List<MaterialCategoryBean> getMaterialCategories() 
	{

		List<MaterialCategoryBean> materialCategoryBeans = new ArrayList<MaterialCategoryBean>();
		List<MaterialCategoryEntity> materialCategoryEntities = materialCategoryDAO.findAll();
		for(MaterialCategoryEntity m : materialCategoryEntities)
			materialCategoryBeans.add(convertEntityToBean(m));
		
		return materialCategoryBeans;
	}
	
	public MaterialCategoryBean convertEntityToBean(MaterialCategoryEntity materialCategoryEntity)
	{
		MaterialCategoryBean materialCategoryBean= new MaterialCategoryBean();
		BeanUtils.copyProperties(materialCategoryEntity, materialCategoryBean);
		
		return materialCategoryBean;
	}

}
