package com.yanleweb.sell.service;

import com.yanleweb.sell.dto.OrderDTO;

public interface PushMessageService {

    void orderStatus(OrderDTO orderDTO);
}
