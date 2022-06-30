package cn.lee.study.Jnapitoproject.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.UUID;

/**
 * @Acthor Tao.Lee
 * @date 2022/1/20 11:12
 * @Description说明：
 */
@EnableAsync
@Component
@Slf4j
public class KafkaConsumerQueue {
    static boolean RUN = false;

    @Async
    //一直执行，但是一小时再检查启动一次
    //@Scheduled(cron = "0 0 * * * ?")
    public void task() {
        if (RUN) {
            return;
        }
        RUN = true;
        KafkaConsumer consumer = KafkaConsumerFactory.getKafkaConsumer("group2");
        consumer.subscribe(Arrays.asList("test"));

        //只循环1分钟
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            System.out.println("批次：" + UUID.randomUUID().toString());


            for (ConsumerRecord<String, String> record : records) {
                System.out.printf(record.topic() +
                                "一条新消息 offset = %d, key = %s, value = %s", record.offset(),
                        record.key(), record.value());

                // 业务处理 TODO

            }

            // 同步提交
            if (records.count() > 0) {
                consumer.commitSync();
                System.out.println("批次提交");
            }


        }
    }
}
