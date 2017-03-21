package com.linjia.web.service.impl;

import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Service;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.UserMapper;
import com.linjia.web.model.User;
import com.linjia.web.service.TestService;

@Service
public class TestServiceImpl extends BaseServiceImpl<User, Long> implements TestService {
	
//	@Resource
	private UserMapper mapper;
	
	@Override
	public BaseDao<User, Long> getDao() {
		return null;
	}

	@Override
	public void testPools() {
		for(int i=0;i<15;i++){
			new Worker().start();
		}
	}

	
	class Worker extends Thread{

		@Override
		public void run() {
			mapper.selectAll();
			System.out.println(Thread.currentThread().getName() + ":得到连接 ：时间："+ System.currentTimeMillis());
		}
		
	}


	/*
	 *  测试事务
	 */
	@Override
	public boolean updateAge() {
		User user1 = mapper.selectByPrimaryKey(3L);
		int changeAge = 3;
		int age1 = user1.getAge();
		user1.setAge(age1 - changeAge);
		mapper.updateByPrimaryKeySelective(user1);
		
		System.out.println("isAopProxy:" +AopUtils.isAopProxy(this)
							+"isCglibProxy:" +AopUtils.isCglibProxy(this) //cglib
						    +"isJdkDynamicProxy:" +AopUtils.isJdkDynamicProxy(this));
		
		User user2 = mapper.selectByPrimaryKey(4L);
		int age2 = user2.getAge();
		user2.setAge(age2 + changeAge);
		if(changeAge >2 ){
			throw new RuntimeException("Not enough money");
		}
		return mapper.updateByPrimaryKeySelective(user2);
		
	}

	/*@Override
	public boolean testTransaction() {
		try{
		ShoppingCar shoppingCar = new ShoppingCar();
		shoppingCar.setProductId(100003l);
		shoppingCar.setpCode("6939728988236");
		shoppingCar.setUserId("lxl");
		shoppingCar.setQuantity(5);
		shoppingCar.setCreDate(new Date());
		shoppingCarMapper.insertSelective(shoppingCar);
		logger.info("购物车数据插入成功，新增id是：" + shoppingCar.getId());
		
		orderGroupProductMapper.deleteByPrimaryKey(1L);
		logger.info("确认订单数据删除成功");
		}catch (Exception e){
			logger.error("测试数据出错，进行回滚操作",e);
			throw e;
		}
		return false;
	}
	
	@Override
	public int testInsertBatch() {
		try{
			List<ShoppingCar> list = new ArrayList<ShoppingCar>();
		ShoppingCar shoppingCar = new ShoppingCar();
		shoppingCar.setProductId(100003l);
		shoppingCar.setpCode("6939728988236");
		shoppingCar.setUserId("lxl");
		shoppingCar.setQuantity(5);
		shoppingCar.setCreDate(new Date());
		
		ShoppingCar shoppingCar1 = new ShoppingCar();
		shoppingCar1.setProductId(100004l);
		shoppingCar1.setpCode("6939728988237");
		shoppingCar1.setUserId("lxl");
		shoppingCar1.setQuantity(5);
		shoppingCar1.setCreDate(new Date());
		
		list.add(shoppingCar);
		list.add(shoppingCar1);
		Map map = new HashMap();
		map.put("list", list);
		map.put("groupId", 2012566522);
		orderGroupProductMapper.insertBatchProductList(map);
//		shoppingCarMapper.insertSelective(shoppingCar);
		logger.info("购物车数据插入成功，新增id是：" + shoppingCar.getId());
		
//		orderGroupProductMapper.deleteByPrimaryKey(1L);
		logger.info("确认订单数据删除成功");
		}catch (Exception e){
			logger.error("测试数据出错，进行回滚操作",e);
			throw e;
		}
		return 0;
	}*/
	
	
}
