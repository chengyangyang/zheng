package com.zhnari.bean;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * 用户类
 * @author ASUS
 *
 */
public class User {
    /*用户id*/
	
	private Integer uId;
	/*用户名称*/
	
    private String uName;
    /*用户密码*/
    
    
    private String uPassword;
    /*用户邮箱*/
   
    private String uMail;
    /*用户角色集合*/
    private Set<Role> roleSet = new HashSet<Role>();
    
    
    public User() {
		super();
	}

	public User(Integer uId, String uName, String uPassword, String uMail) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPassword = uPassword;
		this.uMail = uMail;
	}

	public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    public String getuMail() {
        return uMail;
    }

    public void setuMail(String uMail) {
        this.uMail = uMail == null ? null : uMail.trim();
    }

	public Set<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}
    
    
}