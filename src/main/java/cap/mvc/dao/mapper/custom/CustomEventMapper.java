package cap.mvc.dao.mapper.custom;

import cap.mvc.model.Event;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository

public interface CustomEventMapper{

    ArrayList<Event> selectPass();
    ArrayList<Event> selectNoPass();
    ArrayList<Event> selectNoDel();
}