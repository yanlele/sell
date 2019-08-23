package com.yanleweb.sell.service;

import com.yanleweb.sell.dataobject.SellerInfo;

public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);
}
