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
import com.accenture.lkm.exceptions.MicroServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MaterialCategoryConsumer {

	private static Logger LOGGER = Logger.getLogger(MaterialCategoryConsumer.class);

	@Value("${MaterialServiceConsumer.serviceURL}")
	private String serviceURL;
	@Value("${MaterialCategoryConsumer.apiURL}")
	private String apiURL;
	@Value("${MaterialCategoryConsumer.apiURLForById}")
	private String apiURLForById;
	private RestTemplate restTemplate;
	private List<MaterialCategoryBean> materialCategoryBeanList;
	private Map<String, String> categoryMap;

	public Map<String, String> getCategoryMap() throws MicroServiceException {
		return categoryMap;
	}

	public List<MaterialCategoryBean> getMaterialCategoryBeanList() throws MicroServiceException {
		hitGetMaterialCategories();
		return materialCategoryBeanList;
	}

	public MaterialCategoryConsumer() {
		restTemplate = new RestTemplate();
	}

	/**
	 * This method hits material microservice to get the list of Material
	 * category.
	 * 
	 * @return
	 * @throws MicroServiceException
	 */
	@SuppressWarnings("unchecked")
	public void hitGetMaterialCategories() throws MicroServiceException {

		//RestTemplate restTemplate = new RestTemplate();
		//Hitting the Server URL and getting the response
		System.out.println(serviceURL + apiURL);
		List<LinkedHashMap<String, Object>> materialListMap = restTemplate.getForObject(serviceURL + apiURL , List.class); 
		
		//mapper to covert Object to a specific type  
		ObjectMapper mapper =  new ObjectMapper();
		this.materialCategoryBeanList  = new ArrayList<MaterialCategoryBean>();
		
		if (materialListMap != null) {
			for (LinkedHashMap<String, Object> map : materialListMap) {
				//Map object should be converted to Employee type 
				MaterialCategoryBean emp=mapper.convertValue(map, MaterialCategoryBean.class);
				this.materialCategoryBeanList.add(emp);
			}
			System.out.println("Material Details are: "+this.materialCategoryBeanList);
		} else {
			System.out.println("No user exist----------");
		}
		
	}

	/**
	 * This method hits material microservice to get the details of Material
	 * category for given category id.
	 * 
	 * @param categoryId
	 * @return MaterialCategoryBean
	 * @throws MicroServiceException
	 */
	public MaterialCategoryBean hitGetMaterialCategoryById(String categoryId) throws MicroServiceException {
		return null;
	}

}
