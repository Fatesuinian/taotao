package com.taotao.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转Controller
 * <p>Title:PageController </p>
 * @author ChenYanZhang
 * @date 2018年4月12日
 */
@Controller
@RequestMapping("/user")
public class PageController {

	@RequestMapping("/showRegister")
	public String showRegister() {
		return "register";
	}
	
	@RequestMapping("/showLogin")
	public String showLogin(String redirect, Model model) {
		model.addAttribute("redirect", redirect);
		return "login";
	}
}
