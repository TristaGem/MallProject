package com.example.gulimallsearch.controller;

import com.example.common.exception.BizCodeEnum;
import com.example.common.to.es.SkuEsModel;
import com.example.common.utils.R;
import com.example.gulimallsearch.service.ProductSaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/search/save")
public class ElasticSaveController {

    @Autowired
    private ProductSaveService productSaveService;

    @PostMapping("/product")
    public R productStatusUp(@RequestBody List<SkuEsModel> skuEsModelList) throws IOException {
        boolean upStatus;
        try {
            upStatus = productSaveService.productStatusUp(skuEsModelList);
        } catch (Exception e) {
            log.error("ElasticSaveController product up stock throw error {}", e);
            return R.error(BizCodeEnum.PRODUCT_UP_EXCEPTION.getCode(), BizCodeEnum.PRODUCT_UP_EXCEPTION.getMessage());
        }

        if(upStatus) {
            return R.ok();
        } else {
            return R.error(BizCodeEnum.PRODUCT_UP_EXCEPTION.getCode(), BizCodeEnum.PRODUCT_UP_EXCEPTION.getMessage());
        }


    }



}
