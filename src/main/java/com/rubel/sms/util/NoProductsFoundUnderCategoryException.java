package com.rubel.sms.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by dsi on 7/21/17.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,
        reason = "No Products Found In This Category")
public class NoProductsFoundUnderCategoryException extends RuntimeException{

    private String productId;

    public NoProductsFoundUnderCategoryException(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
