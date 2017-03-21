package com.linjia.web.thirdService.eleme.interfaces.entity.item;

/**
 * 规格
 */
public class OSpec {

    /**
     * 规格Id||72970000222
     */
    private long specId;

    /**
     * 名称||"大份"
     */
    private String name;

    /**
     * 商品价格||18.0
     */
    private double price;

    /**
     * 库存量||9000
     */
    private int stock;

    /**
     * 最大库存量||10000
     */
    private int maxStock;

    /**
     * 包装费||3.0
     */
    private double packingFee;

    /**
     * 是否上架||1
     */
    private int onShelf;

    public long getSpecId() {
        return specId;
    }

    public void setSpecId(long specId) {
        this.specId = specId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(int maxStock) {
        this.maxStock = maxStock;
    }

    public double getPackingFee() {
        return packingFee;
    }

    public void setPackingFee(double packingFee) {
        this.packingFee = packingFee;
    }

    public int getOnShelf() {
        return onShelf;
    }

    public void setOnShelf(int onShelf) {
        this.onShelf = onShelf;
    }
}
