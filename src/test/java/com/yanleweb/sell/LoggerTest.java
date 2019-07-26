package com.yanleweb.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
//    这种方式稍显麻烦 有更加简单的办法 ， 见lombok, 当然还需要下载一个idea 的插件
//    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1() {
//        logger.debug("debug...");
//        logger.info("info...");
//        logger.error("error");

        String name ="yanle";
        String password = "yanle123";
        log.debug("debug...");
        log.info("name: {}, password: {}", name, password);
        log.info("info...");
        log.error("error");
    }
}
