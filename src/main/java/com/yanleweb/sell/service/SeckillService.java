package com.yanleweb.sell.service;

public interface SeckillService {

    String queryMap(String productId);

    String querySecKillProductInfo(String productId);

    void orderProductMockDiffUser(String productId);
}
