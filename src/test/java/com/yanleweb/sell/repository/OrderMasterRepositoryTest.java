package com.yanleweb.sell.repository;

import com.yanleweb.sell.dataobject.OrderMaster;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "1234567890";

    @Test
    public void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234568");
        orderMaster.setBuyerName("yanle");
        orderMaster.setBuyerPhone("123659283234");
        orderMaster.setBuyerAddress("成都");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = PageRequest.of(1, 3);
        Page<OrderMaster> orderMasterPage = repository.findByBuyerOpenid(OPENID, pageRequest);
        System.out.println(orderMasterPage);
        Assert.assertNotEquals(0, orderMasterPage.getTotalElements());
    }
}