
import com.alibaba.fastjson.JSONObject;
import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry.*;
import com.alibaba.otter.canal.protocol.Message;

import java.net.InetSocketAddress;
import java.util.*;
import java.util.List;
import java.util.Map;

public class main {
    public static RedisCluster redisCluster=null;
    public static void main(String[] args) {
        Map map= new HashMap();
        map.put("0","127.0.0.1:9000");
        map.put("1","127.0.0.1:9001");
        map.put("2","127.0.0.1:9002");
        map.put("3","127.0.0.1:9003");
        map.put("4","127.0.0.1:9004");
        map.put("5","127.0.0.1:9005");

        redisCluster=new RedisCluster(map);
        redisCluster.stringSet("123","初始化redis集群成功");
        System.out.println( redisCluster.stringGet("123"));
       ;
        CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress("127.0.0.1",
                11111), "example", "", "");
        System.out.println( "canal服务正常连接");
        int batchSize = 100;
        try {
            connector.connect();
            connector.subscribe(".*\\..*");
            connector.rollback();
            while (true) {
                // 获取指定数量的数据
                Message message = connector.getWithoutAck(batchSize);
                long batchId = message.getId();
                int size = message.getEntries().size();
                System.out.println("batchId = " + batchId);
                System.out.println("size = " + size);
                if (batchId == -1 || size == 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    printEntry(message.getEntries());
                }
                // 确认消费
                connector.ack(batchId);
                // connector.rollback(batchId); // 处理失败, 回滚数据
            }
        } finally {
            connector.disconnect();
        }
    }


    private static void printEntry(List<Entry> entrys) {
        for (Entry entry : entrys) {
            if (entry.getEntryType() == EntryType.TRANSACTIONBEGIN || entry.getEntryType() == EntryType.TRANSACTIONEND) {
                continue;
            }
            RowChange rowChage = null;
            try {
                rowChage = RowChange.parseFrom(entry.getStoreValue());
            } catch (Exception e) {
                throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(),
                        e);
            }
            EventType eventType = rowChage.getEventType();
            System.out.println("table名"+entry.getHeader().getTableName());

            for (RowData rowData : rowChage.getRowDatasList()) {
                System.out.println("之前"+rowData.getBeforeColumnsList());
                System.out.println("之后"+rowData.getAfterColumnsList());
//                if (eventType == EventType.DELETE) {
//                    redisDelete(rowData.getBeforeColumnsList());
//                } else if (eventType == EventType.INSERT) {
//                    redisInsert(rowData.getAfterColumnsList());
//                } else {
//                    System.out.println("-------> before");
//                    printColumn(rowData.getBeforeColumnsList());
//                    System.out.println("-------> after");
//                    redisUpdate(rowData.getAfterColumnsList());
//                }
            }
        }
    }

    private static void printColumn(List<Column> columns) {
        for (Column column : columns) {
            System.out.println(column.getName() + " : " + column.getValue() + "    update=" + column.getUpdated());
        }
    }

    private static void redisInsert(List<Column> columns) {
        JSONObject json = new JSONObject();
        for (Column column : columns) {
            json.put(column.getName(), column.getValue());
        }
        if (columns.size() > 0) {
            redisCluster.stringSet("user:" + columns.get(0).getValue(), json.toJSONString());
        }
    }

    private static void redisUpdate(List<Column> columns) {
        JSONObject json = new JSONObject();
        for (Column column : columns) {
            json.put(column.getName(), column.getValue());
        }
        if (columns.size() > 0) {
            redisCluster.stringSet("user:" + columns.get(0).getValue(), json.toJSONString());
        }
    }

    private static void redisDelete(List<Column> columns) {
        JSONObject json = new JSONObject();
        for (Column column : columns) {
            json.put(column.getName(), column.getValue());
        }
        if (columns.size() > 0) {
            redisCluster.delKey("user:" + columns.get(0).getValue());
        }
    }
}
