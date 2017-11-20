package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.login.model.UserBean;
import com.login.social.providers.FacebookProvider;
import com.login.social.providers.GoogleProvider;
import com.login.social.providers.LinkedInProvider;

@Controller
public class LoginController {

	@Autowired 
	FacebookProvider facebookProvider;
	
	@Autowired 
	GoogleProvider googleProvider;

	@Autowired 
	LinkedInProvider linkedInProvider;

	@RequestMapping(value = "/facebook", method = RequestMethod.GET)
	public String loginToFacebook(Model model) {
		return facebookProvider.getFacebookUserData(model, new UserBean());
	}

	@RequestMapping(value = "/google", method = RequestMethod.GET)
	public String loginToGoogle(Model model) {
		return googleProvider.getGoogleUserData(model, new UserBean());
	}

	@RequestMapping(value = "/linkedin", method = RequestMethod.GET)
	public String helloFacebook(Model model) {
		return linkedInProvider.getLinkedInUserData(model, new UserBean());
	}
	
	@RequestMapping(value = { "/","/login" })
	public String login() {
		return "login";
	}

}
