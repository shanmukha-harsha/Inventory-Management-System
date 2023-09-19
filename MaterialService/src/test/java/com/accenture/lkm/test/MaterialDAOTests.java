package com.accenture.lkm.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.dao.MaterialCategoryDAO;
import com.accenture.lkm.entity.MaterialCategoryEntity;

//import com.accenture.lkm.test.controller.MaterialControllerTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialDAOTests {
	private static final Logger logger = LoggerFactory.getLogger(MaterialDAOTests.class);

	@Test
	public void contextLoads() {
		logger.info("UNIT TEST STARTED");
		assertEquals("STRING VALUE NOT SAME!","Spring Boot", "Spring Boot");
	}
	
	@Autowired
	MaterialCategoryDAO materialCategoryDAO;
	
	@Test
	public void notNullMaterialDAOTest() {
		assertNotNull(materialCategoryDAO);
	}

	@Test
	public void findByCategoryIdMaterialDAOTest() 
	{
		MaterialCategoryEntity materialCategoryEntity = materialCategoryDAO.findByCategoryId("C001");
		assertNotNull(materialCategoryEntity);
		assertEquals("Thread", materialCategoryDAO.findByCategoryId("C001").getCategoryName());
	}
	
	@Test
	public void getMaterialCategoriesMaterialDAOTest() {
		List<MaterialCategoryEntity> materialCategoryEntity=new ArrayList<MaterialCategoryEntity>();
		
		assertTrue(materialCategoryDAO.findAll().get(0).getCategoryName().equals("Thread"));
		
		MaterialCategoryEntity materialCategoryEntity1 = materialCategoryDAO.findByCategoryId("C001");
		assertEquals("Thread", materialCategoryEntity1.getCategoryName());
	}

}
