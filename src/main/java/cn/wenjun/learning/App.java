package cn.wenjun.learning;

import cn.wenjun.learning.dao.BlogDAO;
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

@Controller
@EnableAutoConfiguration
public class App {

    private static Blog getBlog() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        BlogDAO mapper = session.getMapper(BlogDAO.class);
        Blog blog = mapper.selectBlog(1);

        return blog;
    }

    @RequestMapping("/blogs")
    @ResponseBody
    Blog findBlog() throws IOException {
        return getBlog();
    }

    public static void main(String args[]) throws IOException {
        SpringApplication.run(App.class, args);
    }
}
