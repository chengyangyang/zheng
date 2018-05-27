package com.zhnari.service;
/**
 * 角色service层
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhnari.bean.Role;
import com.zhnari.bean.RoleExample;
import com.zhnari.bean.RoleExample.Criteria;
import com.zhnari.dao.RoleMapper;

@Service
public class RoleService {

	@Autowired
	RoleMapper roleMapper;
	
	/*查询所有的角色*/
	public List<Role> selectAllRole(){		
		return roleMapper.selectByExample(null);		
	}
	
	/*新增角色*/
	public int insertRole(Role role){		
		return	roleMapper.insert(role);		
	}
	
	/*根据主键删除*/
	public int deleteRoleByPrimaryKey(Integer pid){		
		return	roleMapper.deleteByPrimaryKey(pid);	
	}
	
	/*批量删除*/
	public void deleteAllRole(List<Integer> id){
		RoleExample per = new RoleExample();
		Criteria createCriteria = per.createCriteria();
		createCriteria.andRIdIn(id);	
		roleMapper.deleteByExample(per);
	}
	
	/*根据角色名称查询角色id*/
	public int selectRoleIdByRoleName(String name){		
		RoleExample per = new RoleExample();
		Criteria createCriteria = per.createCriteria();
		createCriteria.andRNameEqualTo(name);
		List<Role> selectByExample = roleMapper.selectByExample(per);	
		return	selectByExample.get(0).getrId();		 
	}	
}
