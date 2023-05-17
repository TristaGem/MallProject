package com.example.gulimall.ware.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.utils.PageUtils;
import com.example.common.utils.Query;

import com.example.gulimall.ware.dao.PurchaseDao;
import com.example.gulimall.ware.entity.PurchaseEntity;
import com.example.gulimall.ware.service.PurchaseService;
import org.springframework.transaction.annotation.Transactional;


@Service("purchaseService")
public class PurchaseServiceImpl extends ServiceImpl<PurchaseDao, PurchaseEntity> implements PurchaseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PurchaseEntity> page = this.page(
                new Query<PurchaseEntity>().getPage(params),
                new QueryWrapper<PurchaseEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageUnreceive(Map<String, Object> params) {
        //TODO
        return queryPage(params);
    }

    /**
     * 合并采购需求
     * @param mergeVo
     */
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public void mergePurchase(MergeVo mergeVo) {
//
//    }

//    /**
//     * 领取采购单
//     * @param ids 采购单的id
//     */
//    @Override
//    public void received(List<Long> ids) {
//
//    }

    /**
     * 完成采购单
     * @param doneVo
     */
//    @Override
//    public void done(PurchaseDoneVo doneVo) {
//
//    }
}