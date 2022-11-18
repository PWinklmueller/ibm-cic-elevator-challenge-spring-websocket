package at.ibm.elevator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import at.ibm.elevator.websocket.ElevatorWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig  implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new ElevatorWebSocketHandler(), "/elevator");
		
	}

}
