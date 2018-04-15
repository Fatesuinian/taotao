package com.taotao.portal.service;

import com.taotao.bean.TbUser;

public interface UserService {

	TbUser getUserByToken(String token);
}
