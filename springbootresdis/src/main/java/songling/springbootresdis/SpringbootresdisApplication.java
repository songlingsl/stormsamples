package songling.springbootresdis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
@Component
@SpringBootApplication
public class SpringbootresdisApplication {

//    redisTemplate.opsForValue();//操作字符串
//redisTemplate.opsForHash();//操作hash
//redisTemplate.opsForList();//操作list
//redisTemplate.opsForSet();//操作set
//redisTemplate.opsForZSet();//操作有序set
    @Autowired
   public RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;//直接用string也行,序列化方式不同

    public static void main(String[] args) throws Exception{

        SpringApplication.run(SpringbootresdisApplication.class, args);
        SpringbootresdisApplication redis= SpringContextUtil.getBean(SpringbootresdisApplication.class);
        redis.putredis();
    }

    public void putredis() throws Exception {

        System.out.println("有没有"+redisTemplate);
        stringRedisTemplate.opsForValue().set("song","dasd大是大非");




//
//        while(true){
//            Thread.sleep(3000l);
//            String value= (String) stringRedisTemplate.opsForValue().get("song");
//            String ling= (String) stringRedisTemplate.opsForValue().get("ling");
//
//            System.out.println("song值"+value);
//            System.out.println(stringRedisTemplate.hasKey("ling")+"ling值"+ling);
//        }
    }

}
