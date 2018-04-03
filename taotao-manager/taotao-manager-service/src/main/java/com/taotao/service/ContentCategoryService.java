package com.taotao.service;

import java.util.List;

import com.taotao.common.bean.EasyUITreeNode;
import com.taotao.common.bean.TaotaoResult;

/**
 * 内容分类服务
 * <p>Title:ContentCategoryService </p>
 * @author ChenYanZhang
 * @date 2018年4月3日
 */
public interface ContentCategoryService {

	List<EasyUITreeNode> getCategoryList(long parentId);
	TaotaoResult insertContentCategory(long parentId, String name);
}
