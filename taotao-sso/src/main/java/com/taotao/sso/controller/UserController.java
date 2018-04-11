package com.taotao.sso.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.bean.TbUser;
import com.taotao.common.bean.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.sso.service.UserService;

/**
 * 用户Controller
 * <p>Title:UserController </p>
 * @author ChenYanZhang
 * @date 2018年4月11日
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/check/{param}/{type}")
	@ResponseBody
	public Object checkData(@PathVariable String param, @PathVariable Integer type, String callback){
		
		TaotaoResult result = null;
		
		//参数有效性校验
		if (StringUtils.isBlank(param)) {
			return TaotaoResult.build(400, "校验内容不能为空!");
		}
		if (type == null) {
			return TaotaoResult.build(400, "校验类型不能为空!");
		}
		if (type != 1 && type != 2 && type != 3) {
			return TaotaoResult.build(400, "校验内容类型错误!");
		}
		//校验出错
		if (null != result) {
			if (null != callback) {
				MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
				mappingJacksonValue.setJsonpFunction(callback);
				return mappingJacksonValue;
			} else {
				return result; 
			}
		}
		//调用服务
		try {
			result = userService.checkData(param, type);
			
		} catch (Exception e) {
			result = TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		if (null != callback) {
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
			mappingJacksonValue.setJsonpFunction(callback);
			return mappingJacksonValue;
		} else {
			return result; 
		}
	}
	
	//创建用户
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createUser(TbUser user) {
		
		try {
			TaotaoResult result = userService.createUser(user);
			return result;
		} catch (Exception e) {
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	//用户登录
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult userLogin(String username, String password) {
		try {
			TaotaoResult result = userService.userLogin(username, password);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	@RequestMapping("/token/{token}")
	@ResponseBody
	public Object getUserByToken(@PathVariable String token, String callback) {
		TaotaoResult result = null;
		try {
			result = userService.getUserByToken(token);
		} catch (Exception e) {
			e.printStackTrace();
			result = TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		//判断是否为jsonp调用
		if (StringUtils.isBlank(callback)) {
			return result;
		} else {
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
			mappingJacksonValue.setJsonpFunction(callback);
			return mappingJacksonValue;
		}
		
	}
}
