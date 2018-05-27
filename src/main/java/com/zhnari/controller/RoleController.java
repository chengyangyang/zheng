package com.zhnari.controller;

/**
 * 角色控制层
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhnari.bean.Permission;
import com.zhnari.bean.Role;
import com.zhnari.bean.Role_Permission;
import com.zhnari.service.PermissionService;
import com.zhnari.service.RolePermissionService;
import com.zhnari.service.RoleService;
import com.zhnari.service.UserRoleService;
import com.zhnari.service.UserService;

@Controller
public class RoleController {

	@Autowired
	RoleService roleService;	
	@Autowired
	PermissionService permissionService;
	@Autowired
	UserService userService;
	@Autowired
	RolePermissionService rolePermissionService;
	@Autowired
	UserRoleService userRoleService;
	
	/*查询所有的角色*/
	@RequestMapping("/RoleSelectAll")
	public String selectAllRole(Model model){
		List<Role> selectAllRole = roleService.selectAllRole();
		model.addAttribute("selectAllRole", selectAllRole);
		return "roleList";
	}
	
	/*增加角色*/
	@RequestMapping("/addRole")
	public void addRole( String rolename, HttpServletRequest request,HttpServletResponse response){		
		if(rolename!=null){
			List<String> str = new ArrayList<>();
			List<Role> p = roleService.selectAllRole();	
			for (Role role : p) {
				str.add(role.getrName());
			}
			if(!str.contains(rolename)){
				Role role = new Role();
				role.setrName(rolename);
				roleService.insertRole(role);
			}	
		}
		 try {
			request.getRequestDispatcher("/RoleSelectAll").forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}	
	
	/*单个删除角色*/
	@RequestMapping("/deleteRole")
	public void delete( Integer id,HttpServletRequest request,HttpServletResponse response){		
		//删除用户角色中的角色
		userRoleService.deleteRole(id);	
		//删除角色权限中角色
		rolePermissionService.deleteRolePermissionByRoleId(id);	
		roleService.deleteRoleByPrimaryKey(id);		
		try {
			request.getRequestDispatcher("/RoleSelectAll").forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*查询所有角色拥有和没有的权限*/
	@RequestMapping("/selectpermission")
	public String selectpermission(String name,Model model){
		List<String> nothaspermission = new ArrayList<>();
		//查询所有的权限
		List<Permission> selectAllPermission = permissionService.selectAllPermission();
		for (Permission permission : selectAllPermission) {
			nothaspermission.add(permission.getpName());
		}	
		//查询角色拥有的权限
		List<String> selectPermissionByName = userService.selectPermissionByName(name);
		nothaspermission.removeAll(selectPermissionByName);
		Set<String> haspermission = new HashSet<>(selectPermissionByName);							
		model.addAttribute("name",name);	
		/*拥有的权限名称*/
		model.addAttribute("haspermission",haspermission);
		/*未拥有的权限名称*/
		model.addAttribute("nothaspermission",nothaspermission);		
		return "rolePermission";
	}
	
	/*给角色赋予权限*/
	@RequestMapping(value="/withpermiss")
	public void withPermission(HttpServletRequest request, HttpServletResponse response) {
		// 创建一个存放修改后角色权限的集合
		List<String> alterpermission = new ArrayList<>();
		String name = request.getParameter("permiss");
		// 查询修改后的角色权限
		String[] parameterValues = request.getParameterValues("permission");
		if (parameterValues != null) {
			for (String string : parameterValues) {
				if (string != "" && string != null) {
					alterpermission.add(string);
				}
			}
		}
		// 根据角色名称查询角色的id
		int rid = roleService.selectRoleIdByRoleName(name);
		// 查询当前角色所拥有的权限
		List<String> selectPermissionByName = userService.selectPermissionByName(name);
		for (String string : selectPermissionByName) {
			if (string != "" && !alterpermission.contains(string)) {
				// 根据权限名称获得权限的id
				int pid = permissionService.selectPermissionIdBypermissionName(string);
				// 执行删除操作
				rolePermissionService.deleteRolePermission(rid, pid);
			}
		}
		// 获得选中的权限
		for (String string : alterpermission) {
			if (!selectPermissionByName.contains(string)) {
				// 根据权限名称获得权限id
				int pid = permissionService.selectPermissionIdBypermissionName(string);
				// 执行新增操作
				Role_Permission rp = new Role_Permission();
				rp.setpId(pid);
				rp.setrId(rid);
				rolePermissionService.addRolePermission(rp);
			}
		}
		try {
			request.getRequestDispatcher("/RoleSelectAll").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
