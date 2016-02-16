package com.zlp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeLeafController {

	@RequestMapping("/doit")
	public String doit(Model model, HttpServletRequest request) {
		System.out.println("hello world!");
		model.addAttribute("welcome", "张三");
//		request.setAttribute("welcome", "李四");
		return "one";
	}
	
	@RequestMapping("/to/login")
	public String toLogin(Model model, HttpServletRequest request) {
		System.out.println("login!");
//		model.addAttribute("welcome", "张三");
//		request.setAttribute("welcome", "李四");
		model.addAttribute("url", "dynamic");
		return "login";
	}
}
