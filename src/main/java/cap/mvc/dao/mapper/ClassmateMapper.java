package cap.mvc.dao.mapper;

import cap.mvc.model.Classmate;

public interface ClassmateMapper {
    int deleteByPrimaryKey(Integer stuNmb);

    int insert(Classmate record);

    int insertSelective(Classmate record);

    Classmate selectByPrimaryKey(Integer stuNmb);

    int updateByPrimaryKeySelective(Classmate record);

    int updateByPrimaryKey(Classmate record);
}