package com.linjia.web.thirdService.meituan.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.linjia.web.thirdService.meituan.constants.ErrorEnum;
import com.linjia.web.thirdService.meituan.constants.ParamRequiredEnum;
import com.linjia.web.thirdService.meituan.constants.PoiQualificationEnum;
import com.linjia.web.thirdService.meituan.exception.ApiOpException;
import com.linjia.web.thirdService.meituan.exception.ApiSysException;
import com.linjia.web.thirdService.meituan.utils.ConvertUtil;
import com.linjia.web.thirdService.meituan.vo.PoiParam;
import com.linjia.web.thirdService.meituan.vo.PoiTagParam;
import com.linjia.web.thirdService.meituan.vo.SystemParam;

/**
 * Created by yangzhiqi on 15/10/15.
 * 门店接口
 */
public class PoiAPI extends API{

    /**
     * 保存门店
     * @param systemParam 系统参数
     * @param poiParam 应用级参数
     * @return
     */
    public String poiSave(SystemParam systemParam , PoiParam poiParam) throws ApiOpException,
                                                                                    ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.PoiSave, systemParam, poiParam);

        //组织应用级参数
        Map<String,String> applicationParamsMap = ConvertUtil.convertToMap(poiParam);
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.PoiSave);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 获取所有门店codes
     * @param systemParam 系统参数
     * @return
     */
    public String poiGetIds(SystemParam systemParam) throws ApiOpException, ApiSysException {
        beforeMethod(null, systemParam);
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        return requestApi(methodName, systemParam, null);
    }

    /**
     * 获取门店详细信息
     * @param systemParam 系统参数
     * @param appPoiCodes 门店codes（可以多个，逗号分隔）
     * @return
     */
    public List<PoiParam> poiMget(SystemParam systemParam, String appPoiCodes) throws ApiOpException,
                                                                                    ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.PoiMGet, systemParam, appPoiCodes);

        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("app_poi_codes", appPoiCodes);
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.PoiMGet);

        String data = requestApi(methodName, systemParam, applicationParamsMap);
        List<PoiParam> poiParams = null;
        try{
            poiParams = JSONArray.parseArray(data, PoiParam.class);
        }catch (Exception e){
            throw new ApiSysException(ErrorEnum.SYS_ERR);
        }
        return poiParams;
    }

    /**
     * 将门店设置为营业状态
     * @param systemParam 系统参数
     * @param appPoiCode 门店code
     * @return
     */
    public String poiOpen(SystemParam systemParam, String appPoiCode) throws ApiOpException,
                                                                                     ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.PoiOPen, systemParam, appPoiCode);

        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("app_poi_code", appPoiCode);
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.PoiOPen);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 将门店设置为休息状态
     * @param systemParam 系统参数
     * @param appPoiCode 门店code
     * @return
     */
    public String poiClose(SystemParam systemParam, String appPoiCode) throws ApiOpException,
                                                                                    ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.PoiClose, systemParam, appPoiCode);

        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("app_poi_code", appPoiCode);
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.PoiClose);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 将门店设置为上线状态
     * @param systemParam 系统参数
     * @param appPoiCode 门店code
     * @return
     */
    public String poiOnline(SystemParam systemParam, String appPoiCode) throws ApiOpException,
                                                                                     ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.PoiOnline, systemParam, appPoiCode);

        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("app_poi_code", appPoiCode);
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.PoiOnline);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 将门店设置为下线状态
     * @param systemParam 系统参数
     * @param appPoiCode 门店code
     * @param reason 原因
     * @return
     */
    public String poiOffline(SystemParam systemParam, String appPoiCode, String reason) throws ApiOpException,
                                                                                      ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.PoiOffline, systemParam, appPoiCode, reason);

        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("app_poi_code", appPoiCode);
        applicationParamsMap.put("reason", reason);
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.PoiOffline);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 门店资质证书上传
     * @param systemParam 系统参数
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
    public String poiQualifySave(SystemParam systemParam, String appPoiCode, PoiQualificationEnum poiQualificationEnum,
                                 String qualificationUrl, String validDate, String address, String number)
        throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.PoiQualifySave, systemParam, appPoiCode, poiQualificationEnum, qualificationUrl);

        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("app_poi_code", appPoiCode);
        applicationParamsMap.put("type", String.valueOf(poiQualificationEnum.getType()));
        applicationParamsMap.put("qualification_url", qualificationUrl);
        if (validDate != null && !"".equals(validDate) && !"null".equals(validDate) && !"NULL".equals(validDate)) {
            applicationParamsMap.put("valid_date", validDate);
        }
        if (address != null && !"".equals(address) && !"null".equals(address) && !"NULL".equals(address)) {
            applicationParamsMap.put("address", address);
        }
        if (number != null && !"".equals(number) && !"null".equals(number) && !"NULL".equals(number)) {
            applicationParamsMap.put("number", number);
        }
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.PoiQualifySave);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 同步门店预计送达时长
     * @param systemParam 系统参数
     * @param appPoiCodes 门店code
     * @param sendTime 预计送达时长（单位分钟，如50表示50分钟送达）
     * @return
     */
    public String poiSendTimeSave(SystemParam systemParam, String appPoiCodes, int sendTime)
        throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.PoiSendTimeSave, systemParam, appPoiCodes, sendTime);

        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("app_poi_codes", appPoiCodes);
        applicationParamsMap.put("send_time", String.valueOf(sendTime));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.PoiSendTimeSave);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 更改门店附加信息
     * @param systemParam 系统参数
     * @param appPoiCode 门店code
     * @param appPoiEmail 门店email
     * @param appBrandCode 第三方品牌code值（对接的三方需要提前将该值告诉美团开发人员）
     * @param appOrgId 门店的法人企业（门店的财务结算等均由与之关联的结算企业信息决定，对接的三方需要提前将该值告诉美团对接商务）
     * @return
     */
    public String poiAdditionalSave(SystemParam systemParam, String appPoiCode, String appPoiEmail,
                                           String appBrandCode, String appOrgId) throws ApiOpException,
                                                                                        ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.PoiAdditionalSave, systemParam, appPoiCode);

        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("app_poi_code", appPoiCode);
        if (appPoiEmail != null && !"".equals(appPoiEmail) && !"null".equals(appPoiEmail) && !"NULL".equals(appPoiEmail)) {
            applicationParamsMap.put("app_poi_email", appPoiEmail);
        }
        if (appBrandCode != null && !"".equals(appBrandCode) && !"null".equals(appBrandCode) && !"NULL".equals(appBrandCode)) {
            applicationParamsMap.put("app_brand_code", appBrandCode);
        }
        if (appOrgId != null && !"".equals(appOrgId) && !"null".equals(appOrgId) && !"NULL".equals(appOrgId)) {
            applicationParamsMap.put("app_org_id", appOrgId);
        }
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.PoiAdditionalSave);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 更改门店公告信息
     * @param systemParam 系统参数
     * @param appPoiCode 门店code
     * @param promotionInfo 门店公告栏信息
     * @return
     */
    public String poiUpdatePromotionInfo(SystemParam systemParam, String appPoiCode, String promotionInfo)
        throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.PoiUpdatePromotionInfo, systemParam, appPoiCode);

        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("app_poi_code", appPoiCode);
        if (promotionInfo != null && !"".equals(promotionInfo) && !"null".equals(promotionInfo) && !"NULL".equals(promotionInfo)) {
            applicationParamsMap.put("promotion_info", promotionInfo);
        }
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.PoiUpdatePromotionInfo);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 获取门店品类列表
     * @param systemParam 系统参数
     * @return
     */
    public List<PoiTagParam> poiTagList(SystemParam systemParam) throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(null, systemParam);

        String data = requestApi(methodName, systemParam, null);
        List<PoiTagParam> poiTagParams = null;
        try{
            poiTagParams = JSONArray.parseArray(data, PoiTagParam.class);
        }catch (Exception e){
            throw new ApiSysException(ErrorEnum.SYS_ERR);
        }
        return poiTagParams;
    }

}
