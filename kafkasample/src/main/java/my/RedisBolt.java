package my;

import org.apache.storm.redis.bolt.AbstractRedisBolt;
import org.apache.storm.redis.common.config.JedisClusterConfig;
import org.apache.storm.redis.common.config.JedisPoolConfig;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Tuple;
import redis.clients.jedis.JedisCommands;

import java.util.Map;

public class RedisBolt extends AbstractRedisBolt {
    private JedisCommands jedisCommands;

    public RedisBolt(JedisPoolConfig config) {
        super(config);
    }
    public RedisBolt(JedisClusterConfig config) {
        super(config);
    }
    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        jedisCommands  = getInstance();
    }
    @Override
    protected void process(Tuple tuple) {
        System.out.println("获取到的值"+tuple.getValue(0));
        //jedisCommands.set("ling","岭");
        System.out.println(jedisCommands.exists("song"));
        String song=jedisCommands.get("song");
        System.out.println("外界redis 值"+song);


    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }
}
