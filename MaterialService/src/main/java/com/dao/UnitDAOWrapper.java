package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.entity.UnitEntity;

@Repository
public class UnitDAOWrapper 
{
	@Autowired
	private UnitDAO unitDAO;
	
	public List<UnitBean> getUnitById(String categoryId) 
	{

		List<UnitBean> unitBean = new ArrayList<UnitBean>();
		List<UnitEntity> unitEntity = null;
		unitEntity = unitDAO.findByCategoryId(categoryId);
		if (unitEntity != null) {
			for(UnitEntity e:unitEntity) {
				
			UnitBean unit = convertEntityToBean(e);
			unitBean.add(unit);
			}
		}
		return unitBean;
	}
	
	public List<UnitBean> getUnits() 
	{

		List<UnitBean> unitBeans = new ArrayList<UnitBean>();
		List<UnitEntity> unitEntities = unitDAO.findAll();
		for(UnitEntity m : unitEntities)
			unitBeans.add(convertEntityToBean(m));
		
		return unitBeans;
	}
	
	public UnitBean convertEntityToBean(UnitEntity unitEntity)
	{
		UnitBean unitBean= new UnitBean();
		BeanUtils.copyProperties(unitEntity, unitBean);
		
		return unitBean;
	}

}
