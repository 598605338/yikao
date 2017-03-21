package com.linjia.web.thirdService.eleme.interfaces.entity.order;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.linjia.web.thirdService.eleme.interfaces.enumeration.order.OOrderDetailGroupType;

/**
 * 商品分组(蓝子)
 */
public class OGoodsGroup {
    /**
     * 分组名称||"1号篮子"
     */
    private String name = "";

    /**
     * 分组类型||"normal"
     */
    private OOrderDetailGroupType type;
    
    @JsonIgnore
    private Integer id;
    
    @JsonIgnore
    private String order_id;
    
    @JsonIgnore
    private Long categoryId;

    /**
     * 商品信息的列表||"[{"categoryId":1123123,"id":2341123,"name":"奶茶","price":10.0,"quantity":30,"total":300.0}]"
     */
    private List<OGoodsItem> items = new ArrayList();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OOrderDetailGroupType getType() {
        return type;
    }

    public void setType(OOrderDetailGroupType type) {
        this.type = type;
    }

    public List<OGoodsItem> getItems() {
        return items;
    }

    public void setItems(List<OGoodsItem> items) {
        this.items = items;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
    
}
