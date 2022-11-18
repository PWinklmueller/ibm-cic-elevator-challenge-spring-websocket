package at.ibm.elevator.entities;

import at.ibm.elevator.enums.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Represents the information that is given when pressing the button.
 * @author philippw
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElevatorEvent {
	private int startFloor;
	private int destinationFloor;
	private Direction direction;
	
	
	/**
	 * Constructor without direction, as direction can be derived from the other two parameters.
	 * @param startFloor       - Floor where person wants to be picked up from.
	 * @param destinationFloor - Floor where person wants to go.
	 */
	public ElevatorEvent(int startFloor, int destinationFloor) {
		this(startFloor, destinationFloor,startFloor < destinationFloor ? Direction.UP : Direction.DOWN);
	}
		
}
