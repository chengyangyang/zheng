package com.zhnari.bean;
/**
 * 权限类
 * @author ASUS
 *
 */

public class Permission {
    /*主键*/
	private Integer pId;
	/*权限名称*/
    private String pName;

    
    
    /*构造方法*/
    public Permission() {
		super();
	}

	public Permission(Integer pId, String pName) {
		super();
		this.pId = pId;
		this.pName = pName;
	}

	/*get set 方法*/
	public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }
}