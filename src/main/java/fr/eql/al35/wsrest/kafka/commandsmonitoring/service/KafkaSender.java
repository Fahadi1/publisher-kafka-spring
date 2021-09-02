package fr.eql.al35.wsrest.kafka.commandsmonitoring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import fr.eql.al35.wsrest.kafka.commandsmonitoring.dto.Command;
import fr.eql.al35.wsrest.kafka.commandsmonitoring.iservice.IKafkaSender;

@Service
public class KafkaSender implements IKafkaSender {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	String kafkaTopic = "cmd_mathilda";

	@Override
	public void sendMessage(String message) {
		kafkaTemplate.send(kafkaTopic, message);
	}
	
	@Override
	public void sendCommand(Command command) {
		ObjectMapper obj = new ObjectMapper();
		obj.registerModule(new JavaTimeModule());
		obj.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		try {
			String str = obj.writeValueAsString(command);
			System.out.println(str);
			kafkaTemplate.send(kafkaTopic, str);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}



	/* probleme localdateTime
	 * 
	 * 
	 * 	public void sendCommand(Command command) {
		LOG.info("sending data = '{}' to topic = '{}'", command, kafkaTopic);

		Message<Command> message = MessageBuilder
				.withPayload(command)
				.setHeader(KafkaHeaders.TOPIC, kafkaTopic)
				.build();
		System.out.println("converted : " + message);
		kafkaCmdTemplate.send(message);
	}
	 * 
	 */

}
