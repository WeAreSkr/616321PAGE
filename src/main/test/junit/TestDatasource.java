package junit;

import cap.mvc.dao.mapper.ClassmateMapper;
import cap.mvc.dao.mapper.PageMapper;
import cap.mvc.model.Classmate;
import cap.mvc.model.association.PageAs;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestDatasource {
    private SqlSessionFactory sessionFactory;
    private SqlSession sqlSession;

    @Before
    public void init() {
        try {
            String resource = "mybatis-conf.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public  void  testClassmate() {

        ClassmateMapper classmateMapper = sqlSession.getMapper(ClassmateMapper.class);
        List<Classmate> list = classmateMapper.findAllClassmate();
        System.out.println("ClassmateMapper.findAllClassmate:"+list);
    }


    @Test
    public void textPageAs() {
        PageMapper pageMapper = sqlSession.getMapper(PageMapper.class);
        PageAs pageAs = pageMapper.asSelectById(14L);
        System.out.println("pageMapper.asSelectById(14L):"+pageAs.toString());
    }

    @After
    public void  clear() {
         if (sqlSession != null)sqlSession.close();
    }
}
