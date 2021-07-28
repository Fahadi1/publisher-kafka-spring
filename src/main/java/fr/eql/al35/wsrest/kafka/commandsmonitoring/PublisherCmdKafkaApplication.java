package fr.eql.al35.wsrest.kafka.commandsmonitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PublisherCmdKafkaApplication  {

	public static void main(String[] args) {
		SpringApplication.run(PublisherCmdKafkaApplication.class, args);
		System.out.println("http://localhost:8180//wsrest/publisherKafka/allCommands");
		System.out.println("http://localhost:8180//wsrest/publisherKafka/producer/message?message=[command:id=4,date=21/07/2021");
		
		//#spring.data.mongodb.uri = mongodb://192.168.33.10:27017/mydatabase
	}

}