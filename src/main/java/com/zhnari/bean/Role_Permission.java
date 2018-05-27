package com.zhnari.bean;
/**
 * 角色权限类
 * @author ASUS
 *
 */
public class Role_Permission {
	/*  主键*/
	private Integer rPId;
	/*角色id*/
    private Integer rId;
    /*权限id*/
    private Integer pId;

    
    
    public Role_Permission() {
		super();
	}

	public Role_Permission(Integer rPId, Integer rId, Integer pId) {
		super();
		this.rPId = rPId;
		this.rId = rId;
		this.pId = pId;
	}

	public Integer getrPId() {
        return rPId;
    }

    public void setrPId(Integer rPId) {
        this.rPId = rPId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }
}