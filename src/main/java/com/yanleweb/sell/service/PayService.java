package com.yanleweb.sell.service;

import com.lly835.bestpay.model.PayResponse;
import com.yanleweb.sell.dto.OrderDTO;

public interface PayService {
    PayResponse crate(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    PayResponse refund(OrderDTO orderDTO);
}
