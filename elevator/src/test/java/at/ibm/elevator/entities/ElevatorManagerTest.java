package at.ibm.elevator.entities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import at.ibm.elevator.enums.Direction;

@SpringBootTest
public class ElevatorManagerTest {
	
	
	@Test
	public void constructorTest() {
		ElevatorManager elevatorManager = new ElevatorManager();
		assertThat(elevatorManager.getNumberOfFloors()).isEqualTo(55);
		assertThat(elevatorManager.getNumberOfElevators()).isEqualTo(7);
		
		ElevatorManager elevatorManager2 = new ElevatorManager(10,2);
		assertThat(elevatorManager2.getNumberOfFloors()).isEqualTo(10);
		assertThat(elevatorManager2.getNumberOfElevators()).isEqualTo(2);		
	}
	
	@Test
	public void addRequestTest() {
		ElevatorManager elevatorManager = new ElevatorManager(15,3);
		elevatorManager.addRequest(new ElevatorEvent(0,10));
		elevatorManager.addRequest(new ElevatorEvent(7,2));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			fail("InterruptedException: "+e);
			e.printStackTrace();
		}
		ArrayList<Elevator> elevators = elevatorManager.getElevators();
		boolean isElevatorOnFloor10 = false;
		boolean isElevatorOnFloor2 = false;
		boolean isElevatorOnFloor5 = false;
		
		for(Elevator elevator : elevators) {
			if(elevator.getCurrentFloor() == 10) {
				isElevatorOnFloor10 = true;
			} else if( elevator.getCurrentFloor() == 2) {
				isElevatorOnFloor2 = true;
			} else if(elevator.getCurrentFloor() == 5) {
				isElevatorOnFloor5 = true;
			}
		}
		assertThat(isElevatorOnFloor10).isEqualTo(true);
		assertThat(isElevatorOnFloor2).isEqualTo(true);
		assertThat(isElevatorOnFloor5).isEqualTo(false);
		
		
	}
	
	@Test
	public void getClosestElevatorForEventTest() {
		ElevatorManager elevatorManager = new ElevatorManager(10,2);
		
		ArrayList<Elevator> elevators = elevatorManager.getElevators();
		elevators.get(0).addToListOfEvents(new ElevatorEvent(5,6, Direction.UP));
		
		Elevator closestElevator = elevatorManager.getClosestElevatorForEvent(elevators, new ElevatorEvent(9,4));
		assertThat(closestElevator).isEqualTo(elevators.get(0));
		
		Elevator closestElevator2 = elevatorManager.getClosestElevatorForEvent(elevators, new ElevatorEvent(2,3));
		assertThat(closestElevator2).isEqualTo(elevators.get(1));
		
		
		elevators.get(1).addToListOfEvents(new ElevatorEvent(1,7, Direction.UP));
		elevators.get(1).addToListOfEvents(new ElevatorEvent(7,2, Direction.DOWN));
		Elevator closestElevator3 = elevatorManager.getClosestElevatorForEvent(elevators, new ElevatorEvent(2,9));
		assertThat(closestElevator3).isEqualTo(elevators.get(0));
		
	}
	
	
	
}
