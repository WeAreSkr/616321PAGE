package cap.mvc.dao.mapper.custom;

import cap.mvc.model.Classmate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomClassmateMapper  {

    List<String> findNoPwdNames();
    int addPwd(Classmate pwd);
    List<Classmate> findActClassmate();
    List<Classmate> findAllClassmate();
}