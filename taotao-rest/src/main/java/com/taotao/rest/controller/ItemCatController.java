package com.taotao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.JsonUtil;
import com.taotao.rest.bean.CatResult;
import com.taotao.rest.service.ItemCatService;

/**
 * 商品分类列表Controller
 * <p>Title:ItemCatController </p>
 * @author ChenYanZhang
 * @date 2018年4月2日
 */
@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;

	//方法一
	/*@RequestMapping(value="itemcat/list", produces=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	@ResponseBody
	public String getItemCatList(String callback) {
		
		CatResult catResult = itemCatService.getItemCatList();
		//把catResult转换成字符串
		String json = JsonUtil.objectToJson(catResult);
		//拼装返回值
		String result = callback + "(" + json + ");";
		
		return result;
	}*/
	
	//方法二：要求Spring版本4.1以上
	@RequestMapping("/itemcat/list")
	@ResponseBody
	public Object getItemCatList(String callback) {
		CatResult catResult = itemCatService.getItemCatList();
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(catResult);
		mappingJacksonValue.setJsonpFunction(callback);
		return mappingJacksonValue;
	}
	
}
