package test;

import cap.mvc.dao.mapper.ClassmateMapper;
import cap.mvc.model.Classmate;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestDatasource {
    private SqlSessionFactory sessionFactory;
    @Before
    public void init() {
        try {
            String resource = "mybatis-conf.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public  void  testClassmate() {
        SqlSession sqlSession = sessionFactory.openSession();

        ClassmateMapper  oc = sqlSession.getMapper(ClassmateMapper.class);
        List<Classmate> list = oc.findAllClassmate();
        System.out.println("ClassmateMapper.findAllClassmate:"+list);
        sqlSession.close();
    }
}
