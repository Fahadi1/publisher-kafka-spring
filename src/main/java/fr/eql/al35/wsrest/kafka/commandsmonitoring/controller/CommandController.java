package fr.eql.al35.wsrest.kafka.commandsmonitoring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.eql.al35.wsrest.kafka.commandsmonitoring.dto.Command;
import fr.eql.al35.wsrest.kafka.commandsmonitoring.iservice.IKafkaSender;
import fr.eql.al35.wsrest.kafka.commandsmonitoring.service.KafkaSender;

@RestController
@RequestMapping(value="wsrest/publisherKafka/", headers="Accept=application/json")
public class CommandController {

	@Autowired
	IKafkaSender kafkaSender;

	@GetMapping(value="/producer/message")
	public String producer(@RequestParam("message") String message) {
		kafkaSender.sendMessage(message);
		return "Message : " + message.toString() + "send to topic cmd_mathilda";
	}

	@PostMapping(value="/producer/message")
	public String producerPost(@RequestBody String message) {
		kafkaSender.sendMessage(message);
		return "Message : " + message + "send to topic cmd_mathilda";
	}

	@PostMapping(value="/producer/command")
	public Command producer(@RequestBody Command command) {
		kafkaSender.sendCommand(command);
		return command;
	}

	/*
	@GetMapping(value="/listener")
	public String listener() {
		kafkaService.listen();
		return "listener ok";
	}
	 */

}
