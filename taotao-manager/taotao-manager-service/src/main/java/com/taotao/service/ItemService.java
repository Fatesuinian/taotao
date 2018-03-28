package com.taotao.service;

import com.taotao.bean.TbItem;
import com.taotao.common.bean.EasyUIDataGridResult;

public interface ItemService {

	TbItem getItemById(long itemId);
	EasyUIDataGridResult getItemList(int page, int rows);
}
