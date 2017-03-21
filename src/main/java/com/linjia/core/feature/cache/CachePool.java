package com.linjia.core.feature.cache;

import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * CachePool(单例Cache池)
 * 
 * @author lixinling:
 * @date 2016年6月30日 下午4:00:38
 * @version 1.0
 */
public class CachePool {

	// Redis服务器IP
	private static String ADDR_external = ".170.170.29";

	private static String ADDR_internal = "1.92.212.15";

	// Redis测试环境182.92.105.124
	private static String TEST_redisPath = "192.168.0.33";

	// Redis的端口号
	private static int PORT = 6379;

	// 访问密码
	private static String AUTH = null;

	// 可用连接实例的最大数目，默认值为8；
	// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
	private static int MAX_TOTAL = 1024;

	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	private static int MAX_IDLE = 200;

	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	private static int MAX_WAIT = 10000;

	private static int TIMEOUT = 10000;

	// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	private static boolean TEST_ON_BORROW = true;

	private static JedisPool jedisPool = null;

	private static final CachePool cachePool = new CachePool();

	private CachePool() {
		JedisPoolConfig config = new JedisPoolConfig();
//		Properties p1 = new Properties();
		// 最大空闲连接数, 默认8个
		config.setMaxIdle(MAX_IDLE);
		
		// 如果赋值为-1，则表示不限制；如果pool已经分配了maxTotal个jedis实例，则此时pool的状态为exhausted(耗尽)
		config.setMaxTotal(MAX_TOTAL);
		
		// 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,
		// 默认-1
		config.setMaxWaitMillis(MAX_WAIT);

		jedisPool = new JedisPool(config, TEST_redisPath, PORT, TIMEOUT, AUTH);
	}

	public static CachePool getInstance() {
		return cachePool;
	}
	
	public Jedis getJedis() {  
		Jedis jedis = null;  
        boolean borrowOrOprSuccess = true;  
        try {  
            jedis = jedisPool.getResource();  
        } catch (JedisConnectionException e) {  
            borrowOrOprSuccess = false;  
            if (jedis != null)  
            	jedisPool.returnBrokenResource(jedis);  
        }  
        finally {  
            if (borrowOrOprSuccess)  
            	jedisPool.returnResource(jedis);  
        }  
        jedis = jedisPool.getResource();  
        return jedis;  
    }  


    public JedisPool getJedisPool() {  
        return jedisPool;  
    }  

} 

