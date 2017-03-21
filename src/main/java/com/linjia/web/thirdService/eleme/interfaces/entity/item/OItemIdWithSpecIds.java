package com.linjia.web.thirdService.eleme.interfaces.entity.item;

import java.util.List;

/**
 * 商品以及商品规格
 */
public class OItemIdWithSpecIds {

    /**
     * 商品Id|必选|27970000058
     */
    private long itemId;

    /**
     * 商品规格Id的列表|必选|"[72970000221,72970000222,72970000225]"
     */
    private List<Long> itemSpecIds;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public List<Long> getItemSpecIds() {
        return itemSpecIds;
    }

    public void setItemSpecIds(List<Long> itemSpecIds) {
        this.itemSpecIds = itemSpecIds;
    }
}
