package cn.wenjun.learning;

import cn.wenjun.learning.dao.BlogDAO;
import cn.wenjun.learning.services.BlogService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class App {

    private BlogService blogService = new BlogService();

    private SqlSession getSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        return session;
    }


    @RequestMapping("/blogs")
    @ResponseBody
    List<Blog> getAllBlog() throws IOException {
        SqlSession session = getSession();
        BlogDAO blogDAO = session.getMapper(BlogDAO.class);

        blogService.setBlogDAO(blogDAO);

        return blogService.getAll();
    }

    public static void main(String args[]) throws IOException {
        SpringApplication.run(App.class, args);
    }
}
