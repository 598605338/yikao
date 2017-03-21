package com.linjia.core.feature.cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

/** 
  * 使用第三方缓存服务器redis，处理Mybatis二级缓存
  * @author  lixinling: 
  * @date 创建时间：2016年6月30日 下午3:12:52 
  * @version 1.0 
  */
public class RedisCache implements Cache {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	private String id;
	
	public RedisCache(final String id){
		if(id == null)
			throw new IllegalArgumentException("必须传入id");
		
		log.debug("MybatisRedisCache:id=" + id);  
        this.id = id;
	}


	@Override
	public void clear() {
		Jedis jedis = null;  
        JedisPool jedisPool = null;  
        boolean borrowOrOprSuccess = true;  
        try {  
            jedis = CachePool.getInstance().getJedis();  
            jedisPool = CachePool.getInstance().getJedisPool();  
            jedis.flushDB();  
            jedis.flushAll();  
        } catch (JedisConnectionException e) {  
            borrowOrOprSuccess = false;  
            if (jedis != null)  
                jedisPool.returnBrokenResource(jedis);  
        }  
        finally {  
            if (borrowOrOprSuccess)  
                jedisPool.returnResource(jedis);  
        }  
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public Object getObject(Object key) {
		Jedis jedis = null;  
        JedisPool jedisPool = null;  
        Object value = null;  
        boolean borrowOrOprSuccess = true;  
        try {  
            jedis = CachePool.getInstance().getJedis();  
            jedisPool = CachePool.getInstance().getJedisPool();  
            value = SerializeUtil.unserialize(jedis.get(SerializeUtil.serialize(key.hashCode())));  
        } catch (JedisConnectionException e) {  
            borrowOrOprSuccess = false;  
            if (jedis != null)  
                jedisPool.returnBrokenResource(jedis);  
        }  
        finally {  
            if (borrowOrOprSuccess)  
                jedisPool.returnResource(jedis);  
        }  
        if (log.isDebugEnabled())  
            log.debug("getObject:" + key.hashCode() + "=" + value);  
        return value; 
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

	@Override
	public int getSize() {
		Jedis jedis = null;
		JedisPool jedisPool = null;
		int result = 0;
		boolean borrowOrOprSuccess = true;
		
		try {  
            jedis = CachePool.getInstance().getJedis();  
            jedisPool = CachePool.getInstance().getJedisPool();  
            result = Integer.valueOf(jedis.dbSize().toString());  
        } catch (JedisConnectionException e) {  
            borrowOrOprSuccess = false;  
            if (jedis != null)  
                jedisPool.returnBrokenResource(jedis);  
        }  
        finally {  
            if (borrowOrOprSuccess)  
                jedisPool.returnResource(jedis);  
        }  
		return result;
	}

	@Override
	public void putObject(Object key, Object value) {
		if (log.isDebugEnabled())  
            log.debug("putObject:" + key.hashCode() + "=" + value);  
        if (log.isInfoEnabled())  
            log.info("put to redis sql :" + key.toString());  
        Jedis jedis = null;  
        JedisPool jedisPool = null;  
        boolean borrowOrOprSuccess = true;  
        try {  
            jedis = CachePool.getInstance().getJedis();  
            jedisPool = CachePool.getInstance().getJedisPool();  
            jedis.set(SerializeUtil.serialize(key.hashCode()), SerializeUtil.serialize(value));  
        } catch (JedisConnectionException e) {  
            borrowOrOprSuccess = false;  
            if (jedis != null)  
                jedisPool.returnBrokenResource(jedis);  
        }  
        finally {  
            if (borrowOrOprSuccess)  
                jedisPool.returnResource(jedis);  
        }  
	}

	@Override
	public Object removeObject(Object key) {
		Jedis jedis = null;  
        JedisPool jedisPool = null;  
        Object value = null;  
        boolean borrowOrOprSuccess = true;  
        try {  
            jedis = CachePool.getInstance().getJedis();  
            jedisPool = CachePool.getInstance().getJedisPool();  
            value = jedis.expire(SerializeUtil.serialize(key.hashCode()), 0);  
        } catch (JedisConnectionException e) {  
            borrowOrOprSuccess = false;  
            if (jedis != null)  
                jedisPool.returnBrokenResource(jedis);  
        }  
        finally {  
            if (borrowOrOprSuccess)  
                jedisPool.returnResource(jedis);  
        }  
        if (log.isDebugEnabled())  
            log.debug("getObject:" + key.hashCode() + "=" + value);  
        return value;
	}
}
