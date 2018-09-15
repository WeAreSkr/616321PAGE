package cap.mvc.controller;

import cap.mvc.model.Classmate;
import cap.mvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")
public class UserController {
    @Resource
    private UserService service;

    @RequestMapping(value = "register",method = RequestMethod.GET)
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("names",service.findNoPwdNames());
        return modelAndView;
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public ModelAndView register(Classmate classmate, @RequestParam String rePwd){
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("msg",service.register(classmate,rePwd));
        return modelAndView;
    }
}
