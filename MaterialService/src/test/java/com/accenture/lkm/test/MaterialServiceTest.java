package com.accenture.lkm.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.service.MaterialService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(MaterialServiceTest.class);
	
	@Autowired
	MaterialService materialService;
	
	
	@Test
	public void notNullMaterialServiceTest()
	{
		assertNotNull("Material Service is null",materialService);
	}
	
	
	@Test
	public void notNullgetMaterialDetailsTest()
	{
			assertNotNull("Material Service categories returned are null",materialService.getMaterialCategories());
	}
	
	@Test
	public void countGetMaterialDetailTest()
	{
		assertEquals("Material Service categories returned are 3 records", 3, materialService.getMaterialCategories().size());
		
	}
	
	
}
