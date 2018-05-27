package com.zhnari.bean;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;

/**
 * 角色类
 * @author ASUS
 *
 */

public class Role {
    /*角色主键*/
	private Integer rId;
	/*角色名称*/
	@Size(max=6,min=1,message="长度不能大于六位")
    private String rName;
    /*角色权限集合*/
    private Set<Permission> permissionSet = new HashSet<Permission>();
    

    public Role() {
		super();
	}

	public Role(Integer rId, String rName) {
		super();
		this.rId = rId;
		this.rName = rName;
	}

	public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

	public Set<Permission> getPermissionSet() {
		return permissionSet;
	}

	public void setPermissionSet(Set<Permission> permissionSet) {
		this.permissionSet = permissionSet;
	}
    
}