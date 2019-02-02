package cap.mvc.controller;

import cap.LocalConfig;
import cap.mvc.bean.Msg;
import cap.mvc.dao.mapper.CommentsMapper;
import cap.mvc.model.Classmate;
import cap.mvc.model.Event;
import cap.mvc.model.wrapper.EventWrapper;
import cap.mvc.service.CounterService;
import cap.mvc.service.EventService;
import cap.mvc.service.MainPageService;
import cap.util.FileName;
import com.alibaba.fastjson.JSONObject;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class EventController {

    @Resource
    public EventService eventService;
    @Resource
    public MainPageService mainPageService;
    @Resource
    public CounterService counterService;
    @RequestMapping(value = "/authority/0/addevent",method = RequestMethod.POST)
    public ModelAndView addEvent(Event event,
                                 @RequestParam("year") Integer year,
                                 @RequestParam("month") Integer month,
                                 @RequestParam("day") Integer day ,
                                 @RequestParam(value = "imgs", required = false) MultipartFile[] files) {

        ModelAndView modelAndView = new ModelAndView("result");
        Msg msg = new Msg("上传文件",0,"");
        String[] fileNames = null;
        int count = 0;

        if(files != null) {
            fileNames = new String[files.length];
            for (int i = 0; i < files.length; i++) {
                fileNames[i] = FileName.getSuitableName(LocalConfig.getPathImgsEvent(), ".jpg");
                if (fileNames[i] == null) {
                    msg.setCode(1);
                    msg.setMsg("无法创建图片文件");
                } else if (files[i].getSize() == 0) {
                    fileNames[i] = null; //如果为null就不保存
                } else {
                    File targetFile = new File(LocalConfig.getPathImgsEvent() + fileNames[i]);
                    File targetFileScale = new File(LocalConfig.getPathImgsEvent() + fileNames[i] + ".jpg");
                    try {
                        Thumbnails.of(files[i].getInputStream()).size(320, 240).toFile(targetFileScale);
                        files[i].transferTo(targetFile);
                        count++;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        msg.setMsg("上传成功，请等待班长审核通过\n" +
                "上传图片："+count+"张");
        event.setImgagesPath(FileName.mgStr(fileNames));
        eventService.addEvent(event,year,month,day);
        modelAndView.addObject("msg",msg);
        return modelAndView;
    }

    @RequestMapping(value = "/authority/0/addevent",method = RequestMethod.GET)
    public String addEvent(Model model , Event event, HttpServletRequest request, HttpServletResponse response){
        Classmate classmate = (Classmate) request.getSession().getAttribute("user");
        if(classmate != null) {
            event.setEditor(classmate.getName());
        }
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
        List<EventWrapper> eventList = eventService.getPassEvents();
        modelAndView.addObject("events",eventList);
        modelAndView.addObject("daycount",mainPageService.getDayCount());
        modelAndView.addObject("daysentence",mainPageService.getSentence());
        modelAndView.addObject("count",counterService.getCount());
        return  modelAndView;
    }

    @RequestMapping(value = "/authority/1/pass",method = RequestMethod.GET)
    public String authorizePass(Model model) {
        List<EventWrapper> eventList = eventService.getAllEvents();
        model.addAttribute("nopassevents",eventList);
        return "authority/1/pass";
    }

    /**
     * 这里处理得有些牵强
     *  d 类似于这样的数组   ["'code1':'0' , 'code2':'1' .......]
     *  然后用 toj 包装成json格式，再解析。
     * @param d
     * @return
     */
    private String toj(String[] d) {
        String json = "{";
        for(int i =0; i< d.length -1;i++){
            json+=d[i]+",";
        }
        json += (d[d.length-1]+"}");
        return  json;
    }
    @RequestMapping(value = "/authority/1/pass",method = RequestMethod.POST)
    public String authorizePass(Model model,@RequestParam(value = "code",required = false) String[] d) {
        String json = toj(d);
        JSONObject object = (JSONObject) JSONObject.parse(json);
        int count = 0 ;
        Msg msg = new Msg();
        List<EventWrapper> eventList = eventService.getAllEvents();
        List<Event> listBk = new ArrayList<>();

        for(EventWrapper event: eventList) {
            int ispass = Integer.parseInt((String) object.get("code"+event.getCode()));
            if(ispass != event.getCode()){
                Event ebk = new Event();
                ebk.setCode(event.getCode());
                ebk.setIspass(ispass);
                listBk.add(ebk);
            }
        }
        count = eventService.setPass(listBk);
        msg.setCode(0);
        msg.setMsg("修改:"+count+"条");
        msg.setTitle("核审结果");
        model.addAttribute("msg",msg);
        return "result";
    }
}
