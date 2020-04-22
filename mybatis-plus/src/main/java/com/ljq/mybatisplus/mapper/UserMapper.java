package com.ljq.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljq.mybatisplus.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author : lijq
 * @date : 2020/3/30 9:50
 */
@Repository
//@CacheNamespace(implementation = MPCache.class,eviction = MPCache.class)
public interface UserMapper extends BaseMapper<User> {
}
