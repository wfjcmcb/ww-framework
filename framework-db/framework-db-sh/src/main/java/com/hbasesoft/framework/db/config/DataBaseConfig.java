/**************************************************************************************** 
 Copyright © 2003-2012 hbasesoft Corporation. All rights reserved. Reproduction or       <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.hbasesoft.framework.db.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.hibernate.transform.ResultTransformer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hbasesoft.framework.common.utils.PropertyHolder;
import com.hbasesoft.framework.db.TransactionManagerHolder;
import com.hbasesoft.framework.db.core.config.DaoConfig;
import com.hbasesoft.framework.db.hibernate.BaseHibernateDao;
import com.hbasesoft.framework.db.spring.AutoProxyBeanFactory;
import com.hbasesoft.framework.db.spring.SpringDaoHandler;

/**
 * <Description> <br>
 * 
 * @author 王伟<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年3月23日 <br>
 * @since V1.0<br>
 * @see com.hbasesoft.framework.db.config <br>
 */
@Configuration
public class DataBaseConfig {

    /**
     * Description: <br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @return <br>
     */
    @Bean(name = "springDaoHandler")
    public MethodInterceptor registDaoHandler() {
        // dao处理类
        return new SpringDaoHandler();
    }

    /**
     * Description: <br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @return <br>
     */
    @Bean
    public AutoProxyBeanFactory registAutoProxyBeanFactory() {

        AutoProxyBeanFactory beanFactory = new AutoProxyBeanFactory();

        // dao的配置
        DaoConfig dataConfig = new DaoConfig();
        dataConfig.setDbType(PropertyHolder.getProperty("master.db.type"));
        dataConfig.setBaseDaoType(BaseHibernateDao.class);
        dataConfig.setCallBackType(ResultTransformer.class);
        beanFactory.setConfig(dataConfig);
        beanFactory.setInterceptors("springDaoHandler");
        beanFactory.setPackagesToScan(TransactionManagerHolder.getBasePackage());

        return beanFactory;
    }

}
