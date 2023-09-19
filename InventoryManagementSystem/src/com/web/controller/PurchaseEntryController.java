package com.accenture.lkm.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.accenture.lkm.services.PurchaseService;
import com.accenture.lkm.web.client.MaterialCategoryConsumer;
import com.accenture.lkm.web.client.MaterialTypeConsumer;
import com.accenture.lkm.web.client.UnitServiceConsumer;
import com.accenture.lkm.web.client.VendorServiceConsumer;

/**
 * <br/>
 * CLASS DESCRIPTION: <br/>
 * A controller class for receiving and handling all material purchase related
 * transactions from the User Interface. <br/>
 *
 */
@Controller
@SessionAttributes({ "purchaseBean" })
public class PurchaseEntryController {

	private static Logger LOGGER = Logger.getLogger(PurchaseEntryController.class);

	// Auto wire PurchaseService here
	@Autowired
	private PurchaseService purchaseService;

	// Auto wire VendorServiceConsumer here
	@Autowired
	private VendorServiceConsumer vendorServiceConsumer;

	// Auto wire MaterialCategoryConsumer here
	@Autowired
	private MaterialCategoryConsumer materialCategoryConsumer;

	// Auto wire UnitServiceConsumer here
	@Autowired
	private UnitServiceConsumer unitServiceConsumer;

	// Auto wire MaterialTypeConsumer here
	@Autowired
	private MaterialTypeConsumer materialTypeConsumer;
	

	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method sets PurchaseBean into the model attribute and redirects to
	 * PurchaseEntry.jsp.
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "purchaseEntry.html", method = RequestMethod.GET)
	public ModelAndView purchaseEntry() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("PurchaseEntry");
		mav.addObject("purchaseBean", new PurchaseBean());
		/*
		 * List<MaterialCategoryBean> list =
		 * materialCategoryConsumer.getMaterialCategoryBeanList();
		 * System.out.println("List:" + list); mav.addObject("message", "HIiii" + list);
		 */
		return mav;
	}

	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method returns the vendor list to be populated on the
	 * PurchasEntry.jsp. getVendorBeanList method of VendorServiceConsumer is
	 * called to get the vendor list.
	 * 
	 * @return vendorList - List of vendor values
	 * @throws MicroServiceException
	 */
	@ModelAttribute("vendorList")
	public List<VendorBean> generateVendorList() throws MicroServiceException {
		List<VendorBean> vendorList = vendorServiceConsumer.getVendorBeanList();
		return vendorList;
	}

	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method returns the material unit and type list to be populated in
	 * PurchaseEntry.jsp for chosen material category. hitGetUnitsByCategoryId
	 * method of UnitServiceConsumer class to be called to get the list of
	 * material unit. hitGetTypesBasedOnCategoryId method of
	 * MaterialTypeConsumer class to be called to get the list of material type.
	 * 
	 * @param purchaseBean
	 * @param HttpSession
	 * @return ModelAndView
	 * @throws MicroServiceException
	 */
	
	List<MaterialTypeBean> materialTypeList;
	List<UnitBean> unitList;
	@RequestMapping(value = "getUnitAndTypeList.html", method = RequestMethod.POST)
	public ModelAndView generateUnitAndTypeList(@ModelAttribute("purchaseBean") PurchaseBean purchaseBean,
			HttpSession session) throws MicroServiceException {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("PurchaseEntry");
		String categoryId = purchaseBean.getMaterialCategoryId();
		System.out.println(categoryId);
		
		materialTypeList = materialTypeConsumer.hitGetTypesBasedOnCategoryId(categoryId);
		System.out.println(materialTypeList);
		
		unitList = unitServiceConsumer.hitGetUnitsByCategoryId(categoryId);
		System.out.println(unitList);
		
		mav.addObject("materialTypeList", materialTypeList);
		mav.addObject("unitList", unitList);
		return mav;
	}

	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method returns the material category list to be populated on the
	 * PurchasEntry.jsp. getMaterialCategoryBeanList method of
	 * MaterialCategoryConsumer is called to get the material category list.
	 * 
	 * @return List - MaterialCategoryBean
	 * @throws MicroServiceException
	 */
	
	List<MaterialCategoryBean> materialCategorylist;
	@ModelAttribute("categoryList")
	public List<MaterialCategoryBean> generateCategoryList() throws MicroServiceException {
		materialCategorylist = materialCategoryConsumer.getMaterialCategoryBeanList();
		return materialCategorylist;
	}
	

	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method is used to insert purchase details filled on
	 * PurchaseEntry.jsp in to the purchase and payment table. Upon successful
	 * insert redirects to PurchaseSuccess.jsp
	 * 
	 * @param purchaseBean
	 * @param BindingResult
	 * @param ModelMap
	 * @param HttpSession
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "addPurchaseDetail.html", method = RequestMethod.POST)
	public ModelAndView addPurchaseDetail(@ModelAttribute("purchaseBean") @Valid PurchaseBean purchaseBean,
			BindingResult result, ModelMap map, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		String pageName = "";
		if(result.hasErrors()) {
			pageName = "PurchaseEntry";
		}
		else {
			System.out.println(purchaseBean.getBrandName());
			System.out.println(purchaseBean.getMaterialCategoryId());
			
			for(MaterialCategoryBean m : materialCategorylist) {
				System.out.println(m.getCategoryId());
				if(m.getCategoryId().equals(purchaseBean.getMaterialCategoryId()))
					purchaseBean.setMaterialCategoryName(m.getCategoryName());
			}
			
			for(MaterialTypeBean t : materialTypeList) {
				if(t.getTypeId().equals(purchaseBean.getMaterialTypeId()))
					purchaseBean.setMaterialTypeName(t.getTypeName());
			}
			
			for(UnitBean u : unitList) {
				if(u.getUnitId().equals(purchaseBean.getUnitId()))
					purchaseBean.setMaterialUnitName(u.getUnitName());
			}
			
			purchaseBean = purchaseService.addPurchaseDetails(purchaseBean);
			mav.addObject("message", purchaseBean.getVendorName());
			pageName = "PurchaseSuccess";
		}
		/*
		 * SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
		 * purchaseBean.setPurchaseDate(sdf.parse(sdf.format(purchaseBean.
		 * getPurchaseDate()))); System.out.println(purchaseBean.getPurchaseDate());
		 */
		mav.setViewName(pageName);
		return mav;
	}

}