package songling.springclusterredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class SpringclusterredisApplication {

    @Autowired
    public RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;//直接用string也行,序列化方式不同

    public static void main(String[] args) throws Exception{

        SpringApplication.run(SpringclusterredisApplication.class, args);
        SpringclusterredisApplication redis= SpringContextUtil.getBean(SpringclusterredisApplication.class);
        redis.putredis();
    }

    public void putredis() throws Exception {


        stringRedisTemplate.opsForValue().set("song","dasd大是大非");
        System.out.println("有没有4"+ stringRedisTemplate.opsForValue().get("song"));


    }
    public void pubsub() throws Exception {//测试发布订阅



    }
}
