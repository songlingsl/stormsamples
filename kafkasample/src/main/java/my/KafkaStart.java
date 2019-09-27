package my;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.storm.LocalCluster;
import org.apache.storm.redis.common.config.JedisClusterConfig;
import org.apache.storm.redis.common.config.JedisPoolConfig;
import org.apache.storm.topology.TopologyBuilder;

import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.apache.storm.Config;



public class KafkaStart {


       public static void main(String[] ss){

           TopologyBuilder builder = new TopologyBuilder();
            //接收到kafka数据
           builder.setSpout("kafkaspoutsl", new SmsKafkaSpout("sltopic", getkafkaPertie()),1).setNumTasks(1);
           builder.setBolt("redissl", new RedisBolt(getJedisCluster()), 4).shuffleGrouping("kafkaspoutsl");
           Config config = new Config();
           config.setDebug(true);
           LocalCluster cluster= new LocalCluster();
           cluster.submitTopology("kafkaSongling", config, builder.createTopology());
       }











       public static Properties getkafkaPertie(){
           String group = "slgroup";
           String kafkaServer = "127.0.0.1:9092";
           //单个拓扑分配worker数
           int workerNum = 1;
           //单个worker配置一次性取kafka条数
           int singleCount =10;

           Properties spoutProps = new Properties();
           //采用自动提交方式
           spoutProps.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
           spoutProps.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,1000);
           // 5秒发送一次心跳，此值要小于session.timeout.ms的值
           spoutProps.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, "5000");
           // 30秒kafka如果没有收到心跳，认为Consumer不在线，将发生再平衡
           spoutProps.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
           // 每次读取的数据量限制
           spoutProps.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, singleCount*workerNum + "");
           spoutProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
           spoutProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
           spoutProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
           spoutProps.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
           spoutProps.put(ConsumerConfig.GROUP_ID_CONFIG,  group);
           spoutProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,  kafkaServer);
           spoutProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
           return spoutProps;

       }


//    public static JedisPoolConfig  getJedisCluster() {
//        JedisPoolConfig poolConfig = new JedisPoolConfig.Builder()
//                .setHost("127.0.0.1").setPort(6379).build();
//        return poolConfig;
//    }


    public static JedisClusterConfig getJedisCluster() {
        //获取服务器数组
        String[] serverArray = "127.0.0.1:9000,127.0.0.1:9001,127.0.0.1:9002,127.0.0.1:9003,127.0.0.1:9004,127.0.0.1:9005".split(",");
        Set<InetSocketAddress> nodes = new HashSet<>();
        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new InetSocketAddress(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }
        return new JedisClusterConfig.Builder().setNodes(nodes)
                    .setMaxRedirections(5)
                    .setTimeout(10000)
                    .build();

    }

}
