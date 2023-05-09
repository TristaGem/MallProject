package com.example.gulimall.product.dao;

import com.example.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author trista
 * @email savanatong@gmail.com
 * @date 2023-05-07 21:41:32
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
