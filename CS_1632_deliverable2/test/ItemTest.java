import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

	// The constructor should take an input and assign it to the 
	// object. The member should be set to this value.
	@Test
	public void contructorAdj1Test() {
		Item item = new Item("A", "", "");
		assertEquals("A", item.adjective1);
	}
	
	// The constructor should take an input and assign it to the 
	// object. The member should be set to this value.
	@Test
	public void contructorAdj2Test() {
		Item item = new Item("", "B", "");
		assertEquals("B", item.adjective2);
	}
	
	// The constructor should take an input and assign it to the 
	// object. The member should be set to this value.
	@Test
	public void contructorNounTest() {
		Item item = new Item("", "", "C");
		assertEquals("C", item.noun);
	}

	// Testing to getter functions. These return a member variable so they should 
	// always be equal to the value of the member.
	@Test
	public void getAdj1Test() {
		Item item = new Item("A", "", "C");
		assertEquals("A", item.getAdj1());
	}
	
	// Testing to getter functions. These return a member variable so they should 
	// always be equal to the value of the member.
	@Test
	public void getAdj2Test() {
		Item item = new Item("", "B", "C");
		assertEquals("B", item.getAdj2());
	}
	
	// Testing to getter functions. These return a member variable so they should 
	// always be equal to the value of the member.
	@Test
	public void getNounTest() {
		Item item = new Item("", "", "C");
		assertEquals("C", item.getNoun());
	}
}
