package my;

import org.apache.commons.lang.StringUtils;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichSpout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public abstract class AbstractKafkaSpout implements IRichSpout {

    private static Logger log = LoggerFactory.getLogger(AbstractKafkaSpout.class);
    private KafkaConsumer<String, String> consumer = null;
    protected SpoutOutputCollector collector;
    private transient TopologyContext context;
    private String topic;
    private Properties props;

    protected transient Object writeLock;
    public AbstractKafkaSpout(String topic, Properties props) {
        this.topic=topic;
        this.props = props;
    }
    public AbstractKafkaSpout(){}

    @Override
    public void nextTuple() {

    }

    @Override
    public void close() {

    }

    @Override
    public void activate() {

    }

    @Override
    public void deactivate() {

    }

    @Override
    public void ack(Object msgId) {

    }

    @Override
    public void fail(Object msgId) {

    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        writeLock = new Object();
        log.info("init>>>>>>writeLock");
        this.collector = collector;
        this.context = context;
        fetchMesasge();
    }

    /**
     * 在子类中实现对消息的处理，并负责处理异常。
     */
    protected abstract void processMessage(String topic, String msg);

    /**
     * 构建Consumer
     */
    private void fetchMesasge() {
        if(null == this.props) {
            log.error("init error, props is null");
            return;
        }
        if (StringUtils.isBlank(this.props.getProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG))) {
            log.error("kafka boostrap is empty,topic={},group={}", topic, this.props.getProperty(ConsumerConfig.GROUP_ID_CONFIG));
            return;
        }

        log.info("begin kafka create consumer ,topic={},group={}", topic, this.props.getProperty(ConsumerConfig.GROUP_ID_CONFIG));
        final Map<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap<>(5);
        consumer = new KafkaConsumer<>(this.props);
        consumer.subscribe(Collections.singletonList(topic), new ConsumerRebalanceListener() {
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> collection) {}

            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> collection) {
                log.info("rebalance partition: " + currentOffsets);
                consumer.commitSync(currentOffsets);
            }
        });

        try {
            while (true) {
                long start = System.currentTimeMillis();
                ConsumerRecords<String, String> records = consumer.poll(100);
                int count = records.count();
                if(count > 0) {
                    log.info("开始时间：{}，读取kafka消息，耗时：{}毫秒，消息条数：{}，开始发送", start, System.currentTimeMillis()-start, count);
                }
                for(ConsumerRecord<String, String> record : records) {
                    log.info("receive topic=" + record.topic() + ", offset=" + record.offset() + ", partition=" + record.partition() + ",timestamps="
                            + new Date(record.timestamp()) + "(" + record.timestamp() + ")" + ", object=" + record.value());
                    processMessage(record.topic(), record.value());
                    // 记录当前处理的位置，当发生分区再平衡时，提交当前的offset
                    currentOffsets.put(new TopicPartition(record.topic(), record.partition()), new OffsetAndMetadata(record.offset() + 1, "no metadata"));
                }
                if(count > 0) {
                    log.info("开始时间：{}，读取+发送kafka消息，耗时：{}毫秒，消息条数：{}，发送完毕", start, System.currentTimeMillis()-start, count);
                }
                Thread.sleep(1);
            }
        } catch (Exception ex) {
            log.error("receive message error,topic={}", topic, ex);
        } finally {
            try {
                log.info("close consumer,topic={}", topic);
                consumer.commitSync(currentOffsets);
            } catch (Exception ignored) {
                consumer.close();
            }
        }
    }

}