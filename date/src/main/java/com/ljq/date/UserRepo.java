package com.ljq.date;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : lijq
 * @date : 2020/3/19 10:18
 */
public interface UserRepo extends JpaRepository<UserA,Long> {
}
