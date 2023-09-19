package com.accenture.lkm.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.UserBean;
import com.accenture.lkm.services.PurchaseService;

/**
 * <br/>
 *	CLASS DESCRIPTION:  <br/>
 *	A controller class for redirecting to the Welcome.jsp screen when user click Home in the menu bar.<br/>
 *
 */
@Controller
public class HomeController {

	private static Logger LOGGER =  Logger.getLogger(HomeController.class);
	
	@Autowired
	private PurchaseService purchaseService;
	
	/**
	 * <br/>
	 * METHOD DESCRIPTION:<br/>
	 * This method redirect to Welcome.jsp when a user click on Home in the menu bar.
	 * @return 
	 */
	@RequestMapping(value = "welcome.html", method = RequestMethod.GET)
	public ModelAndView showHomePage() {
		LOGGER.info("Execution Started [login()]");			
		ModelAndView modelAndView = new ModelAndView("Welcome");
		LOGGER.info("Execution over [login()]");	
		return modelAndView;
	}
	
	@RequestMapping(value = "login.html", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Login");
		mav.addObject("userBean", new UserBean());
		return mav;
	}
	
	@RequestMapping(value = "validateLogin.html", method = RequestMethod.POST)
	public ModelAndView validateLogin(@ModelAttribute("userBean") UserBean userBean) throws Exception {
		ModelAndView mav = new ModelAndView();
		boolean valid = purchaseService.validateLogin(userBean.getUserName(), userBean.getPassword());
		if(valid) {
			mav.setViewName("Welcome");
		}
		else {
			mav.setViewName("Login");
		}
		return mav;
	}
	
}
