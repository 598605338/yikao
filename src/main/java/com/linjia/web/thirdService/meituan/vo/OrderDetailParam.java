package com.linjia.web.thirdService.meituan.vo;

import java.util.List;

/**
 * Created by zhangzhidong on 15/10/28.
 */
public class OrderDetailParam {
	String order_id;
	String wm_order_id_view;
    String app_poi_code;
    String wm_poi_name;
    String wm_poi_address;
    String wm_poi_phone;
    String recipient_address;
    String recipient_phone;
    String recipient_name;
    String shipping_fee;
    String total;
    String original_price;
    String caution;
    String shipper_phone;
    String status;
    String city_id;
    String has_invoiced;
    String invoice_title;
    String delivery_time;
    String is_third_shipping;
    String latitude;
    String longitude;
    List<OrderFoodDetailParam> detail;
    List<OrderExtraParam> extras;
    String order_send_time;
    String order_receive_time;
    String order_confirm_time;
    String order_cancel_time;
    String order_completed_time;
    String logistics_status;
    String logistics_id;
    String logistics_name;
    String logistics_send_time;
    String logistics_confirm_time;
    String logistics_cancel_time;
    String logistics_fetch_time;
    String logistics_completed_time;
    String logistics_dispatcher_name;
    String logistics_dispatcher_mobile;
    String result;
    String order_status;

    public String getApp_poi_code() {
        return app_poi_code;
    }

    public void setApp_poi_code(String app_poi_code) {
        this.app_poi_code = app_poi_code;
    }

    public String getCaution() {
        return caution;
    }

    public void setCaution(String caution) {
        this.caution = caution;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
    }

    public List<OrderFoodDetailParam> getDetail() {
        return detail;
    }

    public void setDetail(
        List<OrderFoodDetailParam> detail) {
        this.detail = detail;
    }

    public List<OrderExtraParam> getExtras() {
        return extras;
    }

    public void setExtras(
        List<OrderExtraParam> extras) {
        this.extras = extras;
    }

    public String getHas_invoiced() {
        return has_invoiced;
    }

    public void setHas_invoiced(String has_invoiced) {
        this.has_invoiced = has_invoiced;
    }

    public String getInvoice_title() {
        return invoice_title;
    }

    public void setInvoice_title(String invoice_title) {
        this.invoice_title = invoice_title;
    }

    public String getIs_third_shipping() {
        return is_third_shipping;
    }

    public void setIs_third_shipping(String is_third_shipping) {
        this.is_third_shipping = is_third_shipping;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLogistics_cancel_time() {
        return logistics_cancel_time;
    }

    public void setLogistics_cancel_time(String logistics_cancel_time) {
        this.logistics_cancel_time = logistics_cancel_time;
    }

    public String getLogistics_completed_time() {
        return logistics_completed_time;
    }

    public void setLogistics_completed_time(String logistics_completed_time) {
        this.logistics_completed_time = logistics_completed_time;
    }

    public String getLogistics_confirm_time() {
        return logistics_confirm_time;
    }

    public void setLogistics_confirm_time(String logistics_confirm_time) {
        this.logistics_confirm_time = logistics_confirm_time;
    }

    public String getLogistics_dispatcher_mobile() {
        return logistics_dispatcher_mobile;
    }

    public void setLogistics_dispatcher_mobile(String logistics_dispatcher_mobile) {
        this.logistics_dispatcher_mobile = logistics_dispatcher_mobile;
    }

    public String getLogistics_dispatcher_name() {
        return logistics_dispatcher_name;
    }

    public void setLogistics_dispatcher_name(String logistics_dispatcher_name) {
        this.logistics_dispatcher_name = logistics_dispatcher_name;
    }

    public String getLogistics_fetch_time() {
        return logistics_fetch_time;
    }

    public void setLogistics_fetch_time(String logistics_fetch_time) {
        this.logistics_fetch_time = logistics_fetch_time;
    }

    public String getLogistics_id() {
        return logistics_id;
    }

    public void setLogistics_id(String logistics_id) {
        this.logistics_id = logistics_id;
    }

    public String getLogistics_name() {
        return logistics_name;
    }

    public void setLogistics_name(String logistics_name) {
        this.logistics_name = logistics_name;
    }

    public String getLogistics_send_time() {
        return logistics_send_time;
    }

    public void setLogistics_send_time(String logistics_send_time) {
        this.logistics_send_time = logistics_send_time;
    }

    public String getLogistics_status() {
        return logistics_status;
    }

    public void setLogistics_status(String logistics_status) {
        this.logistics_status = logistics_status;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getOrder_cancel_time() {
        return order_cancel_time;
    }

    public void setOrder_cancel_time(String order_cancel_time) {
        this.order_cancel_time = order_cancel_time;
    }

    public String getOrder_completed_time() {
        return order_completed_time;
    }

    public void setOrder_completed_time(String order_completed_time) {
        this.order_completed_time = order_completed_time;
    }

    public String getOrder_confirm_time() {
        return order_confirm_time;
    }

    public void setOrder_confirm_time(String order_confirm_time) {
        this.order_confirm_time = order_confirm_time;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_receive_time() {
        return order_receive_time;
    }

    public void setOrder_receive_time(String order_receive_time) {
        this.order_receive_time = order_receive_time;
    }

    public String getOrder_send_time() {
        return order_send_time;
    }

    public void setOrder_send_time(String order_send_time) {
        this.order_send_time = order_send_time;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(String original_price) {
        this.original_price = original_price;
    }

    public String getRecipient_address() {
        return recipient_address;
    }

    public void setRecipient_address(String recipient_address) {
        this.recipient_address = recipient_address;
    }

    public String getRecipient_name() {
        return recipient_name;
    }

    public void setRecipient_name(String recipient_name) {
        this.recipient_name = recipient_name;
    }

    public String getRecipient_phone() {
        return recipient_phone;
    }

    public void setRecipient_phone(String recipient_phone) {
        this.recipient_phone = recipient_phone;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getShipper_phone() {
        return shipper_phone;
    }

    public void setShipper_phone(String shipper_phone) {
        this.shipper_phone = shipper_phone;
    }

    public String getShipping_fee() {
        return shipping_fee;
    }

    public void setShipping_fee(String shipping_fee) {
        this.shipping_fee = shipping_fee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getWm_order_id_view() {
        return wm_order_id_view;
    }

    public void setWm_order_id_view(String wm_order_id_view) {
        this.wm_order_id_view = wm_order_id_view;
    }

    public String getWm_poi_address() {
        return wm_poi_address;
    }

    public void setWm_poi_address(String wm_poi_address) {
        this.wm_poi_address = wm_poi_address;
    }

    public String getWm_poi_name() {
        return wm_poi_name;
    }

    public void setWm_poi_name(String wm_poi_name) {
        this.wm_poi_name = wm_poi_name;
    }

    public String getWm_poi_phone() {
        return wm_poi_phone;
    }

    public void setWm_poi_phone(String wm_poi_phone) {
        this.wm_poi_phone = wm_poi_phone;
    }
}
