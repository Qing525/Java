package com.ljq.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
@Autowired
  private    RedisTemplate redisTemplate;


@GetMapping(value = "/test")

    public String test(){

    redisTemplate.opsForValue().set("111","111111111");

    String s= String.valueOf(redisTemplate.opsForValue().get("111"));


    return s;

}
}
