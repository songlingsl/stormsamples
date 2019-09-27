package Lock;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Main1{

    static  JedisClusterConfig config;
    static JedisCluster jedisCluster ;
    static String lockId= UUID.randomUUID().toString();

    public static void main(String[] args) throws Exception{
        String[] serverArray = "127.0.0.1:9000,127.0.0.1:9001,127.0.0.1:9002,127.0.0.1:9003,127.0.0.1:9004,127.0.0.1:9005".split(",");
        Set<HostAndPort> nodes = new HashSet<>();
        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }
//        config = new JedisClusterConfig.Builder().setNodes(nodes)
//                .setMaxRedirections(1)
//                .setTimeout(5000)
//                .build();
        JedisPoolConfig DEFAULT_POOL_CONFIG = new JedisPoolConfig();
        //jedisCluster = new JedisCluster(config.getNodes(), config.getTimeout(), config.getTimeout(), config.getMaxRedirections(), DEFAULT_POOL_CONFIG);
        jedisCluster =new JedisCluster(nodes,DEFAULT_POOL_CONFIG);

        jedisCluster.set("mykey",0+"");//初始0
//        jedisCluster.incrBy("mykey",100);
//        System.out.println( "增加操作"+jedisCluster.get("mykey"));
//
//        jedisCluster.decrBy("mykey",51);
//
//        System.out.println( "减少操作"+jedisCluster.get("mykey"));
        for(int i=0;i<10000;i++){
            jedisCluster.incrBy("mykey",1);
            System.out.println( "不断加一");
            Thread.sleep(5l);
        }
        System.out.println( "不断加一结果 "+jedisCluster.get("mykey"));


//        System.out.println( "获取锁"+lock());
//
//
//        System.out.println( "释放锁"+unlock());
    }

    public static boolean lock(){


        Long start = System.currentTimeMillis();
        long timeout=5000l;
        try{
            for(;;) {
                //SET命令返回OK ，则证明获取锁成功
                String lock = jedisCluster.set("bill_lock_key", lockId, "NX", "PX", timeout);
                if ("OK".equals(lock)) {
                    return true;
                }
                //否则循环等待，在timeout时间内仍未获取到锁，则获取失败
                long l = System.currentTimeMillis() - start;
                if (l >= timeout) {
                    return false;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean unlock(){

        String script =
                "if redis.call('get',KEYS[1]) == ARGV[1] then" +
                        "   return redis.call('del',KEYS[1]) " +
                        "else" +
                        "   return 0 " +
                        "end";
        try {
            Object result = jedisCluster.eval(script, Collections.singletonList("bill_lock_key"),
                    Collections.singletonList(lockId));
            if("1".equals(result.toString())){
                return true;
            }
            return false;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
