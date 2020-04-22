package com.ljq.mybatisplus.controller;

import com.ljq.common.ret.Result;
import com.ljq.mybatisplus.entity.User;
import com.ljq.mybatisplus.util.SpringUtil;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author : lijq
 * @date : 2020/4/4 18:01
 */
@RestController
public class TestController {
//    @Autowired
//    private UserSender userSender;

    @GetMapping
    public Result getUser() {
        User user = (User) SpringUtil.getBean("user");
        return Result.success(user);
    }
//
//    @PostMapping("/add")
//    public Result addUser(@RequestBody User user) {
//
//        userSender.userAdd(JSON.toJSONString(user));
//
//        return Result.success("");
//    }
//
//    @PostMapping("/add1")
//    public Result addUser1(@RequestBody User user) {
//        MessageExt messageExt = new MessageExt();
//        messageExt.setBody(JSON.toJSONString(user).getBytes());
//        userSender.userAdd1(messageExt);
//        return Result.success("");
//    }
    @GetMapping("/test/1")
    public void  view(HttpServletResponse response) throws IOException {

        response.setContentType("image/png");
        String filePath="F:\\1.png";
        FileCopyUtils.copy(new FileInputStream(filePath),response.getOutputStream());
    }
}
