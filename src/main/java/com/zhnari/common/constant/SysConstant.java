package com.zhnari.common.constant;


import com.zhnari.common.enumbean.BaseEnum;

/**
 * Description:
 *
 * @author cy
 * @date 2018年12月22日 16:47
 * version 1.0
 */
public class SysConstant {

    /**
     * 人员状态
     */
    public enum SysUserStatus implements BaseEnum<SysUserStatus, String> {
        /**
         * 账户已经激活（默认）
         */
        ACTIVE("1"),
        /**
         * 账户锁定
         */
        LOCK("0");

        private String value;

        private SysUserStatus(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    /**
     * 人员类型
     */
    public enum SysUserType implements BaseEnum<SysUserType, String> {
        /**
         * 普通用户
         */
        USER("1"),
        /**
         * 系统管理员
         */
        ADMIN("0");

        private String value;

        private SysUserType(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }
    }
}