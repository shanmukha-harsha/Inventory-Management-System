package com.accenture.lkm.web.client;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MaterialTypeConsumer {

	private static Logger LOGGER = Logger.getLogger(MaterialTypeConsumer.class);

	@Value("${MaterialServiceConsumer.serviceURL}")
	private String serviceURL;

	@Value("${MaterialTypeConsumer.apiURL}")
	private String apiURL;

	@Value("${MaterialTypeConsumer.apiURLByCategoryId}")
	private String apiURLByCategoryId;

	private RestTemplate restTemplate;

	private List<MaterialTypeBean> materialTypeBeanList;

	private Map<String, String> categoryTypeMap;

	public List<MaterialTypeBean> getMaterialTypeBeanList() throws MicroServiceException {
		hitGetMaterialType();
		return materialTypeBeanList;
	}

	public Map<String, String> getCategoryTypeMap() throws MicroServiceException {
		return categoryTypeMap;
	}

	public MaterialTypeConsumer() {
		restTemplate = new RestTemplate();
	}

	/**
	 * This method hits material microservice to get the list of Material type.
	 * 
	 * @return
	 * @throws MicroServiceException
	 */
	@SuppressWarnings("unchecked")
	private void hitGetMaterialType() throws MicroServiceException {
		String url = serviceURL + apiURL;
		System.out.println(url);
		//new MaterialTypeConsumer();
				List<LinkedHashMap<String, Object>> materialListMap = restTemplate.getForObject(serviceURL + apiURL , List.class); 
				System.out.println(materialListMap);
				//mapper to covert Object to a specific type  
				ObjectMapper mapper =  new ObjectMapper();
				this.materialTypeBeanList  = new ArrayList<MaterialTypeBean>();
				
				if (materialListMap != null) {
					for (LinkedHashMap<String, Object> map : materialListMap) {
						//Map object should be converted to Employee type 
						MaterialTypeBean emp=mapper.convertValue(map, MaterialTypeBean.class);
						this.materialTypeBeanList.add(emp);
					}
					System.out.println("Material Type Details are: "+this.materialTypeBeanList);
				} else {
					System.out.println("No user exist----------");
				}
	}

	/**
	 * This method hits material microservice to get the details of Material
	 * type based on category id.
	 * 
	 * @param categoryId
	 * @return List<MaterialTypeBean>
	 * @throws MicroServiceException
	 */
	public List<MaterialTypeBean> hitGetTypesBasedOnCategoryId(String categoryId) throws MicroServiceException {
		//new MaterialTypeConsumer();
		//RestTemplate restTemplate = new RestTemplate();
				//Hitting the Server URL and getting the response
		String url = serviceURL + apiURLByCategoryId + categoryId;
		System.out.println(url);
				List<LinkedHashMap<String, Object>> materialListMap = restTemplate.getForObject(serviceURL + apiURLByCategoryId + categoryId , List.class); 
				System.out.println(materialListMap);
				//mapper to covert Object to a specific type  
				ObjectMapper mapper =  new ObjectMapper();
				this.materialTypeBeanList  = new ArrayList<MaterialTypeBean>();
				
				if (materialListMap != null) {
					for (LinkedHashMap<String, Object> map : materialListMap) {
						//Map object should be converted to Employee type 
						MaterialTypeBean emp=mapper.convertValue(map, MaterialTypeBean.class);
						this.materialTypeBeanList.add(emp);
					}
					System.out.println("Material Type Details are: "+this.materialTypeBeanList);
				} else {
					System.out.println("No user exist----------");
				}
		return materialTypeBeanList;
	}

}
