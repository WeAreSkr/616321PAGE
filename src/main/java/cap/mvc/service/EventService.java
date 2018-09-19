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

    public ArrayList<Event> getPassEvents() {
        return eventMapper.selectPass();
    }
    public ArrayList<Event> getNoPassEvents() {
        return eventMapper.selectNoPass();
    }

    public int setPass(Integer[] code){
        if(code == null) return  0;
        Event event = new Event();
        int count = 0;
        for(int i= 0; i< code.length;i++) {
            event.setCode(code[i]);
            event.setIspass(1);
            eventMapper.updateByPrimaryKeySelective(event);
                event.setCode(null);
                event.setIspass(null);
            count ++;
        }
        return  count;
    }

}
