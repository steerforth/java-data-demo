package com.steer.demo.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-06 16:25
 */
public class FastDto {
    private String id;
    private String pic;
    @JSONField(name="cate_name")
    private String cateName;

    public FastDto(String id, String pic, String cateName) {
        this.id = id;
        this.pic = pic;
        this.cateName = cateName;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
}
