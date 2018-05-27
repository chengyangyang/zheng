package com.zhnari.bean;
/**
 * 用户角色类
 * @author ASUS
 *
 */
public class User_Role {
    /*主键*/
	private Integer uRId;
	/*用户主键*/
    private Integer uId;
    /*角色主键*/
    private Integer rId;

    public Integer getuRId() {
        return uRId;
    }

    public void setuRId(Integer uRId) {
        this.uRId = uRId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }
}