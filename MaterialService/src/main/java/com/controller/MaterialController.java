package com.accenture.lkm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.service.MaterialService;

@RestController
public class MaterialController {

	private static final Logger logger = LoggerFactory.getLogger(MaterialController.class);
	
	/* 
	 * Autowire the MaterialService object 
	 *  
	 * */ 
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "Welcome to Spring Boot Vendor Service API from Material Controller!";
	}
	
	
	@Autowired 
	private MaterialService materialService; 

// ----------------------------Material Category----------------------------
	@RequestMapping(value= "/material/controller/getMaterialCategories", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<List<MaterialCategoryBean>> getMaterialCategories() 
	{ 
		// Your Code Here 
		return new ResponseEntity<List<MaterialCategoryBean>>(materialService.getMaterialCategories(),HttpStatus.OK); 
	} 

	@RequestMapping(value= "/material/controller/getMaterialCategoryById/{categoryId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<MaterialCategoryBean> getMaterialCategoryById(@PathVariable String categoryId) { 
		// Your Code Here 
		return new ResponseEntity<MaterialCategoryBean>(materialService.getMaterialCategoryById(categoryId),HttpStatus.OK); 
	}
	

// ----------------------------Material Type----------------------------	
	@RequestMapping(value= "/type/controller/getTypeDetails", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<List<MaterialTypeBean>> getMaterialTypes() 
	{ 
		// Your Code Here 
		return new ResponseEntity<List<MaterialTypeBean>>(materialService.getMaterialTypes(),HttpStatus.OK); 
	} 

	@RequestMapping(value= "/type/controller/getTypeDetailsByCategoryId//{categoryId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<List<MaterialTypeBean>> getMaterialTypeById(@PathVariable String categoryId) { 
		// Your Code Here 
		return new ResponseEntity<List<MaterialTypeBean>>(materialService.getMaterialTypeById(categoryId),HttpStatus.OK); 
	}
	
	
// ----------------------------Unit----------------------------	
	@RequestMapping(value= "/unit/controller/getUnitDetails", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<List<UnitBean>> getUnits() 
	{ 
		// Your Code Here 
		return new ResponseEntity<List<UnitBean>>(materialService.getUnits(),HttpStatus.OK); 
	} 

	@RequestMapping(value= "/unit/controller/getUnitsByCategoryId/{categoryId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<List<UnitBean>> getUnitById(@PathVariable String categoryId) { 
		// Your Code Here 
		return new ResponseEntity<List<UnitBean>>(materialService.getUnitById(categoryId),HttpStatus.OK); 
	}
} 
	

