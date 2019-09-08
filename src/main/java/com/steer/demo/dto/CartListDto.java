package com.steer.demo.dto;

import com.steer.demo.model.Cart;

import java.util.List;

public class CartListDto {
    private List<Cart> valid;
    private List<Cart> invalid;

    public List<Cart> getValid() {
        return valid;
    }

    public void setValid(List<Cart> valid) {
        this.valid = valid;
    }

    public List<Cart> getInvalid() {
        return invalid;
    }

    public void setInvalid(List<Cart> invalid) {
        this.invalid = invalid;
    }
}
