package com.zhnari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhnari.bean.Permission;
import com.zhnari.bean.PermissionExample;
import com.zhnari.bean.PermissionExample.Criteria;
import com.zhnari.dao.PermissionMapper;

/**
 * 权限服务service层
 * @author ASUS
 *
 */

@Service
public class PermissionService {

	@Autowired
	PermissionMapper permissionMapper;
	
	/*查询所有的权限*/
	public List<Permission> selectAllPermission(){
		
		return permissionMapper.selectByExample(null);
		
	}
	
	/*新增权限*/
	public int insertPermission(Permission permission){
		
	return	permissionMapper.insert(permission);
		
	}
	
	/*根据主键删除权限*/
	public int deleteByPrimaryKey(Integer pid){
		
	return	permissionMapper.deleteByPrimaryKey(pid);
		
	}
	
	/*批量删除*/
	public void deleteAll(List<Integer> id){
		PermissionExample per = new PermissionExample();
		Criteria createCriteria = per.createCriteria();
		createCriteria.andPIdIn(id);	
		permissionMapper.deleteByExample(per);
	}
	
	/*根据权限名称查询权限主键*/
	public int selectPermissionIdBypermissionName(String permissionname){
		PermissionExample per = new PermissionExample();
		Criteria createCriteria = per.createCriteria();
		createCriteria.andPNameEqualTo(permissionname);
		List<Permission> selectByExample = permissionMapper.selectByExample(per);	
		return selectByExample.get(0).getpId();
				 
	}
	
	
}
