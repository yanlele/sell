package com.yanleweb.sell.service.impl;

import com.yanleweb.sell.dto.OrderDTO;
import com.yanleweb.sell.service.OrderService;
import com.yanleweb.sell.utils.KeyUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.math.BigInteger;

public class OrderServiceImpl implements OrderService {
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        // 1、从orderDto 中拿出所有的商品id

        // 2、通过商品ID 查出商品详情，然后计算出订单总价

        // 3、订单详情入库

        // 4、创建订单信息

        // 5、扣库存

        // 6、发送webSocket信息
        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(Pageable pageable) {
        return null;
    }
}
