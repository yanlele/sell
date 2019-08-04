package com.yanleweb.sell.service.impl;

import com.yanleweb.sell.dataobject.OrderDetail;
import com.yanleweb.sell.dataobject.ProductInfo;
import com.yanleweb.sell.dto.OrderDTO;
import com.yanleweb.sell.service.OrderService;
import com.yanleweb.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductServiceImpl productService;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        // 1、从orderDto 中拿出所有的商品id

        // 这一段要好好去研究一下lambdas
//        List<String> productIdList = orderDTO.getOrderDetailList().stream().map(OrderDetail::getProductId).collect(Collectors.toList());
//
//        List<ProductInfo> productInfoList = productIdList.stream().map(id-> productService.findOne(id)).collect(Collectors.toList());
//
//        orderAmount = productInfoList.stream().map(productInfo -> {
//            return productInfo.getProductPrice().multiply(new BigDecimal())
//        })


        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());


        }

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
