package com.htzw.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**测试系统性能
 * Created by Administrator on 2018/9/27.
 * @author glj
 */
@RestController
public class GreekController {
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(){
        return "Hello Greek!";
    }
}
