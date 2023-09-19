package com.accenture.lkm.test;   

  

import static org.junit.Assert.assertFalse; 

import static org.junit.Assert.assertNotNull; 

import java.util.Date; 

  

import org.junit.Test; 

import org.junit.runner.RunWith; 

import org.springframework.beans.factory.annotation.Autowired; 

import org.springframework.test.context.ContextConfiguration; 

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 

  

import com.accenture.lkm.business.bean.PurchaseBean; 

import com.accenture.lkm.dao.PurchaseDAO;  

  

  

@RunWith(SpringJUnit4ClassRunner.class) 

@ContextConfiguration("file:WebContent/WEB-INF/cst-root-ctx.xml") 

  

public class PurchaseDAOTest {  

	  

	@Autowired  

	private PurchaseDAO purchaseDAO;  

	   

	 

	@Test  

	public void testSavePurchaseDetail() {  

		//implementation goes here  

		PurchaseBean purchaseBean = new PurchaseBean(); 

		purchaseBean.setTransactionId("P_1234_PQR_"); 

		purchaseBean.setMaterialCategoryId("C001"); 

		purchaseBean.setMaterialTypeId("T001"); 

		purchaseBean.setUnitId("U002"); 

		purchaseBean.setMaterialCategoryName("ABC"); 

		purchaseBean.setMaterialTypeName("Cloth"); 

		purchaseBean.setMaterialUnitName("XYZ"); 

		purchaseBean.setBrandName("gpp1"); 

		purchaseBean.setPurchaseAmount(2000.00); 

		purchaseBean.setQuantity(12); 

		purchaseBean.setBalance(200.00); 

		purchaseBean.setPurchaseDate(new Date()); 

		purchaseBean.setStatus("Complete"); 

		purchaseBean.setVendorName("Only Vimal"); 

		 

		//PurchaseDAO purchaseDAOImpl = new PurchaseDAOImpl();  

		 

		try {  

			PurchaseBean purchaseBean1 = purchaseDAO.savePurchaseDetail(purchaseBean);  

			System.out.println("PurchaseId: "+purchaseBean1.getPurchaseId()); 

			assertFalse(purchaseBean1.getBrandName().equals("qwerty"));  

			assertNotNull(purchaseBean1);  

			System.out.println("Done"); 

		}  

		catch (Exception e) {  

			// TODO Auto-generated catch block  

			e.printStackTrace();  

  

		}  

 	}  

 } 