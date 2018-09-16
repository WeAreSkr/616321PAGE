package cap.mvc.controller;

import cap.mvc.bean.Msg;
import cap.mvc.model.Classmate;
import cap.mvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
@SessionAttributes("user")
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

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ModelAndView login(Classmate classmate) {
        ModelAndView modelAndView = new ModelAndView("result");
        Classmate res = service.login(classmate);
        if(res == null){
            modelAndView.addObject("msg",new Msg("login",1,"密码错误，或没激活"));
            modelAndView.addObject("user",null);
        }else {
            modelAndView.addObject("user",res);
            modelAndView.addObject("msg",new Msg("login",0,"成功"));
            modelAndView.setViewName("redirect:/tree");
        }
        return modelAndView;
    }
}
