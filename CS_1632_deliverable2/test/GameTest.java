import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class GameTest {

	// Testing to getter functions. These return a member variable so they should 
	// always be equal to the value of the member.
	@Test
	public void isOverNotDoneTest() {
		Game g = new Game();
		assertEquals(true, g.isOver());
	}
	
	// Testing to getter functions. These return a member variable so they should 
	// always be equal to the value of the member.
	@Test
	public void getResultsTest() {
		Game g = new Game();
		assertEquals("The End!", g.getResult());
	}
	
	// A test of the input parseing, This input is N and is testing that the game 
	// tries to go north when it is entered.
	@Test
	public void parseInputNTest () {
		Game g = new Game();
		Map m = Mockito.mock(Map.class);
		g.map = m;
		Room room = Mockito.mock(Room.class);
		Mockito.when(m.getLocation()).thenReturn(room);
		Mockito.when(m.moveNorth(room)).thenReturn(true);
		g.parseInput("N");
		Mockito.verify(m).moveNorth(room);
	}
	
	// A test the a lower case n causes the same north moving effect as N
	@Test
	public void parseInputnTest () {
		Game g = new Game();
		Map m = Mockito.mock(Map.class);
		g.map = m;
		Room room = Mockito.mock(Room.class);
		Mockito.when(m.getLocation()).thenReturn(room);
		Mockito.when(m.moveNorth(room)).thenReturn(true);
		g.parseInput("n");
		Mockito.verify(m).moveNorth(room);
	}

	// A test that S tries to move south.
	@Test
	public void parseInputSTest () {
		Game g = new Game();
		Map m = Mockito.mock(Map.class);
		g.map = m;
		Room room = Mockito.mock(Room.class);
		Mockito.when(m.getLocation()).thenReturn(room);
		Mockito.when(m.moveSouth(room)).thenReturn(true);
		g.parseInput("S");
		Mockito.verify(m).moveSouth(room);
	}
	
	// A test that an L input causes the player to look in the room
	@Test
	public void parseInputLTest () {
		Game g = new Game();
		Map m = Mockito.mock(Map.class);
		Player p = Mockito.mock(Player.class);
		g.map = m;
		g.player = p;
		Room room = Mockito.mock(Room.class);
		Mockito.when(m.getLocation()).thenReturn(room);
		Mockito.when(p.look(room)).thenReturn(true);
		g.parseInput("L");
		Mockito.verify(p).look(room);
	}

	// A test that an I checks the inventory
	@Test
	public void parseInputITest () {
		Game g = new Game();
		Map m = Mockito.mock(Map.class);
		Player p = Mockito.mock(Player.class);
		g.map = m;
		g.player = p;
		Room room = Mockito.mock(Room.class);
		Mockito.when(m.getLocation()).thenReturn(room);
		Mockito.when(p.checkInventory()).thenReturn(0);
		g.parseInput("I");
		Mockito.verify(p).checkInventory();
	}

	// A test that D causes the end game actions
	@Test
	public void parseInputDTest () {
		Game g = new Game();
		Map m = Mockito.mock(Map.class);
		Player p = Mockito.mock(Player.class);
		g.map = m;
		g.player = p;
		Room room = Mockito.mock(Room.class);
		Mockito.when(m.getLocation()).thenReturn(room);
		Mockito.when(p.checkInventory()).thenReturn(0);
		Mockito.when(p.getItems()).thenReturn(new Item[3]);
		g.parseInput("D");
		Mockito.verify(p).checkInventory();
	}
	
	// A test that other inputs don't cause actions.
	@Test
	public void parseInputOtherTest() {
		Game g = new Game();
		assertEquals(false, g.parseInput("X"));
	}
	
	// A test of setting the results strings based on items that are collected
	// This case is with no items.
	@Test
	public void setResultNoItems() {
		Item[] items = new Item[3];
		Game g = new Game();
		g.setResult(items);
		assertEquals("You drink the air, as you have no coffee, sugar, or cream. The air is invigorating, but not invigorating enough.  You cannot study.\nYou lose!", g.getResult());
	}
	
	// A test of setting the results strings based on items that are collected
	// This case is with the coffe item.
	@Test
	public void setResultCoffeeItems() {
		Item i = Mockito.mock(Item.class);
		Item[] items = new Item[3];
		items[0] = i;
		Game g = new Game();
		g.setResult(items);
		assertEquals("Without cream, you get an ulcer and cannot study.\nYou lose!", g.getResult());
	}
	
	// A test of setting the results strings based on items that are collected
	// This case is with the Cream item.
	@Test
	public void setResultCreamItems() {
		Item i = Mockito.mock(Item.class);
		Item[] items = new Item[3];
		items[1] = i;
		Game g = new Game();
		g.setResult(items);
		assertEquals("You drink the cream, but without caffeine, you cannot study.\nYou lose!", g.getResult());
	}
	
	// A test of setting the results strings based on items that are collected
	// This case is with the sugar item.
	@Test
	public void setResultSugarItems() {
		Item i = Mockito.mock(Item.class);
		Item[] items = new Item[3];
		items[2] = i;
		Game g = new Game();
		g.setResult(items);
		assertEquals("You eat the sugar, but without caffeine, you cannot study.\nYou lose!", g.getResult());
	}
	
	// A test of setting the results strings based on items that are collected
	// This case is with the Coffee and Cream items.
	@Test
	public void setResultCoffeeCreamItems() {
		Item i = Mockito.mock(Item.class);
		Item[] items = new Item[3];
		items[0] = i;
		items[1] = i;
		Game g = new Game();
		g.setResult(items);
		assertEquals("Without sugar, the coffee is too bitter.  You cannot study.\nYou lose!", g.getResult());
	}
	
	// A test of setting the results strings based on items that are collected
	// This case is with the Cream and Sugar items.
	@Test
	public void setResultCreamSugarItems() {
		Item i = Mockito.mock(Item.class);
		Item[] items = new Item[3];
		items[1] = i;
		items[2] = i;
		Game g = new Game();
		g.setResult(items);
		assertEquals("You drink the sweetened cream, but without caffeine, you cannot study.\nYou lose!", g.getResult());
	}
	
	// A test of setting the results strings based on items that are collected
	// This case is with all the items.
	@Test
	public void setResultAllItems() {
		Item i = Mockito.mock(Item.class);
		Item[] items = new Item[3];
		items[0] = i;
		items[1] = i;
		items[2] = i;
		Game g = new Game();
		g.setResult(items);
		assertEquals("You drink the beverage and are ready to study!\nYou win!", g.getResult());
	}
}
