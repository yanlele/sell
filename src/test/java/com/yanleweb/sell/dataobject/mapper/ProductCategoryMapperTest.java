package com.yanleweb.sell.dataobject.mapper;

import com.yanleweb.sell.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Test
    public void insertByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("categoryName", "yanle测试mapper");
        map.put("category_type", 101);
        int result = productCategoryMapper.insertByMap(map);
        Assert.assertEquals(1, result);
    }

    @Test
    public void insertByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("yanle的测试object");
        productCategory.setCategoryType(102);
        int result = productCategoryMapper.insertByObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    public void findByCategoryType() {
        ProductCategory productCategory = productCategoryMapper.findByCategoryType(101);
        Assert.assertNotEquals(null, productCategory);
    }

    @Test
    public void findByCategoryName() {
        List<ProductCategory> result = productCategoryMapper.findByCategoryName("yanle");
        Assert.assertNotEquals(1, result);
    }

    @Test
    public void updateByCategoryType() {
        int result = productCategoryMapper.updateByCategoryType("yanle", 102);
        Assert.assertEquals(1, result);
    }

    @Test
    public void updateByCategoryObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("yanle的测试object111111");
        productCategory.setCategoryType(102);
        int result = productCategoryMapper.updateByCategoryObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    public void deleteProductCategory() {
        int result = productCategoryMapper.deleteProductCategory(102);
        Assert.assertNotEquals(1, result);
    }

    @Test
    public void selectByCategoryType() {
        ProductCategory productCategory = productCategoryMapper.selectByCategoryType(101);
        Assert.assertNotEquals(null, productCategory);
    }
}