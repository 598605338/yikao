package com.linjia.core.feature.cache;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.decorators.LoggingCache;


/** 
 * @author  lixinling: 
 * @date 2016年6月30日 下午5:43:38 
 * @version 1.0 
 */
public class MybatisRedisCache extends LoggingCache {

	public MybatisRedisCache(String id) {
		super(new RedisCache(id));
	}

}
