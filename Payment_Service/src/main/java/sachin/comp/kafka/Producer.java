package sachin.comp.kafka;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import sachin.comp.entity.MposPayment;

import java.util.concurrent.CompletableFuture;

@Component
public class Producer {
    private static final Logger LOG = LoggerFactory.getLogger(Producer.class);
    private final KafkaTemplate<String, Object> kafkaTemplate;


    public Producer (KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;

    }

    public void publishEvent(String eventName, String eventId, String topicName, Object event) {
        CompletableFuture<SendResult<String, Object>> future =
                kafkaTemplate.send(topicName, eventId, event);
        future.whenComplete((result, ex) -> {
            if (ex != null) {
                LOG.error("Unable to publish the event {}", eventName);
                LOG.error("Error Trance: ", ex);
            } else {
                LOG.info("Kafka publish the {} event with eventId: {} successfully. Offset={}",
                        eventName, eventId, result.getRecordMetadata().offset());
            }
        });
    }
}
