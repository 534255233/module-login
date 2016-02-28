package com.zlp.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zlp.annotation.Login;
import com.zlp.annotation.LoginValidate;
import com.zlp.entity.User;
import com.zlp.entity.vo.ResultMessageVO;
import com.zlp.exception.PasswdErrorException;
import com.zlp.exception.UserNotFoundException;
import com.zlp.log.LoggerFactory;
import com.zlp.util.CurrentThreadUtil;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	
	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	
	@RequestMapping("/html")
	public String toLoginPage(Model model) {
		log.info("--> to login html page.");
//		model.addAttribute("welcome", "张三");
//		request.setAttribute("welcome", "李四");
//		model.addAttribute("url", "dynamic");
		return "login";
	}
	
	
	@RequestMapping(value = "/{account}/{passwd}", method = RequestMethod.POST)
	@ResponseBody
	@Login
	public ResultMessageVO login(@PathVariable String account,
						@PathVariable String passwd)  throws UserNotFoundException, PasswdErrorException {
//		User user = loginService.login(account, passwd);
		User user  = new User();
		user.setAccount(account);
		user.setPassword(passwd);
		
		CurrentThreadUtil.setSubject(user);
		
//		if(user == null) return "{\"result\":\"error\", \"msg\":\"登录失败，账户或者密码不正确！\"}";
//		String result = "{\"result\":\"success\", \"msg\":\"登录成功。\", \"balance\":"+user.getBalance()+", \"status\": "+user.getAccountStatus()+"}";
//		request.getSession().setAttribute(Constant.SESSIONUSER, user);
		ResultMessageVO vo = new ResultMessageVO(ResultMessageVO.CodeEnum.SUCCESS.getValue(), 
												 ResultMessageVO.CodeEnum.SUCCESS.getDes(), "");
		
		return vo;
	}
	
	@RequestMapping(value = "/test")
	@ResponseBody
	@LoginValidate
	public ResultMessageVO test() {
		
//		if(user == null) return "{\"result\":\"error\", \"msg\":\"登录失败，账户或者密码不正确！\"}";
//		String result = "{\"result\":\"success\", \"msg\":\"登录成功。\", \"balance\":"+user.getBalance()+", \"status\": "+user.getAccountStatus()+"}";
//		request.getSession().setAttribute(Constant.SESSIONUSER, user);
		ResultMessageVO vo = new ResultMessageVO(ResultMessageVO.CodeEnum.SUCCESS.getValue(), 
												 ResultMessageVO.CodeEnum.SUCCESS.getDes(), "");
		
		return vo;
	}
	
	

}
