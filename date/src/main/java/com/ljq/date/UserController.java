package com.ljq.date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : lijq
 * @date : 2020/3/8 13:42
 */
@RestController
public class UserController {
    @Autowired
    StringRedisTemplate redisTemplate;
  //  private static Redisson redisson = RedissonManager.getRedisson();

    public static final String SHARE = "share:user:poscx:";
//    @GetMapping("/test")
//    public String xx(@RequestBody User user) {
//
//        System.out.println(user.getCreateTime());
//
//        return "succ";
//    }

//    @GetMapping("/test")
//    public String redisTest() {
//        RLock lock = redisson.getLock("key");
//        try {
//
//            lock.tryLock(1, TimeUnit.SECONDS);
//            String s = redisTemplate.opsForValue().get(SHARE);
//            if (!StringUtils.isEmpty(s)) {
//                // int i=Integer.parseInt(s);
//                redisTemplate.opsForValue().increment(SHARE);
//                if (Integer.parseInt(redisTemplate.opsForValue().get(SHARE)) > 60) {
//                    System.out.println(1);
//                }
//            } else {
//                redisTemplate.opsForValue().increment(SHARE);
//            }
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//
//        return "succ";
//    }
//
//    @GetMapping("/test1")
//    public String redisTest1() {
//        RLock lock = redisson.getLock("key");
//        try {
//            lock.lock(1, TimeUnit.SECONDS);
//            redisTemplate.opsForValue().increment("s39");
//            if (Integer.parseInt(redisTemplate.opsForValue().get("s39")) > 60) {
//                System.out.println(111);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//
//
//        return "s";
//    }

    @GetMapping("/test111")
    public String xx(HttpServletResponse response) throws IOException {

        //response.sendRedirect("");

       // return "123";
        return "https://open.weixin.qq.com/connect/qrconnect?appid=wx4530e35e8a9fc5cd&redirect_uri=https%3A%2F%2Fportal.mogu.com%2Fuser%2Fthirdtransfer%3Fthird%3Dweixin%26platform%3Dpc&response_type=code&scope=snsapi_login&state=TASi5bxely0v8u4";
    }
}
