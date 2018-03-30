package com.taotao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.JsonUtil;
import com.taotao.service.PictureService;

/**
 * 上传图片处理
 * <p>Title:PictureController </p>
 * @author ChenYanZhang
 * @date 2018年3月30日
 */
public class PictureController {

	@Autowired
	private PictureService pictureService;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile) {
		Map result = pictureService.uploadPicture(uploadFile);
		//为了保证功能的兼容性,需要把result转换成json格式的字符串
		String json = JsonUtil.objectToJson(result);
		return json;
	}
}
