package com.yanleweb.sell.dto;

import com.yanleweb.sell.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
public class OrderDTO  {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Date createTime;

    private Date updateTime;

    List<OrderDetail>  orderDetailList;
}
