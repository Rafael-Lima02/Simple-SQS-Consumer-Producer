package sqs.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import sqs.consumer.MessageDTO;

@Component
public class MyProducer {

    @Autowired
    SqsAsyncClient asyncClient;

    private final ObjectMapper mapper = new ObjectMapper();

    public void sendMessage(MessageDTO messageDTO) throws JsonProcessingException {
        SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .queueUrl("https://localhost.localstack.cloud:4566/000000000000/my-queue")
                .messageBody(mapper.writeValueAsString(messageDTO))
                .build();

        asyncClient.sendMessage(sendMessageRequest);

        System.out.println("Message sent to SQS: " + messageDTO.content());
    }
}
