package my;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class SmsKafkaSpout extends AbstractKafkaSpout {
    private static final long serialVersionUID = -192075285815617456L;
    private static Logger log = LoggerFactory.getLogger(SmsKafkaSpout.class);
    private static Gson gson = new GsonBuilder().serializeNulls().create();

    public SmsKafkaSpout(String topic, Properties props) {
        super(topic, props);
    }

    @Override
    protected void processMessage(String topic, String msg) {
//        if(null != msg) {
//            GeneralMessageSendVO generalMessageSendVO = gson.fromJson(msg, new TypeToken<GeneralMessageSendVO>() { }.getType());
//            if(null != generalMessageSendVO) {
//                collector.emit(new Values(topic, msg, generalMessageSendVO.getMsgId()));
//            }
//        }
        log.info("获取到了topic是"+topic+"的kafka数据"+msg);
        collector.emit(new Values(msg,"",""));

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("topic", "msg", "message_id"));
    }
}