package sqs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sqs.consumer.MessageDTO;
import sqs.producer.MyProducer;

@SpringBootApplication
public class SqsApplication implements CommandLineRunner {

	@Autowired
	MyProducer myProducer;

	public static void main(String[] args) {
		SpringApplication.run(SqsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MessageDTO message = new MessageDTO("Mensagem de teste para a fila");
		myProducer.sendMessage(message);
	}
}
