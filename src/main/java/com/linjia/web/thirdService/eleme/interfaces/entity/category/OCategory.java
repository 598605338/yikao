package com.linjia.web.thirdService.eleme.interfaces.entity.category;


/**
 * 商品分类
 */
public class OCategory {
    /**
     * 商品分类Id||26940000135
     */
    private long id;

    /**
     * 商品分类名称||"家常菜"
     */
    private String name;

    /**
     * 商品分类描述||"家庭日常的小炒"
     */
    private String description;

    /**
     * 是否有效||1
     *
     * @desc 0:无效 1:有效
     */
    private int isValid;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }
}
