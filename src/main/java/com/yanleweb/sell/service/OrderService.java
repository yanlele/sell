package com.yanleweb.sell.service;

import com.yanleweb.sell.dto.OrderDTO;

public interface OrderService {
    /*创建订单*/
    OrderDTO create(OrderDTO orderDTO);

    OrderDTO findOne(String orderId);

}
