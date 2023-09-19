package com.accenture.lkm.test;import org.junit.Assert; 

  

import org.junit.Test; 

import org.junit.runner.RunWith; 

  

import org.springframework.beans.factory.annotation.Autowired; 

import org.springframework.test.context.ContextConfiguration; 

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 

import java.util.Date; 

  

import com.accenture.lkm.business.bean.PurchaseBean; 

import com.accenture.lkm.services.PurchaseService; 

  

@RunWith(SpringJUnit4ClassRunner.class) 

@ContextConfiguration("file:WebContent/WEB-INF/cst-root-ctx.xml") 

public class PurchaseServiceTest { 

	@Autowired 

	private PurchaseService purchaseServiceObj; 

	 

	@Test 

	public void testSavePurchaseDetail() throws Exception { 

		PurchaseBean purchaseBean = new PurchaseBean(); 

		purchaseBean.setTransactionId("P_1234_PQR_"); 

		purchaseBean.setMaterialCategoryId("C001"); 

		purchaseBean.setMaterialTypeId("T001"); 

		purchaseBean.setUnitId("U002"); 

		purchaseBean.setMaterialCategoryName("ABC"); 

		purchaseBean.setMaterialTypeName("Cloth"); 

		purchaseBean.setMaterialUnitName("XYZ"); 

		purchaseBean.setBrandName("Gayatri"); 

		purchaseBean.setPurchaseAmount(2000.00); 

		purchaseBean.setQuantity(12); 

		purchaseBean.setBalance(200.00); 

		purchaseBean.setPurchaseDate(new Date()); 

		purchaseBean.setStatus("Pending"); 

		purchaseBean.setVendorName("Only Vimal"); 

		 

		PurchaseBean purchaseb= purchaseServiceObj.addPurchaseDetails(purchaseBean); 

		Assert.assertNotNull( "The PurchaseEntity is null!", purchaseb); 

		System.out.println("Done"); 

	} 

} 


