import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RedisCluster {
    private Map<String,String> map;


    private JedisCluster jedisCluster;

    public  RedisCluster(Map<String,String> map){
        this.map = map;
        Set<HostAndPort> nodes  = new HashSet<>();
        for(String key :getMap().keySet()){
            String[] arr= map.get(key).split(":");
            String ip = arr[0].trim();
            int port = Integer.parseInt(arr[1].trim());
            nodes.add(new HostAndPort(ip,port));
            System.out.println(arr[0].trim()+"---"+arr[1].trim());

        }
        jedisCluster = new JedisCluster(nodes);
    }

    public Map<String, String> getMap() {
        return map;
    }

    public JedisCluster getJedisCluster(){

        return jedisCluster;
    }


    public  boolean existKey(String key) {

        return jedisCluster.exists(key);
    }

    public  void delKey(String key) {
        jedisCluster.del(key);
    }

    public  String stringGet(String key) {
        return jedisCluster.get(key);
    }

    public  String stringSet(String key, String value) {
        return jedisCluster.set(key, value);
    }

    public  void hashSet(String key, String field, String value) {
        jedisCluster.hset(key, field, value);
    }
}
