package cap.mvc.service;

import cap.mvc.dao.mapper.EventMapper;
import cap.mvc.model.Event;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServices {
    @Resource
    private EventMapper eventMapper;

    public int addEvent(){
        Event event = new Event();
        event.setTitle("hello");
        event.setCode(100);
       return eventMapper.insert(event);
    }
}
