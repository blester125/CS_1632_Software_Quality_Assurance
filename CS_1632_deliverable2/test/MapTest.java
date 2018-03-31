import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class MapTest {

	// The constructor should take an input and assign it to the 
	// object. The member should be set to this value.
	@Test
	public void contructorTest() {
		Map m = new Map();
		assertEquals(null, m.getLocation());
	}
	
	// Testing to getter functions. These return a member variable so they should 
	// always be equal to the value of the member.
	@Test
	public void getLocationTest() {
		Map m = new Map();
		assertEquals(null, m.getLocation());
	}
	
	// Testing to getter functions. These return a member variable so they should 
	// always be equal to the value of the member.
	@Test
	public void setLocationTest() {
		Map m = new Map();
		Room room = Mockito.mock(Room.class);
		m.setLocation(room);
		assertSame(room, m.getLocation());
	}

	// A test that a room can be added to an empty map.
	@Test
	public void addToEmptyMap() {
		Map m = new Map();
		Room firstroom = Mockito.mock(Room.class);
		m.addRoom(firstroom);
		assertSame(firstroom, m.getLocation());
	}
	
	// A test that a room can be added to a map with one room in it.
	@Test
	public void addToOneRoomTest() {
		Map m = new Map();
		Room firstroom = Mockito.mock(Room.class);
		Room secondroom = Mockito.mock(Room.class);
		m.addRoom(firstroom);
		m.addRoom(secondroom);
		assertSame(secondroom, m.getLocation().northRoom);
	}
	
	// A test that a room can be added to a map with twp rooms is it.
	@Test
	public void addToTwoRoomTest() {
		Map m = new Map();
		Room firstroom = Mockito.mock(Room.class);
		Room secondroom = Mockito.mock(Room.class);
		Room thridroom = Mockito.mock(Room.class);
		m.addRoom(firstroom);
		m.addRoom(secondroom);
		m.addRoom(thridroom);
		assertSame(thridroom, m.getLocation().northRoom.northRoom);
	}
	
	// A test is a move North works when there is a Door and a Room to the north
	@Test
	public void legalMoveNorthTest() {
		Map map = new Map();
		Room loc = Mockito.mock(Room.class);
		Room loc2 = Mockito.mock(Room.class);
		Door door = Mockito.mock(Door.class);
		Mockito.when(loc.getNorthRoom()).thenReturn(loc2);
		Mockito.when(loc.getNorthDoor()).thenReturn(door);
		map.setLocation(loc);
		map.moveNorth(loc);
		assertEquals(loc2, map.getLocation());
	}
	
	// A test that a move North doesn't do anything if there is not a door. 
	@Test
	public void illegalMoveNorthNoDoorTest() {
		Map map = new Map();
		Room loc = Mockito.mock(Room.class);
		Room loc2 = Mockito.mock(Room.class);
		Mockito.when(loc.getNorthRoom()).thenReturn(loc2);
		Mockito.when(loc.getNorthDoor()).thenReturn(null);
		map.setLocation(loc);
		map.moveNorth(loc);
		assertEquals(loc, map.getLocation());
	}
	
	// A test that a move north doesn't do anything if there is not a room.
	@Test
	public void illegalMoveNorthNoRoomTest() {
		Map map = new Map();
		Room loc = Mockito.mock(Room.class);
		Door door = Mockito.mock(Door.class);
		Mockito.when(loc.getNorthRoom()).thenReturn(null);
		Mockito.when(loc.getNorthDoor()).thenReturn(door);
		map.setLocation(loc);
		map.moveNorth(loc);
		assertEquals(loc, map.getLocation());
	}
	
	// A test if a move south works if there is a door and room to the south.
	@Test
	public void legalMoveSouthTest() {
		Map map = new Map();
		Room loc = Mockito.mock(Room.class);
		Room loc2 = Mockito.mock(Room.class);
		Door door = Mockito.mock(Door.class);
		Mockito.when(loc.getSouthRoom()).thenReturn(loc2);
		Mockito.when(loc.getSouthDoor()).thenReturn(door);
		map.setLocation(loc);
		map.moveSouth(loc);
		assertEquals(loc2, map.getLocation());
	}
	
	// A test that a move south doesn't do anything if there is not a door there.
	@Test
	public void illegalMoveSouthNoDoorTest() {
		Map map = new Map();
		Room loc = Mockito.mock(Room.class);
		Room loc2 = Mockito.mock(Room.class);
		Mockito.when(loc.getSouthRoom()).thenReturn(loc2);
		Mockito.when(loc.getSouthDoor()).thenReturn(null);
		map.setLocation(loc);
		map.moveSouth(loc);
		assertEquals(loc, map.getLocation());
	}
	
	// A test that a move south doesn't do anything if there is not a room there.
	@Test
	public void illegalMoveSouthNoRoomTest() {
		Map map = new Map();
		Room loc = Mockito.mock(Room.class);
		Door door = Mockito.mock(Door.class);
		Mockito.when(loc.getSouthRoom()).thenReturn(null);
		Mockito.when(loc.getSouthDoor()).thenReturn(door);
		map.setLocation(loc);
		map.moveSouth(loc);
		assertEquals(loc, map.getLocation());
	}
}
