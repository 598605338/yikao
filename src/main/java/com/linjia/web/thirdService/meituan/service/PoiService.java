package com.linjia.web.thirdService.meituan.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.linjia.web.thirdService.meituan.constants.PoiQualificationEnum;
import com.linjia.web.thirdService.meituan.vo.PoiParam;
import com.linjia.web.thirdService.meituan.vo.PoiTagParam;

public interface PoiService {

	/**
     * 保存门店
     * @param poiParam 应用级参数
     * @return
     */
    public JSONObject poiSave(PoiParam poiParam);

    /**
     * 获取所有门店codes
     * @return
     */
    public JSONObject poiGetIds();

    /**
     * 获取门店详细信息
     * @param systemParam 系统参数
     * @param appPoiCodes 门店codes（可以多个，逗号分隔）
     * @return
     */
    public List<PoiParam> poiMget(String appPoiCodes);

    /**
     * 将门店设置为营业状态
     * @param appPoiCode 门店code
     * @return
     */
    public JSONObject poiOpen(String appPoiCode);

    /**
     * 将门店设置为休息状态
     * @param appPoiCode 门店code
     * @return
     */
    public JSONObject poiClose(String appPoiCode);

    /**
     * 将门店设置为上线状态
     * @param appPoiCode 门店code
     * @return
     */
    public JSONObject poiOnline(String appPoiCode);

    /**
     * 将门店设置为下线状态
     * @param appPoiCode 门店code
     * @param reason 原因
     * @return
     */
    public JSONObject poiOffline(String appPoiCode, String reason);

    /**
     * 门店资质证书上传
     * @param appPoiCode 门店code
     * @param poiQualificationEnum 资质证照的类型（
     *                             BUSINESS_LICENSE：营业执照；
     *                             CATERING_SERVICE_LICENSE：餐饮服务许可证；
     *                             HEALTH_CERTIFICATE：健康证；
     *                             CORPORATE_IDENTITY：法人身份证）
     * @param qualificationUrl 资质图片ID
     * @param validDate 资质证照的有效期截止日, 必须符合yyyy-MM-dd的格式，type为1，2，3时需要传此字段，type为4时不需要
     * @param address 经营地址，type为1，2时需要传此字段，type为3，4时不需要
     * @param number 证照编号，type为1，2，3，4时都需要传此字段
     * @return
     */
    public JSONObject poiQualifySave(String appPoiCode, PoiQualificationEnum poiQualificationEnum,
                                 String qualificationUrl, String validDate, String address, String number);

    /**
     * 同步门店预计送达时长
     * @param appPoiCodes 门店code
     * @param sendTime 预计送达时长（单位分钟，如50表示50分钟送达）
     * @return
     */
    public JSONObject poiSendTimeSave(String appPoiCodes, int sendTime);

    /**
     * 更改门店附加信息
     * @param appPoiCode 门店code
     * @param appPoiEmail 门店email
     * @param appBrandCode 第三方品牌code值（对接的三方需要提前将该值告诉美团开发人员）
     * @param appOrgId 门店的法人企业（门店的财务结算等均由与之关联的结算企业信息决定，对接的三方需要提前将该值告诉美团对接商务）
     * @return
     */
    public JSONObject poiAdditionalSave(String appPoiCode, String appPoiEmail,
                                           String appBrandCode, String appOrgId);

    /**
     * 更改门店公告信息
     * @param appPoiCode 门店code
     * @param promotionInfo 门店公告栏信息
     * @return
     */
    public JSONObject poiUpdatePromotionInfo(String appPoiCode, String promotionInfo);

    /**
     * 获取门店品类列表
     * @return
     */
    public List<PoiTagParam> poiTagList();

}
