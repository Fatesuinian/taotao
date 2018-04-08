package com.taotao.rest.dao;

public interface JedisClient {

	String get(String key);
	String set(String key, String value);
	String hget(String hkey, String key);
	Long hset(String hkey, String key, String value);
	//自增
	long incr(String key);
	//有效期
	long expire(String key, int second);
	//剩余有效期
	long ttl(String key);
	long del(String key);
	long hdel(String hkey, String key);
}
