package com.simple4j.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.simple4j.common.orm.BaseEntity;

/**
 * 角色菜单关联
 *
 * @author Chill
 */
@Data
@TableName("simple4j_role_menu")
public class RoleMenu extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 菜单id
	 */
	private Long menuId;

	/**
	 * 角色id
	 */
	private Long roleId;


}