package cap.mvc.dao.mapper.custom;

import cap.mvc.model.ex.EventEx;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository

public interface CustomEventMapper{

    ArrayList<EventEx> selectPass();
    ArrayList<EventEx> selectNoPass();
    ArrayList<EventEx> selectNoDel();
}