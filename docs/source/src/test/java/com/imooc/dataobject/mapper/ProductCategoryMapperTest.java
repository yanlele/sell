package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.plaf.PanelUI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {
    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() throws Exception{
        Map<String, Object> map = new HashMap<>();
        map.put("categoryName", "yanle测试mapper");
        map.put("category_type", 101);

        int result = mapper.insertByMap(map);
        Assert.assertEquals(1, result);
    }

    @Test
    public void insertByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("yanle的测试object");
        productCategory.setCategoryType(102);
        int result = mapper.insertByObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    public void findByCategoryType() {
        ProductCategory productCategory = mapper.findByCategoryType(101);
        Assert.assertNotEquals(null, productCategory);
    }

    @Test
    public void findByCategoryName() {
        List<ProductCategory> result = mapper.findByCategoryName("yanle");
        Assert.assertNotEquals(0, result);
    }

    @Test
    public void updateByCategoryType() {
        int result = mapper.updateByCategoryType("yanle", 102);
        Assert.assertEquals(1, result);
    }

    @Test
    public void updateByCategoryObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("yanle的测试object111");
        productCategory.setCategoryType(102);
        int result = mapper.updateByCategoryObject(productCategory);
        Assert.assertEquals(1, result);
    }


    @Test
    public void DeleteProductCategory() {
        int result = mapper.deleteProductCategory(102);
        Assert.assertNotEquals(1, result);
    }


 }