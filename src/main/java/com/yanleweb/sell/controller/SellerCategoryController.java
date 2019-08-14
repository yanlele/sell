package com.yanleweb.sell.controller;


import com.yanleweb.sell.dataobject.ProductCategory;
import com.yanleweb.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("category/list", map);
    }

    @GetMapping("/index")
    public ModelAndView index(
            @RequestParam(value = "categoryId", required = false) Integer categoryId,
            Map<String, Object> map
    ) {
        if (categoryId != null) {
            ProductCategory productCategory = categoryService.findOne(categoryId);
            map.put("category", productCategory);
        }

        return new ModelAndView("category/index", map);
    }
}
