package cap.mvc.controller;

import cap.LocalConfig;
import cap.mvc.bean.Msg;
import cap.mvc.model.Event;
import cap.mvc.service.EventService;
import cap.util.FileName;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class EventController {
    @Resource
    public EventService eventService;

    @RequestMapping(value = "/authority/0/addevent",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public ModelAndView addEvent(@Valid Event event, BindingResult result, @RequestParam(value = "imgs", required = true) MultipartFile[] files) {
        if(result.hasErrors()) {
            return new ModelAndView("addevent");
        }

        ModelAndView modelAndView = new ModelAndView("result");
        Msg msg = new Msg("上传文件",0,"上传应该是成功的 :-)");
        String[] fileNames = new String[files.length];
        for(int i = 0; i< files.length; i++) {
            fileNames[i] = FileName.getSuitableName(LocalConfig.getPathImgsEvent(),".jpg");
            if(fileNames[i] == null) {
                msg.setCode(1);
                msg.setMsg("无法创建图片文件");
            }else if ( files[i].getSize() == 0){
                fileNames[i] =null; //如果为null就不保存
            }  else{
                File targetFile = new File(LocalConfig.getPathImgsEvent() + fileNames[i]);
                try {
                    files[i].transferTo(targetFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        event.setImgagesPath(FileName.mgStr(fileNames));
        eventService.addEvent(event);
        modelAndView.addObject("msg",msg);
        return modelAndView;
    }

    @RequestMapping(value = "/authority/0/addevent",method = RequestMethod.GET)
    public String addEvent(Model model ,Event event){
        event.setEditor("LiuBailin");
        model.addAttribute("event",event);
        return "addevent";
    }



    /**
     * 班级志
     * @return
     */
    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public ModelAndView tree(){
        ModelAndView modelAndView = new ModelAndView("tree");
        List<Event> eventList = eventService.getPassEvents();
        modelAndView.addObject("events",eventList);
        return  modelAndView;
    }

    @RequestMapping(value = "/authority/1/pass",method = RequestMethod.GET)
    public String authorizePass(Model model) {
        List<Event> eventList = eventService.getNoPassEvents();
        model.addAttribute("nopassevents",eventList);
        return "authority/1/pass";
    }

    @RequestMapping(value = "/authority/1/pass",method = RequestMethod.POST)
    public String authorizePass(Model model,@RequestParam(value = "code",required = false) Integer[] codes) {
        Msg msg = new Msg();
        msg.setMsg("通过条数："+eventService.setPass(codes));
        msg.setCode(0);
        msg.setTitle("核审结果");
        model.addAttribute("msg",msg);
       return "result";
    }
}
