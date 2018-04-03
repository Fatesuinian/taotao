package com.taotao.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.bean.TbContent;
import com.taotao.common.bean.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.service.ContentService;

/**
 * 内容管理
 * <p>
 * Title:ContentServiceImpl
 * </p>
 * 
 * @author ChenYanZhang
 * @date 2018年4月3日
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	/*@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_CONTENT_SYNC_URL}")
	private String REST_CONTENT_SYNC_URL;*/

	@Override
	public TaotaoResult insertContent(TbContent content) {
		// 补全bean内容
		
		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);

		/*// 添加缓存同步逻辑
		try {
			HttpClientUtil.doGet(REST_BASE_URL + REST_CONTENT_SYNC_URL + content.getCategoryId());
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		return TaotaoResult.ok();
	}

}
