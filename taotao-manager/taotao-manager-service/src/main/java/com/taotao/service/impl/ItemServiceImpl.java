package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.bean.TbItem;
import com.taotao.bean.TbItemExample;
import com.taotao.bean.TbItemExample.Criteria;
import com.taotao.common.bean.EasyUIDataGridResult;
import com.taotao.common.bean.TaotaoResult;
import com.taotao.common.utils.IDUtil;
import com.taotao.mapper.TbItemMapper;
import com.taotao.service.ItemService;

/**
 * 商品管理Service
 * <p>Title:ItemServiceImpl </p>
 * @author ChenYanZhang
 * @date 2018年3月28日
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
		
		// 1.直接使用生成的条件查询
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		// 2.使用生成example查询
//		TbItemExample example = new TbItemExample();
		//添加查询条件
//		Criteria criteria = example.createCriteria();
//		criteria.andIdEqualTo(itemId);
//		List<TbItem> list = itemMapper.selectByExample(example);
//		if (list !=null && list.size() > 0) {
//			TbItem item = list.get(0);
			return item;
//		}
//		return null;
	}

	/**
	 * 商品列表查询
	 */
	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		//查询商品列表
		TbItemExample example = new TbItemExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		//创建一个返回值对象
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public TaotaoResult createItem(TbItem item) {
		//item补全
		//生成商品ID
		Long itemId = IDUtil.genItemId();
		item.setId(itemId);
		//商品状态, 1-正常, 2-下架, 3-删除
		item.setStatus((byte) 1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		//插入到数据库
		itemMapper.insert(item);
		return TaotaoResult.ok();
	}

}
