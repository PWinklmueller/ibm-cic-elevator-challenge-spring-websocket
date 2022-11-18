package at.ibm.elevator.entities;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import at.ibm.elevator.enums.Direction;

@SpringBootTest
public class ElevatorEventTest {

	@Test
	public void constructorTest() {
		ElevatorEvent elevatorEvent = new ElevatorEvent(0,35, Direction.UP);
		ElevatorEvent elevatorEvent2 = new ElevatorEvent(0, 35);
		
		assertThat(elevatorEvent.getStartFloor()).isEqualTo(0);
		assertThat(elevatorEvent.getDestinationFloor()).isEqualTo(35);
		assertThat(elevatorEvent.getDirection()).isEqualTo(Direction.UP);
		
		assertThat(elevatorEvent).isEqualTo(elevatorEvent2);
		
		assertThat(elevatorEvent2.getDirection()).isEqualTo(Direction.UP);
		
		ElevatorEvent elevatorEvent3 = new ElevatorEvent(35,0);
		assertThat(elevatorEvent3.getDirection()).isEqualTo(Direction.DOWN);
	}
}
