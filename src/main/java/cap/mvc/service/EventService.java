package cap.mvc.service;

import cap.mvc.dao.mapper.EventMapper;
import cap.mvc.model.Event;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public int addEvent(Event event,int year,int month,int day){
        String str = year+"-"+month+"-" +day ;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            event.setDt(sdf.parse(str).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
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
