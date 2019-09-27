package Lock;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;


public class Pubsub {

    static  JedisClusterConfig config;
    static JedisCluster jedisCluster ;

    public static void main(String[] args) throws InterruptedException {

        String[] serverArray = "127.0.0.1:9000,127.0.0.1:9001,127.0.0.1:9002,127.0.0.1:9003,127.0.0.1:9004,127.0.0.1:9005".split(",");
        Set<HostAndPort> nodes = new HashSet<>();
        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }
        JedisPoolConfig DEFAULT_POOL_CONFIG = new JedisPoolConfig();
        jedisCluster =new JedisCluster(nodes,DEFAULT_POOL_CONFIG);
        Set set =new HashSet();
        set.add("aaa");

//        new Thread(){
//            public void run(){
//                jedisCluster.subscribe(new Mysub(),"channel");
//            }
//
//        }.start();

        ArrayBlockingQueue queue=new ArrayBlockingQueue(50);

        jedisCluster.publish("channel","aa");


        jedisCluster.publish("channel","aa");
        jedisCluster.publish("channel","aa");
    }
}
