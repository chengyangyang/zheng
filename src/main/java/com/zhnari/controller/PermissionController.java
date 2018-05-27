package com.zhnari.controller;

/**
 * 权限控制层
 */

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhnari.bean.Permission;
import com.zhnari.bean.User;
import com.zhnari.other.Msg;
import com.zhnari.service.PermissionService;
import com.zhnari.service.RolePermissionService;

@Controller
public class PermissionController {

	@Autowired
	PermissionService permissionService;
	@Autowired
	RolePermissionService rolePermissionService;
	
	/* 查询所有的权限 */
	@RequestMapping("/permission/list")
	@ResponseBody
	public Msg getPermissionwithJson(Model model) {

		List<Permission> permission = permissionService.selectAllPermission();
		return Msg.success().add("permissionlist", permission);

	}
	/* 查询所有的权限 的页面跳转*/
	@RequestMapping("/permission")
	public String permission() {
		return "permissionList";
	}

	/* 增加权限信息 */
	@RequestMapping("/addpermission")
	public String addPermission(String permissionname) {
		if (permissionname != null) {
			List<String> str = new ArrayList<>();
			List<Permission> p = permissionService.selectAllPermission();
			for (Permission permission : p) {
				str.add(permission.getpName());
			}
			if (!str.contains(permissionname)) {
				Permission permission = new Permission();
				permission.setpName(permissionname);
				permissionService.insertPermission(permission);
			}
		}
		return "permissionList";
	}

	/* 删除权限信息 */
	@ResponseBody
	@RequestMapping(value = "/deletepermission{id}", method = RequestMethod.POST)
	public Msg deletepermission(@PathVariable("id") String id) {
		if (id.contains("-")) {
			List<Integer> idall = new ArrayList<>();
			// 分割
			String[] split = id.split("-");
			for (String string : split) {
				idall.add(Integer.parseInt(string));
				// 先删除角色权限表中该权限的所有
				rolePermissionService.deleteRolePermissionByPermissionId(Integer.parseInt(string));
			}
			permissionService.deleteAll(idall);
		} else {
			// 先删除角色权限表中该权限的所有
			rolePermissionService.deleteRolePermissionByPermissionId(Integer.parseInt(id));
			permissionService.deleteByPrimaryKey(Integer.parseInt(id));
		}
		return Msg.success();
	}

}
