/**************************************************************************************** 
 Copyright © 2003-2012 hbasesoft Corporation. All rights reserved. Reproduction or       <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.framework.message.redis;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/**
 * <Description> <br>
 * 
 * @author 王伟<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2017年2月19日 <br>
 * @since V1.0<br>
 * @see com.framework.message.redis <br>
 */
public class ClusterRedisMessageQueue implements MessageQueue {

    /**
     * Description: <br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param key
     * @param value <br>
     */
    @Override
    public void push(final String key, final byte[] value) {
        RedisClientFactory.getBinaryJedisCluster().lpush(key.getBytes(), value);
    }

    /**
     * Description: <br>
     * 081120
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param key
     * @return <br>
     */
    @Override
    public List<byte[]> popList(final String key) {
        return RedisClientFactory.getBinaryJedisCluster().lrange(key.getBytes(), 0, -1);
    }

    /**
     * Description: <br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param timeout
     * @param key
     * @return <br>
     */
    @Override
    public List<byte[]> pop(final int timeout, final String key) {

        List<byte[]> result = RedisClientFactory.getBinaryJedisCluster().brpop(timeout, key.getBytes());
        if (CollectionUtils.isNotEmpty(result) && result.size() >= 2) {
            result.remove(0);
        }
        return result;
    }
}
