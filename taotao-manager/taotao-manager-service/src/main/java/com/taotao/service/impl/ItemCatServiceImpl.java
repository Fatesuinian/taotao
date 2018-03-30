package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.bean.TbItemCat;
import com.taotao.bean.TbItemCatExample;
import com.taotao.bean.TbItemCatExample.Criteria;
import com.taotao.common.bean.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.service.ItemCatService;

/**
 * 商品分类管理Service
 * <p>Title:ItemCatServiceImpl </p>
 * @author ChenYanZhang
 * @date 2018年3月29日
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<EasyUITreeNode> getItemCatList(long parentId) {
		// 根据parentId查询分类列表
		TbItemCatExample example = new TbItemCatExample();
		// 设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		// 执行查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		// 分类列表转换成EasyUITreeNode的列表
		List<EasyUITreeNode> resultList = new ArrayList<>();
		for (TbItemCat tbItemCat : list) {
			// 创建一个EasyUITreeNode对象
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			//添加到列表中
			resultList.add(node);
		}
		return resultList;
	}

}
