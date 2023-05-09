package com.example.gulimall.coupon.dao;

import com.example.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author trista
 * @email savanatong@gmail.com
 * @date 2023-05-08 15:35:27
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
