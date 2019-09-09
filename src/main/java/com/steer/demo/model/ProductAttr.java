package com.steer.demo.model;

import com.steer.demo.common.model.BaseEntity;

import java.io.Serializable;

//@TableName("app_product_attr")
//@Entity(name = "app_product_attr")
public class ProductAttr extends BaseEntity<ProductAttr> {
//    /**
//     * 状态：0为正常，9为删除
//     */
//    @TableField(fill = FieldFill.INSERT)
//    @TableLogic
//    private short status;
//
//    @Column(name = "attr_value")
//    @TableField(value = "attr_value")
//    private List<Map<String,Boolean>> attr_value;
//
    @Override
    protected Serializable pkVal() {
        return super.getId();
    }
}
