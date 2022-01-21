package cn.stephen.study.htapitoproject.kafka;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.util.Properties;

/**
 * @Acthor Tao.Lee
 * @date 2022/1/20 11:10
 * @Description说明： 消费者工厂方法
 */

public class KafkaConsumerFactory {
    static KafkaConsumer<String, String> consumer;
    public static KafkaConsumer getKafkaConsumer(String group) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "172.20.8.250:9092");
        //每个消费者分配独立的组号
        props.put("group.id", group);
        //如果value合法，则自动提交偏移量
        props.put("enable.auto.commit", "false");
        // 每次拉取10条
        props.put("max.poll.records", 100);
        //设置多久一次更新被消费消息的偏移量
        props.put("auto.commit.interval.ms", "10000");
        //设置会话响应的时间，超过这个时间kafka可以选择放弃消费或者消费下一条消息
        props.put("session.timeout.ms", "30000");
        //自动重置offset
        props.put("auto.offset.reset", "earliest");
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");

        return consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<String, String>(props);
    }
}
