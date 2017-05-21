package cn.wenjun.learning;

import cn.wenjun.learning.dao.BlogDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class App {

    public static void main(String args[]) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        BlogDAO mapper = session.getMapper(BlogDAO.class);
        Blog blog = mapper.selectBlog(1);

        System.out.print(blog);
    }
}
