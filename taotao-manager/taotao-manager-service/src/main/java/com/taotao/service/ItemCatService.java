package com.taotao.service;

import java.util.List;

import com.taotao.common.bean.EasyUITreeNode;

public interface ItemCatService {

	List<EasyUITreeNode> getItemCatList(long parentId);
}
