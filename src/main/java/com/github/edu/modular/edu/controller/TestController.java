package com.github.edu.modular.edu.controller;

import com.github.edu.core.util.JsonUtil;
import com.github.edu.modular.edu.socket.WebSocketServer;
import com.github.edu.modular.edu.util.ExceptionUtil;
import com.github.edu.modular.edu.util.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Random;

@Controller
@RequestMapping("/test")
public class TestController {

    private static String PREFIX = "/code";

    @RequestMapping("")
    public String index() {
       return "/test.html";
    }

    @RequestMapping("socket")
    public String test() {
        return "/socket/test.html";
    }

    @RequestMapping("send")
    @ResponseBody
    public Object send(String sid) throws IOException {
        R r = new R();
        try {
            WebSocketServer.sendInfo("全体广播了！！！" + new Random().nextInt(), sid);
            return JsonUtil.createOkJson();

        } catch (Exception e) {
            r = ExceptionUtil.getException(e);
        }

        return r;
    }
}
