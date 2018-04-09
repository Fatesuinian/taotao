package com.taotao.portal.service;

import com.taotao.portal.bean.SearchResult;

public interface SearchService {

	SearchResult search(String queryString, int page);
}
