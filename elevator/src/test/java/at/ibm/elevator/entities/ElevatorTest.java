package at.ibm.elevator.entities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import at.ibm.elevator.enums.Direction;

@SpringBootTest
public class ElevatorTest {
	
	private int randomId = (int) (Math.random()*100);
	private Elevator elevator = new Elevator(randomId);
	
	@BeforeEach
	public void constructorTest() {
		assertThat(elevator.getElevatorId()).isEqualTo(randomId);
		assertThat(elevator.getCurrentFloor()).isEqualTo(0);
		assertThat(elevator.getListOfEvents()).isEqualTo(new ArrayList<>());
	}
	
	@Test
	public void calcAvailabilityTest() {
		assertThat(elevator.calcAvailability(0)).isEqualTo(0);
		assertThat(elevator.calcAvailability(10)).isEqualTo(10);
		
		ElevatorEvent event = new ElevatorEvent(0,5,Direction.UP);
		elevator.addToListOfEvents(event);
		elevator.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			fail("InterruptedException: "+e);
			e.printStackTrace();
		}
		elevator.interrupt();
		
		assertThat(elevator.getCurrentFloor()).isEqualTo(5);
		assertThat(elevator.calcAvailability(5)).isEqualTo(0);
		assertThat(elevator.calcAvailability(0)).isEqualTo(5);
		assertThat(elevator.calcAvailability(15)).isEqualTo(10);
		
		
	
	}
	
	@Test
	public void calcAvailabilityTest2() {
		ElevatorEvent event1 = new ElevatorEvent(5,25, Direction.UP);
		ElevatorEvent event2 = new ElevatorEvent(30,10, Direction.DOWN);
		
		elevator.addToListOfEvents(event1);
		elevator.addToListOfEvents(event2);
		
		assertThat(elevator.calcAvailability(0)).isEqualTo(60);
		assertThat(elevator.calcAvailability(55)).isEqualTo(95);
	}
	
	
}
