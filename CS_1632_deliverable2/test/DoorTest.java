import static org.junit.Assert.*;

import org.junit.Test;

public class DoorTest {
	
	// The constructor should take an input and assign it to the 
	// object. The member should be set to this value.
	@Test
	public void contructorAdjTest() {
		Door door = new Door("Wood", "");
		assertEquals("Wood", door.adjective);
	}
	
	// The constructor should take an input and assign it to the 
	// object. The member should be set to this value.
	@Test
	public void contructorDirectionTest() {
		Door door = new Door("", "North");
		assertEquals("North", door.direction);
	}
	
	// The to string method should always return a string that is based on the 
	// object so the toString should match the constructor inputs for a newly 
	// created object.
	@Test
	public void toStringtest() {
		Door door = new Door("A", "B");
		assertEquals("A A door leads B.", door.toString());
	}

}
