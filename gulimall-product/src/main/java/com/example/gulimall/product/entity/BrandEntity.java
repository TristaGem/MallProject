package com.example.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.example.common.valid.AddGroup;
import com.example.common.valid.ListValue;
import com.example.common.valid.UpdateGroup;
import lombok.Data;
import org.apache.ibatis.annotations.Update;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author trista
 * @email savanatong@gmail.com
 * @date 2023-05-07 21:41:32
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	/*
	Another feature:
	1.different methods requires different data validation methods
	For example, when we try to add the brand, brandId is autogenerated, it needs to be empty, we can write some empty interface
	as a tag. But once you specified the groups, all fields that need to be validated, their groups need to be specified

	2.The methods can be tagged by @Validated({AddGroup.class}) before the parameter
	But at the same time, all fields that have not been assigned the groups value, will not be validated.
	 */
	@Null(message = "can't specify the id when adding the brand", groups = {AddGroup.class})
	@NotNull(message = "BrandId is needed when modifying the brand", groups = {UpdateGroup.class})
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "brand name should not be empty", groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotEmpty(groups = {AddGroup.class})
	@URL(message = "logo should be a legit url", groups = {AddGroup.class, UpdateGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	/*
	Customized field validation method
	1. wrote a customized validate annotator
	2. wrote the validation method
	3. associate them like following
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
	@Retention(RUNTIME)
	@Documented
	@Constraint(validatedBy = { ListValueConstraintValidator.class })
	public @interface ListValue {
	 */
	@ListValue(vals={0, 1}, groups={AddGroup.class, UpdateGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */

	@NotEmpty()
	@Pattern(regexp = "^[a-zA-Z]$", groups = {AddGroup.class, UpdateGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull
	@Min(0)
	private Integer sort;

}
