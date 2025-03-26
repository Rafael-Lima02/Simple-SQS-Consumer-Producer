package sqs.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {

    private final ObjectMapper mapper = new ObjectMapper();

    @SqsListener("my-queue")
    public void listen(String message) throws JsonProcessingException {
        MessageDTO messageDTO = mapper.readValue(message, MessageDTO.class);
        System.out.println("Message received: " + messageDTO.content());
    }
}
