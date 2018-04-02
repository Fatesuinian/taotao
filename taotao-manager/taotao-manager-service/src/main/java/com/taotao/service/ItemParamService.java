package com.taotao.service;

import com.taotao.bean.TbItemParam;
import com.taotao.common.bean.EasyUIDataGridResult;
import com.taotao.common.bean.TaotaoResult;

public interface ItemParamService {

	TaotaoResult getItemParamByCid(long cid);
	TaotaoResult insertItemParam(TbItemParam itemParam);
	//查询规格参数暂未实现
	//EasyUIDataGridResult getItemParamList(int page, int rows);
}
