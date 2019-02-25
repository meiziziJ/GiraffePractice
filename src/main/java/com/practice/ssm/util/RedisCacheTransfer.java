package com.practice.ssm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisCacheTransfer {
    /**
     * 获取redisTemplate
     *    为什么注入redisTemplate，跟hibernate同样的性质，hibernate只有hibernateTemplate才能操作数据库，
     *  那redis也只有redisTemplate才能操作数据库
     * @param redisTemplate
     */
    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisCache.setRedisTemplate(redisTemplate);
    }
}
