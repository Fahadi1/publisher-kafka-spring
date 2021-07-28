package fr.eql.al35.wsrest.kafka.commandsmonitoring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	String kafkaTopic = "java_in_use_topic";

	public void sendMessage(String message) {
		kafkaTemplate.send(kafkaTopic, message);
	}

	/*
	 * fonctionne, envoie la commande en string : pas utilisée pour l'instant
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
	 */


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

	/*
	@SuppressWarnings("deprecation")
	public void listen() {
		System.out.println(KAFKA_TOPIC);
		System.out.println(Collections.singletonList(KAFKA_TOPIC).toString());
		kafkaConsumer.subscribe(Collections.singletonList(KAFKA_TOPIC));
		ConsumerRecords<Long, String> records = kafkaConsumer.poll(1000);
	    for (ConsumerRecord<Long, String> record : records) {
	      System.out.println(record.offset() + ": " + record.value());
	  }
	}
	 */
}
