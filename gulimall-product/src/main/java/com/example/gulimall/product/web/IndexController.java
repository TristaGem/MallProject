package com.example.gulimall.product.web;

import com.example.gulimall.product.entity.CategoryEntity;
import com.example.gulimall.product.service.CategoryService;
import com.example.gulimall.product.vo.Catelog2Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


// adding product sale frontend webpage
/*
 1. introduce the frontend template engine thymeleaf
 2. put the static resources under the resources/static folder, all the resources in this folder
 can be accessed by the path
 3. put the index.html under the resources/templates folder, SpringBoot will try to find index.html under it
 4. how to update the frontend page without restarting the service?
    1. introduce spring-boot-devtools in pom.xml
    2. after modifying the page, ctrl+shift+f9 to do the recompiling of the resource
 */
@Controller
public class IndexController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value={"/"})
    public String indexPage(Model model) {
        List<CategoryEntity> categoryEntityList = categoryService.getLevel1Category();
        model.addAttribute("categories", categoryEntityList);
        // it will return the resources/templates/index.html file
        return "index";

    }

    //index/json/catalog.json
    @GetMapping(value = "/index/json/catalog.json")
    @ResponseBody
    public Map<String, List<Catelog2Vo>> getCatalogJson() {

        Map<String, List<Catelog2Vo>> catalogJson = categoryService.getCatalogJson();

        return catalogJson;

    }
}
