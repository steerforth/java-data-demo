package com.steer.demo.common.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-06 11:04
 */
@MappedSuperclass
public abstract class BaseEntity<T> extends Model<BaseEntity> {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @Column(name = "create_time")
    protected Date createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    @Column(name = "update_time")
    protected Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

