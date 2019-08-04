package com.yanleweb.sell.service.impl;

import com.yanleweb.sell.dataobject.ProductInfo;
import com.yanleweb.sell.enums.ProductStatusEnum;
import com.yanleweb.sell.repository.ProductInfoRepository;
import com.yanleweb.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        // 实际上这样写的原因是因为 findOne 已经被废除了， 这样的写法可以代替findOne
        return repository.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    // todo 加减库存

    // TODO 上下架
}
