package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.entity.MaterialTypeEntity;

@Repository
public class MaterialTypeDAOWrapper 
{
	@Autowired
	private MaterialTypeDAO materialTypeDAO;
	
	public List<MaterialTypeBean> getMaterialTypeById(String categoryId) 
	{

		List<MaterialTypeBean> materialTypeBean = new ArrayList<MaterialTypeBean>();
		List<MaterialTypeEntity> materialTypeEntity =null;
		materialTypeEntity = materialTypeDAO.findByCategoryId(categoryId);
		if (materialTypeEntity != null) {
			for(MaterialTypeEntity e:materialTypeEntity) {
			MaterialTypeBean mb = convertEntityToBean(e);
			materialTypeBean.add(mb);
			}
		}
		return materialTypeBean;
	}
	
	public List<MaterialTypeBean> getMaterialTypes() 
	{

		List<MaterialTypeBean> materialTypeBeans = new ArrayList<MaterialTypeBean>();
		List<MaterialTypeEntity> materialTypeEntities = materialTypeDAO.findAll();
		for(MaterialTypeEntity m : materialTypeEntities)
			materialTypeBeans.add(convertEntityToBean(m));
		
		return materialTypeBeans;
	}
	
	public MaterialTypeBean convertEntityToBean(MaterialTypeEntity materialTypeEntity)
	{
		MaterialTypeBean materialTypeBean= new MaterialTypeBean();
		BeanUtils.copyProperties(materialTypeEntity, materialTypeBean);
		
		return materialTypeBean;
	}

}
