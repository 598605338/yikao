package com.linjia.web.dao;

import java.util.List;
import java.util.Map;
import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.MallProductStore;
import com.linjia.web.model.ReMallProduct;

public interface MallProductStoreMapper extends BaseDao<MallProductStore, Long> {
	
	/**
	 * 根据门店编码和商品编码查询安全库存
	 * lixinling 
	 * 2016年8月17日 下午3:46:33
	 * @param mallCode
	 * @param pCode
	 * @return
	 */
	Object selectSafeQtyByMallAndPCode(Map<String,Object> map);
	
	/**
	 * 插入门店商品数据
	 * xiangshouyi 
	 * 2016年8月31日 下午3:46:33
	 * @param mallCode
	 * @param pCode
	 * @return
	 */
	Integer insertMallProduct(ReMallProduct mallProduct);
	
	/**
	 * 插入门店商品数据
	 * xiangshouyi 
	 * 2016年8月31日 下午3:46:33
	 * @param mallCode
	 * @param pCode
	 * @return
	 */
	Integer updateMallProduct(ReMallProduct mallProduct);
	
	/**
	 * 删除门店商品数据
	 * xiangshouyi 
	 * 2016年8月31日 下午3:46:33
	 * @param mallCode
	 * @param pCode
	 * @return
	 */
	Integer deleteMallProduct(ReMallProduct mallProduct);
	
	/**
	 * 批量导入商品信息
	 * xiangsy 
	 * 2016年9月20日 上午10:27:30
	 * @param list
	 * @return
	 */
	int insertLeadInPro(List<MallProductStore> list);
	
	/**
	 * 批量设置门店商品信息
	 * xiangsy 
	 * 2016年9月20日 上午10:27:30
	 * @param list
	 * @return
	 */
	int updateBatchProducts(List<MallProductStore> list);
}