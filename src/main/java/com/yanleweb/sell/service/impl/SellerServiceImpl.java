package com.yanleweb.sell.service.impl;

import com.yanleweb.sell.dataobject.SellerInfo;
import com.yanleweb.sell.repository.SellerInfoRepository;
import com.yanleweb.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerInfoRepository repository;


    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
