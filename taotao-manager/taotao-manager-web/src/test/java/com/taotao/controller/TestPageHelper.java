package com.taotao.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.bean.TbItem;
import com.taotao.bean.TbItemExample;
import com.taotao.mapper.TbItemMapper;

public class TestPageHelper {
	
	@Test
	public void testPageHelper() {
		//创建一个Spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从Spring容器中获得Mapper的代理对象
		TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
		//执行查询并分页
		TbItemExample example = new TbItemExample();
		//分页处理
		PageHelper.startPage(1, 10);
		List<TbItem> list = mapper.selectByExample(example);
		//取商品列表
		for (TbItem tbItem : list) {
			System.out.println(tbItem.getTitle());
		}
		//取分页信息
		PageInfo<TbItem> pageinfo = new PageInfo<>(list);
		long total = pageinfo.getTotal();
		System.out.println("共有商品：" + total);
	}

}
