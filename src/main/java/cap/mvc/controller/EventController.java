package cap.mvc.controller;

import cap.LocalConfig;
import cap.mvc.bean.Msg;
import cap.mvc.model.Event;
import cap.mvc.service.EventService;
import cap.util.FileName;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EventController {
    @Resource
    public EventService eventService;

    @RequestMapping(value = "/addevent",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public ModelAndView addEvent(Event event,@RequestParam(value = "imgs", required = true) MultipartFile[] files) {
        ModelAndView modelAndView = new ModelAndView("result");
        Msg msg = new Msg();
        String[] fileNames = new String[files.length];
        for(int i = 0; i< files.length; i++) {
            fileNames[i] = FileName.getSuitableName(LocalConfig.getPathImgsEvent(),".jpg");
            if(fileNames[i] == null) {
                msg.setCode(1);
                msg.setMsg("无法创建图片文件");
            }else{
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

    /**
     * 班级志
     * @return
     */
    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public ModelAndView tree(){
        ModelAndView modelAndView = new ModelAndView("tree");
        List<Event> eventList = eventService.getEvents();
        modelAndView.addObject("events",eventList);
        return  modelAndView;
    }

}
