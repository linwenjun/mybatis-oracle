package cn.wenjun.learning;

import cn.wenjun.learning.util.CommonOperations;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.destination.Destination;
import com.ninja_squad.dbsetup.generator.ValueGenerators;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.util.Date;

import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppTest implements ApplicationContextAware {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private ApplicationContext applicationContext;
    private static DbSetupTracker TRACKER = new DbSetupTracker();

    @Before
    public void before() {
        DbSetup setup = new DbSetup(getDsetination(),
                sequenceOf(
                        CommonOperations.DELETE_ALL,
                        insertInto("BLOG")
                                .withGeneratedValue("ID", ValueGenerators.sequence().startingAt(1l))
                                .withGeneratedValue("NAME", ValueGenerators.stringSequence("wangpu-").startingAt(4l))
                                .withGeneratedValue("UPDATE_AT", ValueGenerators.dateSequence())
                                .repeatingValues().times(100)
                                .build()
                )
        );

        setup.launch();
    }

    private Destination getDsetination() {
        DataSource ds = (DataSource) applicationContext.getBean("dataSource");
        return DataSourceDestination.with(ds);
    }

    @Test
    public void contextLoad() throws Exception {
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port +"/blogs", String.class))
                .contains("first");
    }

    @Test
    public void first_test_for_common_use() {
        TRACKER.skipNextLaunch();
        Assertions.assertThat(true).isTrue();
    }

    @Test
    public void second_test_for_create_db() {
        TRACKER.skipNextLaunch();
        Assertions.assertThat(true).isTrue();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}