package com.taotao.sso.service;

import com.taotao.bean.TbUser;
import com.taotao.common.bean.TaotaoResult;

public interface UserService {

	TaotaoResult checkData(String content, Integer type);
	TaotaoResult createUser(TbUser user);
	TaotaoResult userLogin(String username, String password);
	
	TaotaoResult getUserByToken(String token);
}
