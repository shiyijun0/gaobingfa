package cn.bdqn.gaobingfa.jdbc;

import cn.bdqn.gaobingfa.entity.Role;
import cn.bdqn.gaobingfa.mapper.RoleDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class mapper {
   public  void  test(){

       InputStream inputStream= null;
       try {
           inputStream = Resources.getResourceAsStream("usr");
       } catch (IOException e) {
           e.printStackTrace();
       } finally {

       }
       SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=null;
        //打开回话
       sqlSession= sqlSessionFactory.openSession();
       RoleDao roleDao=  sqlSession.getMapper(RoleDao.class);
       Role role=roleDao.getRole(1l);

       sqlSession.close();
    }
}
