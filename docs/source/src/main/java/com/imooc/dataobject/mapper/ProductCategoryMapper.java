package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import org.apache.ibatis.annotations.Insert;

import java.util.Map;

public interface ProductCategoryMapper {

    /**
     * 根据map的方式插入
     * @param map
     * @return
     */
    @Insert("insert into product_category(category_name, category_type) values(#{categoryName, jdbcType=VARCHAR}, #{category_type, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    /**
     * 根据对象的方式插入
     * @param productCategory
     * @return
     */
    @Insert("insert into product_category(category_name, category_type) values(#{category_name, jdbcType=VARCHAR}, #{category_type, jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory);
}
