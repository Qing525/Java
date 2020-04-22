package com.ljq.date;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : lijq
 * @date : 2020/3/19 10:18
 */
@Data
@Entity
@Table(name = "user2")
public class UserA {
    @Id
    private Long id;

    private String name;

}
