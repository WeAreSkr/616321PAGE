package cap.mvc.dao.mapper;

import cap.mvc.dao.mapper.custom.CustomEventMapper;
import cap.mvc.model.Event;
import org.springframework.stereotype.Repository;
@Repository

public interface EventMapper extends CustomEventMapper{
    int deleteByPrimaryKey(Integer code);

    int insert(Event record);

    int insertSelective(Event record);

    Event selectByPrimaryKey(Integer code);

    int updateByPrimaryKeySelective(Event record);

    int updateByPrimaryKey(Event record);

}