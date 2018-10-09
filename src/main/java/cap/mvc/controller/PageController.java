package cap.mvc.controller;

import cap.LocalConfig;
import cap.mvc.bean.Msg;
import cap.mvc.bean.PageEx;
import cap.mvc.model.Classmate;
import cap.mvc.service.CommentService;
import cap.mvc.service.PageService;
import cap.mvc.service.UserService;
import cap.util.FileName;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class PageController {
@Resource
private PageService pageService;
@Resource
private UserService userService;
@Resource
private CommentService commentService;

    @RequestMapping(value = "page",method = RequestMethod.GET)
    public  String page(Model model, @RequestParam(value = "stunmb",required = false) Integer stuNmb, HttpServletRequest request) {
        if(stuNmb == null ) {
            Classmate curUser = (Classmate) request.getSession().getAttribute("user");

            if(curUser == null){
                model.addAttribute("msg",new Msg("edit page",1,"没有权限修改"));
                return "result";
            }
            PageEx pageEx = pageService.findPageExByStuNmb(curUser.getStuNmb());
            model.addAttribute("page",pageEx);
            model.addAttribute("md",pageService.getMd(curUser.getStuNmb()));
            return "pagemodel/def.edit";
        }else{
                PageEx pageEx = pageService.findPageExByStuNmb(stuNmb);
                model.addAttribute("comments",commentService.findCommentByPage(pageEx.getPageId()));
                model.addAttribute("page",pageService.findPageExByStuNmb(stuNmb));
                model.addAttribute("tmpuser",userService.selectTmpbyKey(stuNmb));
                model.addAttribute("htmlex",pageService.getHtmlEx(stuNmb));
                return "pagemodel/def";
        }
    }

    @RequestMapping(value = "page",method = RequestMethod.POST)
    public String page(Model model, PageEx pageEx,
                       @RequestParam("htmlex") String htmlex,
                       @RequestParam("md") String md,
                       @RequestParam(value = "dsc", required = false) String dsc,
                       @RequestParam(value = "headimg", required = false) MultipartFile headimg,
                       HttpServletRequest request){

        Msg msg = new Msg();
        msg.setCode(0);
        msg.setRedirect("/page");
        msg.setTitle("编辑主页");
        msg.setMsg("更新：");


        String fileName = "";
        if(headimg != null) {
            synchronized (fileName) {
                fileName = FileName.getSuitableName(LocalConfig.getPathImghead(), ".jpg");
                if (fileName == null) {
                    msg.setCode(1);
                    msg.setMsg("无法创建图片文件");
                } else if (headimg.getSize() == 0) {
                    fileName = null; //如果为null就不保存
                } else {
                    File targetFile = new File(LocalConfig.getPathImghead() + fileName);
                    File targetFileScale = new File(LocalConfig.getPathImghead() + fileName + ".jpg");//保存压缩图
                    try {
                        Thumbnails.of(headimg.getInputStream()).size(320, 240).toFile(targetFileScale);
                        headimg.transferTo(targetFile);
                    } catch (IOException e) {
                        fileName = null;
                        e.printStackTrace();
                    }
                }
            }
        }


        Classmate classmate = (Classmate) request.getSession().getAttribute("user");
        pageService.updatePageEx(pageEx,classmate);
        pageService.updateHtmlEx(classmate.getStuNmb(),htmlex);
        pageService.updateMd(classmate.getStuNmb(),md);
        msg.setRedirect("/page");
        model.addAttribute("msg",msg);
        if(fileName != null && userService.updateHead(classmate.getStuNmb(), fileName)>0) {
            msg.setMsg(msg.getMsg()+"\n成功更新头像。");
        }
        if (userService.updateDesc(classmate.getStuNmb(),dsc)>0){
            msg.setMsg(msg.getMsg()+"\n成功更新个性签名。");
        }

        /**
         * 更新当前session
         */
        classmate = userService.selectTmpbyKey(classmate.getStuNmb());
        request.getSession().setAttribute("user",classmate);

        return "result";
    }
}
