package com.linjia.web.query;

import com.linjia.base.query.Query;

public class LogisticsQuery extends Query{

		//id
		private Integer id;
		//订单id
		private Long order_id;
		//订单状态
		private String order_status;
		//配送员id
		private String dm_id;
		//取消原因
		private String cancel_reason;
		//配送员姓名
		private String dm_name;
		//配送员电话
		private String dm_mobile;
		//更新时间
		private Long update_time;
		//接单时间时间
		private Long recieve_time;
		//配送时间
		private Long send_time;
		//完成时间
		private Long finish_time;
		//时间类型(达达)
		private Integer action_type;
		//取消原因id
		private Integer reason_id;
		//店铺id
		private String mall_code;
		//订单来源
		private String order_source;
		private String outer_id;
		private String fee;
		private String distance;
		private Integer logis_type;
		//是否删除
		private boolean deleted;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Long getOrder_id() {
			return order_id;
		}
		public void setOrder_id(Long order_id) {
			this.order_id = order_id;
		}
		public String getOrder_status() {
			return order_status;
		}
		public void setOrder_status(String order_status) {
			this.order_status = order_status;
		}
		public String getDm_id() {
			return dm_id;
		}
		public void setDm_id(String dm_id) {
			this.dm_id = dm_id;
		}
		public String getCancel_reason() {
			return cancel_reason;
		}
		public void setCancel_reason(String cancel_reason) {
			this.cancel_reason = cancel_reason;
		}
		public String getDm_name() {
			return dm_name;
		}
		public void setDm_name(String dm_name) {
			this.dm_name = dm_name;
		}
		public String getDm_mobile() {
			return dm_mobile;
		}
		public void setDm_mobile(String dm_mobile) {
			this.dm_mobile = dm_mobile;
		}
		public Long getUpdate_time() {
			return update_time;
		}
		public void setUpdate_time(Long update_time) {
			this.update_time = update_time;
		}
		public Integer getAction_type() {
			return action_type;
		}
		public void setAction_type(Integer action_type) {
			this.action_type = action_type;
		}
		public Integer getReason_id() {
			return reason_id;
		}
		public void setReason_id(Integer reason_id) {
			this.reason_id = reason_id;
		}
		public String getMall_code() {
			return mall_code;
		}
		public void setMall_code(String mall_code) {
			this.mall_code = mall_code;
		}
		public String getOrder_source() {
			return order_source;
		}
		public void setOrder_source(String order_source) {
			this.order_source = order_source;
		}
		public boolean isDeleted() {
			return deleted;
		}
		public void setDeleted(boolean deleted) {
			this.deleted = deleted;
		}
		public String getOuter_id() {
			return outer_id;
		}
		public void setOuter_id(String outer_id) {
			this.outer_id = outer_id;
		}
		public String getFee() {
			return fee;
		}
		public void setFee(String fee) {
			this.fee = fee;
		}
		public String getDistance() {
			return distance;
		}
		public void setDistance(String distance) {
			this.distance = distance;
		}
		public Integer getLogis_type() {
			return logis_type;
		}
		public void setLogis_type(Integer logis_type) {
			this.logis_type = logis_type;
		}
		public Long getRecieve_time() {
			return recieve_time;
		}
		public void setRecieve_time(Long recieve_time) {
			this.recieve_time = recieve_time;
		}
		public Long getSend_time() {
			return send_time;
		}
		public void setSend_time(Long send_time) {
			this.send_time = send_time;
		}
		public Long getFinish_time() {
			return finish_time;
		}
		public void setFinish_time(Long finish_time) {
			this.finish_time = finish_time;
		}
		
		
}
