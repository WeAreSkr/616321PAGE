package cap.mvc.controller;

import cap.mvc.bean.Msg;
import cap.mvc.bean.PageEx;
import cap.mvc.model.Classmate;
import cap.mvc.service.PageService;
import cap.mvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class PageController {
@Resource
private PageService pageService;
@Resource
private UserService userService;
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public  String page(Model model, @RequestParam(value = "stunmb",required = false) Integer stuNmb, HttpServletRequest request) {
        if(stuNmb == null ) {
            Classmate classmate = (Classmate) request.getSession().getAttribute("user");

            if(classmate == null){
                model.addAttribute("msg",new Msg("edit page",1,"没有权限修改"));
                return "result";
            }

            model.addAttribute("page",pageService.findPageExByStuNmb(classmate.getStuNmb()));
            model.addAttribute("md",pageService.getMd(classmate.getStuNmb()));
            return "pagemodel/def.edit";
        }else{
                model.addAttribute("page",pageService.findPageExByStuNmb(stuNmb));
                model.addAttribute("tmpuser",userService.selectTmpbyKey(stuNmb));
                model.addAttribute("htmlex",pageService.getHtmlEx(stuNmb));
                return "pagemodel/def";
        }
    }

    @RequestMapping(value = "page",method = RequestMethod.POST)
    public String page(Model model,PageEx pageEx,@RequestParam("htmlex") String htmlex,@RequestParam("md") String md, HttpServletRequest request){
        Msg msg = new Msg();
        msg.setCode(0);
        msg.setRedirect("/");
        msg.setTitle("编辑主页");
        msg.setMsg("更新成功");
        model.addAttribute("msg",msg);
        Classmate classmate = (Classmate) request.getSession().getAttribute("user");
        pageService.updatePageEx(pageEx,classmate);
        pageService.updateHtmlEx(classmate.getStuNmb(),htmlex);
        pageService.updateMd(classmate.getStuNmb(),md);
        return "result";
    }
}
