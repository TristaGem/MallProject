package com.example.gulimall.ware.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.utils.PageUtils;
import com.example.common.utils.Query;

import com.example.gulimall.ware.dao.PurchaseDetailDao;
import com.example.gulimall.ware.entity.PurchaseDetailEntity;
import com.example.gulimall.ware.service.PurchaseDetailService;


@Service("purchaseDetailService")
public class PurchaseDetailServiceImpl extends ServiceImpl<PurchaseDetailDao, PurchaseDetailEntity> implements PurchaseDetailService {

    @Autowired
    PurchaseDetailDao purchaseDetailDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        // filter the purchaseDetailEntity based on the parameters
        // like "key" -> sku_id or purchase_id
        // like "status" -> status
        // like "ware_id" -> wareId
        QueryWrapper<PurchaseDetailEntity> queryWrapper = new QueryWrapper<>();
        String key = (String) params.getOrDefault("key", "");
        if(!StringUtils.isEmpty(key)) {
            queryWrapper.eq("sku_id", key).or().eq("purchase_id", key);
        }

        String status = (String) params.get("status");
        if (!StringUtils.isEmpty(status) && !"0".equalsIgnoreCase(status)) {
            queryWrapper.eq("status",status);
        }

        String wareId = (String) params.get("wareId");
        if (!StringUtils.isEmpty(wareId) && !"0".equalsIgnoreCase(wareId)) {
            queryWrapper.eq("ware_id",wareId);
        }

        IPage<PurchaseDetailEntity> page = this.page(
                // getPage needs the page and limit field in params
                new Query<PurchaseDetailEntity>().getPage(params),
                new QueryWrapper<PurchaseDetailEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<PurchaseDetailEntity> listDetailByPurchaseId(Long id) {
        QueryWrapper<PurchaseDetailEntity> queryWrapper = new QueryWrapper<PurchaseDetailEntity>().eq("sku_id", id);
        // both works. because both underhood calls baseMapper.select
//        return purchaseDetailDao.selectList(queryWrapper);
        return this.list(queryWrapper);
    }

}