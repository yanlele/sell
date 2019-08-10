package com.yanleweb.sell.form;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {

    @NotEmpty(message = "必须填写姓名")
    private String name;

    @NotEmpty(message = "手机号必须填")
    private String phone;

    @NotEmpty(message = "地址必须填写")
    private String address;

    @NotEmpty(message = "openid必须填写")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;
}
