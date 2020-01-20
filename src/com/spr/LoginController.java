package com.spr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginservice;
	
	
	public void setLoginservice(LoginService loginservice) {
		this.loginservice = loginservice;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView userLogin() {

		ModelAndView mv = new ModelAndView();
			mv.setViewName("login");
		
		return mv;

	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam("UserName") String UserName, @RequestParam("Password") String Password) {

		ModelAndView mv = new ModelAndView();

		Login log = new Login();
		log.setUserName(UserName);
		log.setPassword(Password);

		Login log1=loginservice.validateUser(log);
			System.out.print(log1.getRole());
		if (log1.getUserName() != null) {

			if(log1.getRole().equalsIgnoreCase("vehicleowner"))
			{
				mv.setViewName("VehicleOwnerHome");
			}
			else if(log1.getRole().equalsIgnoreCase("propertyowner"))
			{
				mv.setViewName("PropertOwnerHome");
			}
			else if(log1.getRole().equalsIgnoreCase("admin"))
			{
			mv.setViewName("AdminHome");
			}
			
			

		} else {

			mv.addObject("msg", "Invalid user id or password.");
			mv.setViewName("login");
		}

		return mv;

	}


}
