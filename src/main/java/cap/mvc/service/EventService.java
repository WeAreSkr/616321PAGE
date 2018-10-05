package cap.mvc.service;

import cap.mvc.dao.mapper.EventMapper;
import cap.mvc.model.Event;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EventService {
    @Resource
    private EventMapper eventMapper;

    public int addEvent(Event event){
        event.setDt(new Date().getTime());
        event.setIspass(0);
       return eventMapper.insert(event);
    }

    public ArrayList<Event> getPassEvents() {
        return eventMapper.selectPass();
    }
    public ArrayList<Event> getNoPassEvents() {
        return eventMapper.selectNoPass();
    }
    public ArrayList<Event> getAllEvents() {
        return eventMapper.selectNoDel();
    }

    public int setPass(List<Event> eventList){
       int count  = 0;
       for(Event event:eventList)
           count += eventMapper.updateByPrimaryKeySelective(event);
       return  count;
    }

}
