package cn.stephen.study.htapitoproject.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
/**
 * @Acthor Tao.Lee
 * @date 2022/1/20 10:43
 * @Description说明：
 */
public class KafkaProducer {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "172.20.8.250:9092");
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        org.apache.kafka.clients.producer.KafkaProducer<String, String> kafkaProducer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(properties);

      // -- 同步发送消息
        for (int i = 630; i <= 639; i++) {
            //参数1：topic名, 参数2：消息文本； ProducerRecord多个重载的构造方法
            kafkaProducer.send(new ProducerRecord<String, String>("test", "===一条"+i));
            System.out.println("message"+i);
        }
        // -- 异步发送消息
        //ProducerRecord<String, String> asyncRecord = new ProducerRecord<String, String>("test", "Kafka_Products", "111--1");//Topic Key Value
        //kafkaProducer.send(asyncRecord, new DemoProducerCallback());//发送消息时，传递一个回调对象，该回调对象必须实现org.apache.kafka.clients.producer.Callback接口

        kafkaProducer.close();



    }

    private static class DemoProducerCallback implements Callback {
        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
            if (e != null) {//如果Kafka返回一个错误，onCompletion方法抛出一个non null异常。
                e.printStackTrace();//对异常进行一些处理，这里只是简单打印出来
            }
        }
    }
}