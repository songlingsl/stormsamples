package Lock;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.*;

public class MainTestMap {
    static  JedisClusterConfig config;
    static JedisCluster jedisCluster ;

    public static void main(String[] args) {
        String[] serverArray = "127.0.0.1:9000,127.0.0.1:9001,127.0.0.1:9002,127.0.0.1:9003,127.0.0.1:9004,127.0.0.1:9005".split(",");
        Set<HostAndPort> nodes = new HashSet<>();
        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }
        JedisPoolConfig DEFAULT_POOL_CONFIG = new JedisPoolConfig();
        jedisCluster =new JedisCluster(nodes,DEFAULT_POOL_CONFIG);

        Map<String,String> map=new HashMap<>();
        map.put("138001-type1","138001");
        map.put("138002-type1","138002");
        map.put("138003-type1","138003");
        map.put("138001-type2","138001");
        map.put("138001-type3","138001");
        jedisCluster.hmset("blacklist_0",map);
        Map<String,String> newmap=new HashMap<>();
        newmap.put("138001-type4","138001");
        jedisCluster.hmset("blacklist_0",newmap);


        map=jedisCluster.hgetAll("blacklist_0");
        System.out.println("得到的map"+map);
        String[] sss=new String[map.size()];
        map.keySet().toArray(sss);
        System.out.println("得到的map的key的string【】"+sss[0]);

        String get1=jedisCluster.hget("blacklist_0","138001-type1");
        System.out.println("得到其中准备的一个key值"+get1);

        List<String> list= jedisCluster.hmget("blacklist_0","138001-type1","138001-type3","none","138001-type2");//取两个值
        System.out.println("两个值"+list);

         jedisCluster.hdel("blacklist_0","138001-type1");
         String[] ss={"138001-type1","138001-type3","none","138001-type2"};
        list= jedisCluster.hmget("blacklist_0",ss);//取两个值
        System.out.println("删除一个后的两个值"+list);

        List<String> list1=new ArrayList<>();
        list1.add("aaa");
        list1.add("bbb");
        list1.add("aaa");
        System.out.println("转换前"+list1);
        Set set=new HashSet(list1);
        System.out.println("转换后"+set);

        Set set1=new HashSet();
        set1.add("bbb");
        set1.add("ccc");
        set.addAll(set1);
        System.out.println("合并set1"+set);

        set.removeAll(set1);
        System.out.println("减去set1"+set);

    }
}
