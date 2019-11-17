package com.imooc.service.impl;

import com.imooc.exception.SellException;
import com.imooc.service.RedisLock;
import com.imooc.service.SeckillService;
import com.imooc.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SeckillServiceImpl implements SeckillService {
    private static final int TIMEOUT = 10 * 1000;

    @Autowired
    private RedisLock redisLock;

    static Map<String , Integer> products;
    static Map<String , Integer> stock;
    static Map<String , String> orders;
    static {
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();
        products.put("123456", 100000);
        stock.put("123456", 100000);
    }

    @Override
    public String queryMap(String productId) {
        return "国庆节活动， 限量："
                + products.get(productId)
                + "  还剩："
                + stock.get(productId) + " 份"
                + " 该商品成功下单用户数目: "
                + orders.size() + " 人";
    }

    @Override
    public String querySecKillProductInfo(String productId) {
        return this.queryMap(productId);
    }

    @Override
    public synchronized void orderProductMockDiffUser(String productId) {
        // 加锁
        Long lockTime = System.currentTimeMillis() + TIMEOUT;
        if (redisLock.lock(productId, String.valueOf(lockTime))) {
            throw new SellException(101, "人太多，换一个姿势再试试");
        }

        // 查询该商品库存为0 结束活动
        int stockNum = stock.get(productId);
        if (stockNum == 0 ) {
            throw new SellException(100, "活动结束");
        } else {
            // 下单
            orders.put(KeyUtil.genUniqueKey(), productId);
            // 减库存
            stockNum = stockNum - 1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stock.put(productId, stockNum);
        }

        // 解锁
        redisLock.unlock(productId, String.valueOf(lockTime));
    }
}
