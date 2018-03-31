import static org.junit.Assert.*;

import org.junit.Test;

public class FurnitureTest {

	// The constructor should take an input and assign it to the 
	// object. The member should be set to this value.
	@Test
	public void furnitureConstructorAdjTest() {
		Furniture f = new Furniture("A", "");
		assertEquals("A", f.adjactive);
	}
	
	// The constructor should take an input and assign it to the 
	// object. The member should be set to this value.
	@Test
	public void furnitureConstructorNounTest() {
		Furniture f = new Furniture("", "A");
		assertEquals("A", f.noun);
	}

	// The to string method should always return a string that is based on the 
	// object so the toString should match the constructor inputs for a newly 
	// created object.
	@Test
	public void toStringTest() {
		Furniture f = new Furniture("A", "B");
		assertEquals("It has a A B.", f.toString());
	}
}
