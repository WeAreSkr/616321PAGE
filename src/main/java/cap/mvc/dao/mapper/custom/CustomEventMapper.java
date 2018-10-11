package cap.mvc.dao.mapper.custom;

import cap.mvc.model.wrapper.EventWrapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository

public interface CustomEventMapper{
    ArrayList<EventWrapper> selectPass();
    ArrayList<EventWrapper> selectNoPass();
    ArrayList<EventWrapper> selectNoDel();
}