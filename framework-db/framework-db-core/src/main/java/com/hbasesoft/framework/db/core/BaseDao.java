/**************************************************************************************** 
 Copyright © 2003-2012 hbasesoft Corporation. All rights reserved. Reproduction or       <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.hbasesoft.framework.db.core;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.hbasesoft.framework.db.core.utils.PagerList;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;

/**
 * <Description> <br>
 * 
 * @author 王伟<br>
 * @version 1.0<br>
 * @taskId <br>
 * @param <T> T
 * @CreateDate 2019年4月3日 <br>
 * @since V1.0<br>
 * @see com.hbasesoft.framework.db.hibernate <br>
 */
public interface BaseDao<T extends BaseEntity> {

    /**
     * Description: JPA工厂<br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @return <br>
     */
    CriteriaBuilder getCriteriaBuilder();

    /**
     * Description: 保存数据<br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param entity
     */
    void save(T entity);

    /**
     * Description: 批量保存<br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param entitys <br>
     */
    void saveBatch(List<T> entitys);

    /**
     * Description: 更新数据<br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param pojo <br>
     */
    void update(T pojo);

    /**
     * Description: 批量更新<br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param entitys <br>
     */
    void updateBatch(List<T> entitys);

    /**
     * Description: 根据条件来做更新<br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param criteria <br>
     */
    void updateByCriteria(CriteriaUpdate<T> criteria);

    /**
     * Description: 删除数据<br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param entity <br>
     */
    void delete(T entity);

    /**
     * Description: 根据id来删除<br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param id <br>
     */
    void deleteById(Serializable id);

    /**
     * Description: 批量删除<br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param entities <br>
     */
    void deleteBatch(Collection<T> entities);

    /**
     * Description: 根据id批量删除<br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param ids <br>
     */
    void deleteByIds(Collection<? extends Serializable> ids);

    /**
     * Description: 根据条件删除<br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param criteria <br>
     */
    void deleteByCriteria(CriteriaDelete<T> criteria);

    /**
     * Description: 根据id来获取数据<br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param id
     * @return <br>
     */
    T get(Serializable id);

    /**
     * Description: 根据唯一数据来查询数据<br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param propertyName
     * @param value
     * @return <br>
     */
    T getByProperty(String propertyName, Object value);

    /**
     * Description: 根据条件查询 <br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param <M> M
     * @param criteria
     * @return <br>
     */
    <M> M getByCriteria(CriteriaQuery<M> criteria);

    /**
     * Description: 查询所有数据<br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @return <br>
     */
    List<T> queryAll();

    /**
     * Description: 根据属性查询数据<br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param propertyName
     * @param value
     * @return <br>
     */
    List<T> queryByProperty(String propertyName, Object value);

    /**
     * Description: 根据条件查询<br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param criteria
     * @param pageIndex
     * @param pageSize
     * @return <br>
     */
    PagerList<T> queryPagerByCriteria(CriteriaQuery<T> criteria, int pageIndex, int pageSize);

    /**
     * Description: 根据条件查询 <br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param <M>
     * @param criteria
     * @return <br>
     */
    <M> List<M> queryByCriteria(CriteriaQuery<M> criteria);
}
