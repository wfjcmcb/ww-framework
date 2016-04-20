/**
 * 
 */
package com.hbasesoft.framework.web.system.dao.area;

import java.util.List;

import com.hbasesoft.framework.web.system.bean.AreaPojo;
import com.hbasesoft.framework.db.core.DaoException;
import com.hbasesoft.framework.db.core.annotation.Dao;
import com.hbasesoft.framework.db.core.annotation.Sql;
import com.hbasesoft.framework.db.hibernate.IGenericBaseDao;

/**
 * <Description> <br>
 * 
 * @author 伟<br>
 * @version 1.0<br>
 * @CreateDate 2015-1-25 <br>
 * @see com.hbasesoft.framework.web.dao <br>
 */
@Dao
public interface AreaDao extends IGenericBaseDao {

    /**
     * Description: 从数据库中获取AREA表的所有记录<br>
     * 
     * @author shao.dinghui<br>
     * @taskId <br>
     * @return
     * @throws DaoException <br>
     */
    @Sql(bean = AreaPojo.class,
        value = "SELECT AREA_ID, PARENT_AREA_ID, AREA_TYPE, AREA_NAME, AREA_CODE, REMARK FROM AREA")
    List<AreaPojo> selectList() throws DaoException;
    
    @Sql(value = "SELECT AREA.SHORT_NAME FROM T_SYS_AREA AREA WHERE AREA.AREA_TYPE =2", bean = String.class)
    List<String> queryAllByCity() throws DaoException;
    
    @Sql(value = "SELECT SHORT_NAME FROM T_SYS_AREA WHERE AREA_CODE =:CITY_CODE")
    String queryCityByCode() throws DaoException;

}
