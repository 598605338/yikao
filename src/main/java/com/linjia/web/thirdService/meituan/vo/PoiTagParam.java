package com.linjia.web.thirdService.meituan.vo;

/**
 * Created by zhangzhidong on 15/10/28.
 */
public class PoiTagParam {
    String id;
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PoiTagParam{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
