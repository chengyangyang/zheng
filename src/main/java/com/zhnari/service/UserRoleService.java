package com.zhnari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhnari.bean.User_Role;
import com.zhnari.bean.User_RoleExample;
import com.zhnari.bean.User_RoleExample.Criteria;
import com.zhnari.dao.User_RoleMapper;
/**
 * 用户角色service层
 * @author ASUS
 *
 */
@Service
public class UserRoleService {

	@Autowired
	User_RoleMapper user_RoleMapper;
	
	
	/*根据用户的id查询用户角色*/
	public List<User_Role> selectRoleByUserId(Integer uid){
		User_RoleExample example = new User_RoleExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUIdEqualTo(uid);
		List<User_Role> selectByExample = user_RoleMapper.selectByExample(example);
		return selectByExample;
	}
	
	/*增加用户角色*/
	public int addUserRole(User_Role record){		
		int insert = user_RoleMapper.insert(record);
		return insert;
	}
	
	/*根据用户和角色id删除单个用户角色*/
	public void deleteUserRle(Integer uid,Integer rid){
		User_RoleExample example = new User_RoleExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUIdEqualTo(uid);
		createCriteria.andRIdEqualTo(rid);
		user_RoleMapper.deleteByExample(example);
	}
	
	/*根据在用户角色中，根据角色id*/
	public void deleteRole(Integer rid){
		User_RoleExample example = new User_RoleExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andRIdEqualTo(rid);
		int deleteByExample = user_RoleMapper.deleteByExample(example);		
	}	
}
