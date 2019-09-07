package com.steer.demo.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.steer.demo.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description: 首页菜单
 * @Date: 2019-09-06 12:14
 */
@TableName("app_menu")
@Entity(name = "app_menu")
public class Menu extends BaseEntity<Menu> {
    /**
     * 状态：0为正常，9为删除
     */
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private short status;

    String url;

    String name;

    String pic;

    @Column(name = "is_show")
    @TableField(value = "is_show")
    String show;

    @Override
    protected Serializable pkVal() {
        return super.getId();
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }
}
