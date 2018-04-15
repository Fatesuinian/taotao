package com.taotao.order.service;

import java.util.List;

import com.taotao.bean.TbOrder;
import com.taotao.bean.TbOrderItem;
import com.taotao.bean.TbOrderShipping;
import com.taotao.common.bean.TaotaoResult;

public interface OrderService {

	TaotaoResult createOrder(TbOrder order, List<TbOrderItem> itemList, TbOrderShipping orderShipping);
}
