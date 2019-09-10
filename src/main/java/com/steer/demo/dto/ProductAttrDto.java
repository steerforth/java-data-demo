package com.steer.demo.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-10 17:08
 */
public class ProductAttrDto {
    @JSONField(name = "product_id")
    private String productId;
    @JSONField(name = "attr_name")
    private String attrName;
    @JSONField(name = "attr_value")
    private List<AttrValueDto> attrValue;
    @JSONField(name = "attr_values")
    private List<String> attrValues;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public List<AttrValueDto> getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(List<AttrValueDto> attrValue) {
        this.attrValue = attrValue;
    }

    public List<String> getAttrValues() {
        List<String> list = new ArrayList<>();
        if (getAttrValue()!= null){
            getAttrValue().stream().forEach(av->list.add(av.getAttr()));
        }
        return list;
    }

    public void setAttrValues(List<String> attrValues) {
        this.attrValues = attrValues;
    }
}
