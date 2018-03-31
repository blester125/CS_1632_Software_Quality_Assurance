import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.mockito.*;

public class RoomTest {

	@Mock
	Furniture f = Mockito.mock(Furniture.class);
	Item i = Mockito.mock(Item.class);
	Door n = Mockito.mock(Door.class);
	Door s = Mockito.mock(Door.class);
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(f);
		MockitoAnnotations.initMocks(i);
		MockitoAnnotations.initMocks(n);
		MockitoAnnotations.initMocks(s);
		Mockito.when(f.toString()).thenReturn("F");
		Mockito.when(n.toString()).thenReturn("N");
		Mockito.when(s.toString()).thenReturn("S");
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	// The constructor should take an input and assign it to the 
	// object. The member should be set to this value.
	@Test
	public void constructorAdjTest() {
		Room room = new Room("A", f, n, s, i);
		assertEquals("A", room.adjective);
	}

	// The constructor should take an input and assign it to the 
	// object. The member should be set to this value.
	@Test
	public void constructorFuritureTest() {
		Room room = new Room("A", f, n, s, i);
		assertEquals(f, room.furnishing);
	}
	
	// The constructor should take an input and assign it to the 
	// object. The member should be set to this value.
	@Test
	public void constructorNorthDoorTest() {
		Room room = new Room("A", f, n, s, i);
		assertEquals(n, room.northDoor);
	}
	
	// The constructor should take an input and assign it to the 
	// object. The member should be set to this value.
	@Test
	public void constructorSouthDoorTest() {
		Room room = new Room("A", f, n, s, i);
		assertEquals(s, room.southDoor);
	}
	
	// The constructor should take an input and assign it to the 
	// object. The member should be set to this value.
	@Test
	public void constructorItemTest() {
		Room room = new Room("A", f, n, s, i);
		assertEquals(i, room.item);
	}

	// Testing to getter functions. These return a member variable so they should 
	// always be equal to the value of the member.
	@Test
	public void getItemTest() {
		Room room = new Room("A", f, null, null, i);
		assertEquals(i, room.getItem());
	}

	// The to string method should always return a string that is based on the 
	// object so the toString should match the constructor inputs for a newly 
	// created object. This toString changes based on the doors in the room. 
	// This tests the tostring when there is no doors in the room
	@Test
	public void toStringNoDoorsTest() {
		Room room = new Room("A", f, null, null, i);
		assertEquals("You see a A room.\nF\n", room.toString());
	}
	
	// The to string method should always return a string that is based on the 
	// object so the toString should match the constructor inputs for a newly 
	// created object. This toString changes based on the doors in the room. 
	// This tests the tostring when there is a north door in the room
	@Test 
	public void toStringNorthDoorTest() {
		Room room = new Room("A", f, n, null, i);
		assertEquals("You see a A room.\nF\nN\n", room.toString());
	}
	
	// The to string method should always return a string that is based on the 
	// object so the toString should match the constructor inputs for a newly 
	// created object. This toString changes based on the doors in the room. 
	// This tests the tostring when there is a south door in the room
	@Test 
	public void toStringSouthDoorTest() {
		Room room = new Room("A", f, null, s, i);
		assertEquals("You see a A room.\nF\nS\n", room.toString());
	}
	
	// The to string method should always return a string that is based on the 
	// object so the toString should match the constructor inputs for a newly 
	// created object. This toString changes based on the doors in the room. 
	// This tests the tostring when there are both doors in the room
	@Test 
	public void toStringBothDoorsTest() {
		Room room = new Room("A", f, n, s, i);
		assertEquals("You see a A room.\nF\nN\nS\n", room.toString());
	}
	
	// Testing to getter functions. These return a member variable so they should 
	// always be equal to the value of the member.
	@Test
	public void getNorthRoomTest() {
		Room room = new Room("A", f, n, s, i);
		Room r = Mockito.mock(Room.class);
		room.northRoom = r;
		assertEquals(r, room.getNorthRoom());
	}
	
	// Testing to getter functions. These return a member variable so they should 
	// always be equal to the value of the member.
	@Test
	public void getNorthDoorTest() {
		Room room = new Room("A", f, n, s, i);
		assertEquals(n, room.getNorthDoor());
	}
	
	// Testing to getter functions. These return a member variable so they should 
	// always be equal to the value of the member.
	@Test
	public void getSouthRoomTest() {
		Room room = new Room("A", f, n, s, i);
		Room r = Mockito.mock(Room.class);
		room.southRoom = r;
		assertEquals(r, room.getSouthRoom());
	}
	
	// Testing to getter functions. These return a member variable so they should 
	// always be equal to the value of the member.
	@Test
	public void getSouthDoorTest() {
		Room room = new Room("A", f, n, s, i);
		assertEquals(s, room.getSouthDoor());
	}
}
