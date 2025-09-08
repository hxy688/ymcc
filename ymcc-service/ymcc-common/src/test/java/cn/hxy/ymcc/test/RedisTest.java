package cn.hxy.ymcc.test;

import cn.hxy.ymcc.CommonApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = CommonApp.class)
@RunWith(SpringRunner.class)
public class RedisTest {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Test
    public void test(){
        redisTemplate.opsForValue().set("test","666666");
        System.out.println(redisTemplate.opsForValue().get("test"));
    }
}
