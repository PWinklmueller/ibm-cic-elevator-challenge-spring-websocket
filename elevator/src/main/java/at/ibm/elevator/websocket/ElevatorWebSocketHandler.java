package at.ibm.elevator.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import at.ibm.elevator.entities.ElevatorEvent;
import at.ibm.elevator.entities.ElevatorManager;


public class ElevatorWebSocketHandler extends TextWebSocketHandler {

	private ElevatorManager elevatorManager = new ElevatorManager(55,7);
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws JsonMappingException, JsonProcessingException {
		System.out.println(message.getPayload());
		ElevatorEvent newEvent = objectMapper.readValue(message.getPayload(), ElevatorEvent.class);
		elevatorManager.addRequest(newEvent);
			
	}
	


}
