package com.linjia.web.thirdService.eleme.interfaces.entity.item;

import java.util.List;

/**
 * 商品
 */
public class OItem {

    /**
     * 商品描述||"香脆可口，外焦里嫩"
     */
    private String description;

    /**
     * 商品Id||27970000058
     */
    private long id;

    /**
     * 商品名||"白切鸡"
     */
    private String name;

    /**
     * 是否有效||1
     *
     * @desc 0:无效 1:有效
     */
    private int isValid;

    /**
     * 最近一个月的售出份数||30
     */
    private int recentPopularity;

    /**
     * 商品分类Id||69093224
     */
    private long categoryId;

    /**
     * 店铺Id||987777
     */
    private long shopId;

    /**
     * 店铺名称||"烤鸡大王"
     */
    private String shopName;

    /**
     * 商品图片||"http://pic.ele.me/1929345.png"
     */
    private String imageUrl;

    /**
     * 标签||"{"isFeatured":0,"isGum":0,"isNew":1,"isSpicy":1}"
     */
    private OLabel labels;

    /**
     * 规格的列表||"[{"maxStock":100,"name":"大份","onShelf":1,"packingFee":1.0,"price":19.9,"specId":0,"stock":0},{"maxStock":100,"name":"中分","onShelf":1,"packingFee":1.0,"price":19.9,"specId":0,"stock":0}]"
     */
    private List<OSpec> specs;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    public int getRecentPopularity() {
        return recentPopularity;
    }

    public void setRecentPopularity(int recentPopularity) {
        this.recentPopularity = recentPopularity;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public OLabel getLabels() {
        return labels;
    }

    public void setLabels(OLabel labels) {
        this.labels = labels;
    }

    public List<OSpec> getSpecs() {
        return specs;
    }

    public void setSpecs(List<OSpec> specs) {
        this.specs = specs;
    }
}
