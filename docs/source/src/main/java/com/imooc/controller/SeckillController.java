package com.imooc.controller;

import com.imooc.service.impl.SeckillServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seckill")
@Slf4j
public class SeckillController {

    @Autowired
    private SeckillServiceImpl seckillService;

    /**
     * 查询秒杀活动商品信息
     * @param productId
     * @return
     * @throws Exception
     */
    @GetMapping("/query/{productId}")
    public String query(@PathVariable String productId) throws Exception {
        return seckillService.querySecKillProductInfo(productId);
    }

    /**
     * 秒杀方法
     * @param productId
     * @return
     * @throws Exception
     */
    @GetMapping("/order/{productId}")
    public String skill(@PathVariable String productId) throws Exception {
        log.info("@skill request productId： " + productId);
        seckillService.orderProductMockDiffUser(productId);
        return seckillService.querySecKillProductInfo(productId);
    }
}
