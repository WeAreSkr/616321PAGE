package cap.mvc.dao.mapper;

import cap.mvc.dao.mapper.custom.CustomClassmateMapper;
import cap.mvc.model.Classmate;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassmateMapper extends CustomClassmateMapper{

    int deleteByPrimaryKey(Integer stuNmb);

    int insert(Classmate record);

    int insertSelective(Classmate record);

    Classmate selectByPrimaryKey(Integer stuNmb);

    int updateByPrimaryKeySelective(Classmate record);

    int updateByPrimaryKey(Classmate record);
}