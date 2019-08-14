package com.yanleweb.sell.service.impl;

import com.yanleweb.sell.dataobject.ProductInfo;
import com.yanleweb.sell.dto.CartDTO;
import com.yanleweb.sell.enums.ProductStatusEnum;
import com.yanleweb.sell.enums.ResultEnum;
import com.yanleweb.sell.exception.SellException;
import com.yanleweb.sell.repository.ProductInfoRepository;
import com.yanleweb.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> optionalProductInfo = repository.findById(cartDTO.getProductId());
            if (!optionalProductInfo.isPresent()) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = optionalProductInfo.get();
            Integer stock = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(stock);
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> optionalProductInfo = repository.findById(cartDTO.getProductId());
            if (!optionalProductInfo.isPresent()) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = optionalProductInfo.get();
            Integer stock = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (stock < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(stock);
            repository.save(productInfo);
        }
    }

    // TODO 上下架

    @Override
    public ProductInfo onSale(String productId) {
        return null;
    }

    @Override
    public ProductInfo offSale(String productId) {
        return null;
    }
}
