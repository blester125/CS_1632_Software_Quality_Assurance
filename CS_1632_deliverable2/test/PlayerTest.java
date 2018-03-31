import static org.junit.Assert.*;

import org.junit.Test;

import org.mockito.*;
import org.junit.Before;
import org.junit.After;

public class PlayerTest {

	Item i = Mockito.mock(Item.class);
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(i);
	}
	
	@After
	public void tearDown() throws Exception {
		
	}

	// The constructor should take an input and assign it to the 
	// object. The member should be set to this value.
	@Test
	public void constructorTest() {
		Player p = new Player();
		assertEquals(3, p.items.length);
	}
	
	// A test if the coffee item can be added to inventory.
	@Test
	public void addCoffeeTest() {
		Player player = new Player();
		Mockito.when(i.getNoun()).thenReturn("coffee");
		player.addInventory(i);
		assertEquals(i, player.items[0]);
	}
	
	// A test if the cream item can be added to inventory.
	@Test
	public void addCreamTest() {
		Player player = new Player();
		Mockito.when(i.getNoun()).thenReturn("cream");
		player.addInventory(i);
		assertEquals(i, player.items[1]);
	}
	
	// A test if the sugar item can be added to inventory.
	@Test
	public void addSugarTest() {
		Player player = new Player();
		Mockito.when(i.getNoun()).thenReturn("sugar");
		player.addInventory(i);
		assertEquals(i, player.items[2]);	
	}
	
	// A test if the empty inventory works.
	@Test
	public void checkEmptyInvTest() {
		Player p = new Player();
		p.items = new Item[3];
		assertEquals(0, p.checkInventory());
	}
	
	// A test if the inventory with coffee in it works.
	@Test
	public void checkCoffeeInvTest() {
		Item i = Mockito.mock(Item.class);
		MockitoAnnotations.initMocks(i);
		Item[] items = new Item[3];
		items[0] = i;
		Player p = new Player();
		p.items = items;
		assertEquals(1, p.checkInventory());
	}
	
	// A test if the inventory with cream in it works.
	@Test
	public void checkCreamInvTest() {
		Item i = Mockito.mock(Item.class);
		MockitoAnnotations.initMocks(i);
		Item[] items = new Item[3];
		items[1] = i;
		Player p = new Player();
		p.items = items;
		assertEquals(1, p.checkInventory());
	}
	
	// A test if the inventory with sugar in it works.
	@Test
	public void checkSugarInvTest() {
		Item i = Mockito.mock(Item.class);
		MockitoAnnotations.initMocks(i);
		Item[] items = new Item[3];
		items[2] = i;
		Player p = new Player();
		p.items = items;
		assertEquals(1, p.checkInventory());
	}

	// A test if the inventory with coffee and cream in it works.	
	@Test
	public void checkCoffeCreamInvTest() {
		Item i = Mockito.mock(Item.class);
		Item i2 = Mockito.mock(Item.class);
		MockitoAnnotations.initMocks(i);
		MockitoAnnotations.initMocks(i2);
		Item[] items = new Item[3];
		items[0] = i;
		items[1] = i2;
		Player p = new Player();
		p.items = items;
		assertEquals(2, p.checkInventory());
	}
	
	// A test if the inventory with Cream and sugar in it works.
	@Test
	public void checkCreamSugarInvTest() {
		Item i = Mockito.mock(Item.class);
		Item i2 = Mockito.mock(Item.class);
		MockitoAnnotations.initMocks(i);
		MockitoAnnotations.initMocks(i2);
		Item[] items = new Item[3];
		items[1] = i;
		items[2] = i2;
		Player p = new Player();
		p.items = items;
		assertEquals(2, p.checkInventory());
	}
	
	// A test if the inventory with all the items in it works.
	@Test
	public void checkFullInvTest() {
		Item i = Mockito.mock(Item.class);
		Item i2 = Mockito.mock(Item.class);
		Item i3 = Mockito.mock(Item.class);
		MockitoAnnotations.initMocks(i);
		MockitoAnnotations.initMocks(i2);
		MockitoAnnotations.initMocks(i3);
		Item[] items = new Item[3];
		items[0] = i;
		items[1] = i2;
		items[2] = i3;
		Player p = new Player();
		p.items = items;
		assertEquals(3, p.checkInventory());
	}
	
	// A test of the look function when there is no item in the room.
	@Test
	public void lookAtNothingTest() {
		Room loc = Mockito.mock(Room.class);
		MockitoAnnotations.initMocks(loc);
		Item i = Mockito.mock(Item.class);
		MockitoAnnotations.initMocks(i);
		Mockito.when(loc.getItem()).thenReturn(null);
		Player p = new Player();
		assertEquals(false, p.look(loc));
	}
	
	// A test of the look function when there is a item in the room.
	@Test
	public void lookAtSomethingTest() {
		Room loc = Mockito.mock(Room.class);
		MockitoAnnotations.initMocks(loc);
		Item i = Mockito.mock(Item.class);
		MockitoAnnotations.initMocks(i);
		Mockito.when(i.getAdj1()).thenReturn("ADJ");
		Mockito.when(i.getNoun()).thenReturn("Noun");
		Mockito.when(loc.getItem()).thenReturn(i);
		Player p = new Player();
		assertEquals(true, p.look(loc));
	}
	
	// Testing to getter functions. These return a member variable so they should 
	// always be equal to the value of the member.
	@SuppressWarnings("deprecation")
	@Test
	public void getItems() {
		Player p = new Player();
		assertEquals(p.items, p.getItems());
	}
}
