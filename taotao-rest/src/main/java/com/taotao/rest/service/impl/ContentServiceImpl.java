package com.taotao.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.bean.TbContent;
import com.taotao.bean.TbContentExample;
import com.taotao.bean.TbContentExample.Criteria;
import com.taotao.mapper.TbContentMapper;
import com.taotao.rest.service.ContentService;

/**
 * 内容管理
 * <p>Title:ContentServiceImpl </p>
 * @author ChenYanZhang
 * @date 2018年4月3日
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	
	@Override
	public List<TbContent> getContentList(long contentCid) {
		//根据内容分类id查询内容列表
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(contentCid);
		//执行查询
		List<TbContent> list = contentMapper.selectByExample(example);
		return list;
	}

}
