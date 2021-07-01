package com.alizhifu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：chenming
 * @date ：Created in 2021/4/28 9:34
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class IndexController {
   @GetMapping("/index")
    public  String    index(){
        return  "index";
    }
}
