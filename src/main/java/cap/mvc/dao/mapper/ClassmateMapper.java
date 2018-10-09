package cap.mvc.dao.mapper;

import cap.mvc.model.Classmate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassmateMapper {
    int deleteByPrimaryKey(Integer stuNmb);

    int insert(Classmate record);

    int insertSelective(Classmate record);

    Classmate selectByPrimaryKey(Integer stuNmb);

    int updateByPrimaryKeySelective(Classmate record);

    int updateByPrimaryKey(Classmate record);

    List<String> findNoPwdNames();

    int addPwd(Classmate pwd);

    List<Classmate> findActClassmate();
    List<Classmate> findAllClassmate();
}