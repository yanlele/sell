package com.yanleweb.sell.service.impl;

import com.yanleweb.sell.dataobject.ProductInfo;
import com.yanleweb.sell.dto.CartDTO;
import com.yanleweb.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("123456");
        Assert.assertEquals("123456", productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0, 2);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
//        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0, productInfoPage.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1234523");
        productInfo.setProductName("皮皮虾33");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好吃的虾");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(1);

        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void increaseStock() throws Exception {
        List<CartDTO> cartDTOList = new ArrayList<>();
        cartDTOList.add(new CartDTO("111111", 10));
        cartDTOList.add(new CartDTO("123421", 10));
        productService.increaseStock(cartDTOList);
    }

    @Test
    public void decreaseStock() throws Exception {
        List<CartDTO> cartDTOList = new ArrayList<>();
        cartDTOList.add(new CartDTO("111111", 10));
        cartDTOList.add(new CartDTO("123421", 10));
        productService.decreaseStock(cartDTOList);
    }
}