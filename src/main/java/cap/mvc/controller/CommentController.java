package cap.mvc.controller;

import cap.mvc.model.Comment;
import cap.mvc.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class CommentController {

    @Resource
    CommentService commentService;

    @RequestMapping(value = "/authority/0/addcomment",method = RequestMethod.POST)
    public void addComment(HttpServletRequest request, HttpServletResponse response, Comment comment, @RequestParam("tmpStuNmb") Integer tmpStuNmb) {
        System.out.println(comment.getMsg());
        commentService.addComment(comment);
        try {
            response.sendRedirect("/page?stunmb="+tmpStuNmb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/authority/0/delcomment",method = RequestMethod.GET)
    public void delComment(HttpServletRequest request, HttpServletResponse response,Long commentId, @RequestParam("tmpStuNmb") Integer tmpStuNmb) {
        commentService.delComment(commentId);
        try {
            response.sendRedirect("/page?stunmb="+tmpStuNmb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
