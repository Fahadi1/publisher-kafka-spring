package fr.eql.al35.wsrest.kafka.commandsmonitoring.iservice;

import fr.eql.al35.wsrest.kafka.commandsmonitoring.dto.Command;

public interface IKafkaSender {

	public void sendMessage(String message);
	public void sendCommand(Command command);

}
