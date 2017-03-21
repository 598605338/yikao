package com.linjia.web.thirdService.eleme.interfaces.entity.item;

/**
 * 标签
 */
public class OLabel {

    /**
     * 是否招牌菜||1
     *
     * @desc 0:不是招牌菜 1:是招牌菜
     */
    private int isFeatured;

    /**
     * 是否配菜||0
     *
     * @desc 0:不是配菜 1:是招配菜
     */
    private int isGum;

    /**
     * 是否新菜||0
     *
     * @desc 0:不是新菜 1:是新菜
     */
    private int isNew;

    /**
     * 是否辣||0
     *
     * @desc 0:不辣 1:辣
     */
    private int isSpicy;

    public int getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(int isFeatured) {
        this.isFeatured = isFeatured;
    }

    public int getIsGum() {
        return isGum;
    }

    public void setIsGum(int isGum) {
        this.isGum = isGum;
    }

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }

    public int getIsSpicy() {
        return isSpicy;
    }

    public void setIsSpicy(int isSpicy) {
        this.isSpicy = isSpicy;
    }
}
