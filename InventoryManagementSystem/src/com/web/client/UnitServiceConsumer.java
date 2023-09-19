package com.accenture.lkm.web.client;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UnitServiceConsumer {

	private static Logger LOGGER = Logger.getLogger(UnitServiceConsumer.class);

	@Value("${MaterialServiceConsumer.serviceURL}")
	private String serviceURL;

	@Value("${UnitServiceConsumer.apiURL}")
	private String apiURL;

	@Value("${UnitServiceConsumer.apiURLByCategoryId}")
	private String apiURLByCategoryId;

	private List<UnitBean> unitBeanList;

	private Map<String, String> unitMap;

	private RestTemplate restTemplate;

	public List<UnitBean> getUnitBeanList() throws MicroServiceException {
		return unitBeanList;
	}

	public Map<String, String> getUnitMap() throws MicroServiceException {
		return unitMap;
	}

	public UnitServiceConsumer() {
		restTemplate = new RestTemplate();
	}

	/**
	 * This method hits material microservice to get the list of unit.
	 * 
	 * @return
	 * @throws MicroServiceException
	 */
	private void hitGetUnitDetails() throws MicroServiceException {

	}

	/**
	 * This method hits material microservice to get the list of unit available
	 * for a given category id.
	 * 
	 * @param categoryId
	 * @return List<UnitBean>
	 * @throws MicroServiceException
	 */
	public List<UnitBean> hitGetUnitsByCategoryId(String categoryId) throws MicroServiceException {
		String url = serviceURL + apiURLByCategoryId + categoryId;
		System.out.println(url);
				List<LinkedHashMap<String, Object>> materialListMap = restTemplate.getForObject(serviceURL + apiURLByCategoryId + categoryId , List.class); 
				System.out.println(materialListMap);
				//mapper to covert Object to a specific type  
				ObjectMapper mapper =  new ObjectMapper();
				this.unitBeanList  = new ArrayList<UnitBean>();
				
				if (materialListMap != null) {
					for (LinkedHashMap<String, Object> map : materialListMap) {
						//Map object should be converted to Employee type 
						UnitBean emp=mapper.convertValue(map, UnitBean.class);
						this.unitBeanList.add(emp);
					}
					System.out.println("Unit Details are: "+this.unitBeanList);
				} else {
					System.out.println("No user exist----------");
				}
		return unitBeanList;
	}

}
