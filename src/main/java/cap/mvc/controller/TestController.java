package cap.mvc.controller;

import cap.mvc.service.TestServices;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class TestController {
    @Resource
    public TestServices services;
    @RequestMapping("test")
    public String testInsert() {
        services.addEvent();
     return "test";
    }
}
