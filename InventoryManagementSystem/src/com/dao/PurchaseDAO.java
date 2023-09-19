package com.accenture.lkm.dao;

import com.accenture.lkm.business.bean.PurchaseBean;

public interface PurchaseDAO{
	public PurchaseBean savePurchaseDetail(PurchaseBean purchaseBean) throws Exception;

	public Boolean validateLogin(String userName, String password) throws Exception;


}
