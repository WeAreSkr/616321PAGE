package cap.mvc.service;

import cap.mvc.dao.mapper.EventMapper;
import cap.mvc.model.Event;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;

@Service
public class EventService {
    @Resource
    private EventMapper eventMapper;

    public int addEvent(Event event){
        event.setDt(new Date().getTime());
        event.setIspass(0);
       return eventMapper.insert(event);
    }

    public ArrayList<Event> getEvents() {
        return eventMapper.selectPass();
    }
}
