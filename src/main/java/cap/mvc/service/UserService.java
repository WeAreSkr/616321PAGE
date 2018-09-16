package cap.mvc.service;

import cap.mvc.bean.Msg;
import cap.mvc.dao.mapper.ClassmateMapper;
import cap.mvc.model.Classmate;
import cap.util.MD5;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private ClassmateMapper classmateMapper;

    public List<String> findNoPwdNames() {
        return classmateMapper.findNoPwdNames();
    }

    public Msg register(Classmate classmate,String rePwd) {
        Msg msg = null;
        if(rePwd!=null && rePwd.equals(classmate.getPwd()) ){
            classmate.setPwd(MD5.md5(classmate.getPwd()));
           int count =  classmateMapper.addPwd(classmate);
           if(count < 1) {
               msg = new Msg("register",1,"失败，可能是已经注册，请联系管理员");
           }
           else {
               msg = new Msg("register", 0, "成功");
           }
        }else {
            msg = new Msg("register", 1, "再次密码不同");
        }
        return  msg;
    }

    public Classmate login(Classmate classmate) {
        if(classmate == null) return  null;
        Classmate res  = classmateMapper.selectByPrimaryKey(classmate.getStuNmb());
        if(res.getPwd() != null && MD5.md5(classmate.getPwd()).equals(res.getPwd())) {
            return res;
        }else {
            return null;
        }
    }

}