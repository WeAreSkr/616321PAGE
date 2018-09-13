package cap.mvc.dao.mapper;

import cap.mvc.model.Event;

public interface EventMapper {
    int deleteByPrimaryKey(Integer code);

    int insert(Event record);

    int insertSelective(Event record);

    Event selectByPrimaryKey(Integer code);

    int updateByPrimaryKeySelective(Event record);

    int updateByPrimaryKey(Event record);
}