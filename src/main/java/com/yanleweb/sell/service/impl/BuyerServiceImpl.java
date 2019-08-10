package com.yanleweb.sell.service.impl;

import com.yanleweb.sell.dto.OrderDTO;
import com.yanleweb.sell.service.BuyerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return null;
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        return null;
    }
}
