package com.ljq.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : LJQ
 * @date : 2019/8/8 20:07
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String xx() {

        return "index";
    }
}
