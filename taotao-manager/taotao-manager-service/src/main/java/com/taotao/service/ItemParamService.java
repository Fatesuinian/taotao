package com.taotao.service;

import com.taotao.bean.TbItemParam;
import com.taotao.common.bean.EasyUIDataGridResult;
import com.taotao.common.bean.TaotaoResult;

public interface ItemParamService {

	TaotaoResult getItemParamByCid(long cid);
	TaotaoResult insertItemParam(TbItemParam itemParam);
	EasyUIDataGridResult getItemParamList(int page, int rows);
}
