package com.atguigu.mo;

import com.atguigu.mo.entity.people;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author ：chenming
 * @date ：Created in 2021/4/22 17:18
 * @description：
 * @modified By：
 * @version: $
 */
@SpringBootTest(classes = {application.class})
public class mongoTest {
    @Autowired
    MongoTemplate  mongoTemplate ; 
    @Test
    public void   insert(){
        people p  =new people();
        p.setAge(12);
        p.setName("serfe");
        people insert = mongoTemplate.insert(p);
    }
}
