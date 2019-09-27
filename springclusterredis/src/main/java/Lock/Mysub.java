package Lock;

import redis.clients.jedis.JedisPubSub;

public class Mysub extends JedisPubSub {

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("订阅了：" + channel);
        super.onSubscribe(channel, subscribedChannels);
    }

    @Override
    public void onMessage(String channel, String message) {
        System.out.println("收到通道" + channel + "消息：" + message);
        try {
            Thread.sleep(3000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.onMessage(channel, message);
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("取消订阅：" + channel);
        super.onUnsubscribe(channel, subscribedChannels);
    }

}
