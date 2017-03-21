package com.linjia.tools;

import com.linjia.core.feature.cache.CachePool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * Redis常用工具类(里面没有的方法可以自行编辑添加)
 * 
 * @author lixinling:
 * @date 2016年7月1日 下午1:05:34
 * @version 1.0
 */
public class RedisUtil {

	private static JedisPool jedisPool = CachePool.getInstance().getJedisPool();

	/**
	 * 根据key取得redis中存储的值
	 * 
	 * lixinling 2016年7月1日 下午1:37:51
	 * 
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		Jedis jedis = null;
		String value = null;
		try {
			jedis = CachePool.getInstance().getJedis();
			value = jedis.get(key);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			jedisPool.returnResource(jedis);
		}
		return value;

	}

	/**
	 * 根据传入的key和value的值，在redis中进行存储
	 * 
	 * lixinling 2016年7月1日 下午2:04:21
	 * 
	 * @param key
	 * @param value
	 */
	public static void put(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = CachePool.getInstance().getJedis();
			jedis.set(key, value);
		} catch (JedisConnectionException e) {
			if (jedis != null)
				jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			jedisPool.returnResource(jedis);
		}
	}

	/**
	 * 根据传入的key和value的值，在redis中进行存储 并设置超时时间
	 * 
	 * lixinling 2016年7月1日 下午2:06:17
	 * 
	 * @param key
	 * @param value
	 * @param seconds
	 *            超时时间
	 */
	public static void put(String key, String value, int seconds) {
		Jedis jedis = null;
		try {
			jedis = CachePool.getInstance().getJedis();
			jedis.set(key, value);
			jedis.expire(key, seconds);
		} catch (JedisConnectionException e) {
			if (jedis != null)
				jedisPool.returnBrokenResource(jedis);
		} finally {
			jedisPool.returnResource(jedis);
		}
	}

	/**
	 * 根据key来删除redis中的值
	 * 
	 * lixinling 2016年7月1日 下午2:08:18
	 * 
	 * @param key
	 * @return
	 */
	public static Object remove(String key) {
		Jedis jedis = null;
		Object value = null;
		try {
			jedis = CachePool.getInstance().getJedis();
			value = jedis.del(key);
		} catch (JedisConnectionException e) {
			if (jedis != null)
				jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			jedisPool.returnResource(jedis);
		}
		return value;
	}

	/**
	 * 根据传入的key和field,获取在哈希表中指定字段的值
	 * 
	 * lixinling 2016年7月1日 下午2:06:17
	 * 
	 * @param key
	 * @param value
	 * @param seconds
	 *            超时时间
	 */
	public static String hget(String key, String field) {
		Jedis jedis = null;
		String result = null;
		try {
			jedis = CachePool.getInstance().getJedis();
			result = jedis.hget(key, field);
		} catch (JedisConnectionException e) {
			if (jedis != null)
				jedisPool.returnBrokenResource(jedis);
		} finally {
			jedisPool.returnResource(jedis);
		}
		return result;
	}
	
	/**
	 * 根据传入的key，在redis中对值进行原子自增操作
	 * 
	 * lixinling 2017年3月17日 下午2:06:17
	 * 
	 * @param key
	 */
	public static void incr(String key) {
		Jedis jedis = null;
		try {
			jedis = CachePool.getInstance().getJedis();
			jedis.incr(key);
		} catch (JedisConnectionException e) {
			if (jedis != null)
				jedisPool.returnBrokenResource(jedis);
		} finally {
			jedisPool.returnResource(jedis);
		}
	}
}
