package com.yanleweb.sell.form;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductForm {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer ProductStock;

    private String ProductDescription;

    private String productIcon;

    private Integer categoryType;
}
