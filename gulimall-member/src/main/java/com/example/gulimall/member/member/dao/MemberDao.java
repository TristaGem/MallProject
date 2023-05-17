package com.example.gulimall.member.member.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.gulimall.member.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author 夏沫止水
 * @email HeJieLin@gulimall.com
 * @date 2020-05-22 19:42:06
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
