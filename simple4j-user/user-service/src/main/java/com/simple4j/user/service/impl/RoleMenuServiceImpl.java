package com.simple4j.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Lists;
import com.simple4j.user.mapper.RoleMenuMapper;
import com.simple4j.user.entity.RoleMenu;
import com.simple4j.user.request.MenuGrantRequest;
import com.simple4j.user.service.IRoleMenuService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务实现类
 *
 * @author Chill
 */
@Service
@RequiredArgsConstructor
public class RoleMenuServiceImpl implements
		IRoleMenuService {

	private final RoleMenuMapper roleMenuMapper;

	@Override
	public List<String> getPermission(List<Long> roleIds) {
		if (CollUtil.isEmpty(roleIds)) {
			return Lists.newArrayList();
		}
		return roleMenuMapper.permissions(roleIds);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean grant(MenuGrantRequest menuGrantRequest) {
		return grant(menuGrantRequest.getMenuIds(), menuGrantRequest.getRoleIds());
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean grant(List<Long> menuIds, List<Long> roleIds) {
		// 删除角色配置的菜单集合
		roleMenuMapper
				.physicsDelete(
						Wrappers.<RoleMenu>update().lambda().in(RoleMenu::getRoleId, roleIds));
		// 组装配置
		List<RoleMenu> roleMenus = new ArrayList<>();
		roleIds.forEach(roleId -> menuIds.forEach(menuId -> {
			RoleMenu roleMenu = new RoleMenu();
			roleMenu.setRoleId(roleId);
			roleMenu.setMenuId(menuId);
			roleMenus.add(roleMenu);
		}));
		// 新增配置
		return roleMenuMapper.saveBatch(roleMenus);
	}

	@Override
	public void removeByRoleIds(List<Long> roleIds) {
		if (CollUtil.isNotEmpty(roleIds)) {
			roleMenuMapper.physicsDelete(
					Wrappers.<RoleMenu>lambdaQuery().in(RoleMenu::getRoleId, roleIds));
		}
	}

	@Override
	public void removeByMenuIds(List<Long> menuIds) {
		if (CollUtil.isNotEmpty(menuIds)) {
			roleMenuMapper.physicsDelete(
					Wrappers.<RoleMenu>lambdaQuery().in(RoleMenu::getMenuId, menuIds));
		}
	}
}