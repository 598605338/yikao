package com.linjia.web.service;


import java.math.BigDecimal;
import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.MallMaster;
import com.linjia.web.model.ReMallProduct;
import com.linjia.web.query.MallMasterQuery;
import com.linjia.web.query.ReMallProductQuery;

public interface MallMasterService extends BaseService<MallMaster, Long>{
	
	/**
	 * 根据门店code查询门店信息
	 * lixinling
	 * 2016年7月21日 下午5:54:30
	 * @param mallCode
	 * @return
	 */
	MallMaster selectByMallCode(String mallCode);
	
	/**
	 * 根据门店code查询该门店的配送费
	 * lixinling
	 * 2016年7月21日 下午5:54:30
	 * @param mallCode
	 * @return
	 */
	BigDecimal selectSendPriceByMallCode(String mallCode);
	
	/**
	 * 根据区域条件取得门店列表 
	 * lixinling
	 * 2016年7月21日 下午5:54:30
	 * @param mallCode
	 * @return
	 */
	List<MallMaster> selectSendPriceByRegion(MallMasterQuery query);
	
	/**
	 * 根据区域条件取得门店数量
	 * xiangsy
	 * 2016年7月21日 下午5:54:30
	 * @param mallCode
	 * @return
	 */
	Integer selectSendPriceByRegionNum(MallMasterQuery query);
	
	/**
	 * 插入门店信息
	 * @param mallMaster
	 * @return
	 */
	boolean insertMallMaster(MallMaster mallMaster);

	/**
	 * 查询店铺商品列表
	 * lixinling
	 * 2016年7月21日 下午5:54:30
	 * @param mallCode
	 * @return
	 */
	List<ReMallProduct> selectMallProduct(ReMallProductQuery query);
	
	/**
	 * 查询门店总数量
	 * @return
	 */
	Integer selectMallNum();
	
	/**
	 * 查询商品总数量
	 * @return
	 */
	Integer selectProductNum(ReMallProductQuery query);
	
	/**
	 * 查询所有门店code
	 * @return
	 */
	List<String> selectMallCodes();
	
	/**
	 * 更新门店信息
	 * @param mallMaster
	 * @return
	 */
	boolean updateMallById(MallMaster mallMaster);
	
	/**
	 * 根据门店code更新门店信息
	 * @param mallMaster
	 * @return
	 */
	boolean updateMallByCode(MallMaster mallMaster);
	
	/**
	 * 根据门店code删除门店
	 */
	boolean deleteMall(String mallCode);
	
}
