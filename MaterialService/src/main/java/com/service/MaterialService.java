package com.accenture.lkm.service;

import java.util.List;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.UnitBean;

public interface MaterialService {
	MaterialCategoryBean getMaterialCategoryById(String categoryId);
	List<MaterialCategoryBean> getMaterialCategories();
	
	List<MaterialTypeBean> getMaterialTypeById(String categoryId);
	List<MaterialTypeBean> getMaterialTypes();
	
	List<UnitBean> getUnitById(String categoryId);
	List<UnitBean> getUnits();
}
