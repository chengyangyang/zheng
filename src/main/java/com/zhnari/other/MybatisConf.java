package com.zhnari.other;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.pagehelper.PageHelper;
 
/*
 * 注册MyBatis分页插件PageHelper
 */


//@Component 
//@Configuration
public class MybatisConf {
        @Bean
        public PageHelper pageHelper() {
           System.out.println("MyBatisConfiguration.pageHelper()");
            PageHelper pageHelper = new PageHelper();
            Properties p = new Properties();
            p.setProperty("offsetAsPageNum", "true");
            p.setProperty("rowBoundsWithCount", "true");
            p.setProperty("reasonable", "true");
            p.setProperty("returnPageInfo", "check");
            pageHelper.setProperties(p);
            return pageHelper;
        }
}