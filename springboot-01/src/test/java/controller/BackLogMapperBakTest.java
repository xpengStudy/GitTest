package controller;

import com.xp.springboot01.Springboot01Application;
import com.xp.springboot01.domian.BackLog;
import com.xp.springboot01.mapper.BackLogMapper_bak;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot01Application.class)
public class BackLogMapperBakTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private BackLogMapper_bak backLogMapperBak;


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void insertBackLog() {
        BackLog backLog =  new BackLog();
        backLog.setLogName("待办test02");
        backLog.setCompleteDate(new Date());
        backLog.setIsComplete(true);
        backLog.setLogType(3);
        backLog.setCreateDate(new Date());
        backLogMapperBak.insertBackLog(backLog);
    }

    @Test
    public void deleteBackLogById() {

    }

    @Test
    public void findAllBack(){
        System.out.println(backLogMapperBak.findAllBackLog());

    }


    @Test
    public void updateBackLog(){

        BackLog backLog =  new BackLog();
        backLog.setId(2);
        backLog.setLogName("待办test03");
        backLog.setCompleteDate(new Date());
        backLog.setIsComplete(true);
        backLog.setLogType(3);
        backLogMapperBak.updateBackLog(backLog);

    }

}