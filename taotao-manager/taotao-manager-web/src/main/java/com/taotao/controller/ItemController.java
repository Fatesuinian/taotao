package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.bean.TbItem;
import com.taotao.common.bean.EasyUIDataGridResult;
import com.taotao.service.ItemService;

/**
 * 商品管理Controller
 * <p>Title:ItemController </p>
 * @author ChenYanZhang
 * @date 2018年3月28日
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService intemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody //返回json数据需要注解ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = intemService.getItemById(itemId);
		return tbItem;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		EasyUIDataGridResult result = intemService.getItemList(page, rows);
		return result;
	}
	
}
