package com.yanleweb.sell.repository;

import com.yanleweb.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    @Transactional
    public void saveOneTest() {
        ProductCategory productCategory = new ProductCategory("女神111", 2);
        ProductCategory response = repository.save(productCategory);
        Assert.assertNotEquals(null, response);
    }

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findById(1).get();
        System.out.println(productCategory.toString());
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void updateTest() {
        ProductCategory productCategory = repository.findById(1).get();
        productCategory.setCategoryName("yanle");
        ProductCategory result = repository.save(productCategory);
        Assert.assertEquals(productCategory, result);
    }
}