package com.garment.dapei;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =DapeiApplication.class)

class DapeiApplicationTests {

    @Test
    void contextLoads() {
    }
    @Before
    public void init(){
        System.out.println("测试开始-------------------");
    }
    @After
    public void after(){
        System.out.println("测试结束-------------------");
    }

}
