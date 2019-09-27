package my;

import java.util.Map;
import org.apache.storm.redis.common.config.JedisClusterConfig;
import org.apache.storm.redis.common.config.JedisPoolConfig;
import org.apache.storm.redis.common.container.JedisCommandsContainerBuilder;
import org.apache.storm.redis.common.container.JedisCommandsInstanceContainer;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.base.BaseTickTupleAwareRichBolt;
import redis.clients.jedis.JedisCommands;

public abstract class AbstractRedisBolt extends BaseTickTupleAwareRichBolt {
    protected OutputCollector collector;
    private transient JedisCommandsInstanceContainer container;
    private JedisPoolConfig jedisPoolConfig;
    private JedisClusterConfig jedisClusterConfig;

    public AbstractRedisBolt(JedisPoolConfig config) {
        this.jedisPoolConfig = config;
    }

    public AbstractRedisBolt(JedisClusterConfig config) {
        this.jedisClusterConfig = config;
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        this.collector = collector;
        if (this.jedisPoolConfig != null) {
            this.container = JedisCommandsContainerBuilder.build(this.jedisPoolConfig);
        } else {
            if (this.jedisClusterConfig == null) {
                throw new IllegalArgumentException("Jedis configuration not found");
            }

            this.container = JedisCommandsContainerBuilder.build(this.jedisClusterConfig);
        }

    }

    protected JedisCommands getInstance() {
        return this.container.getInstance();
    }

    protected void returnInstance(JedisCommands instance) {
        this.container.returnInstance(instance);
    }

    public void cleanup() {
        this.container.close();
    }
}
