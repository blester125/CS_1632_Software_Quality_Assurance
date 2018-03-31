import java.io.*;

public class Game {
	public Player player;
	public Map map;
	private final String instructions = " INSTRUCTIONS (N,S,L,I,H,D) >";
	private boolean isDone;
	private String result;
	private BufferedReader bf;

	public Game() {
		map = new Map();
		bf = new BufferedReader(new InputStreamReader(System.in));
		isDone = false;
		result = "The End!";
		buildDefaultBoard(map);
		player = new Player();
	}

	private void buildDefaultBoard(Map map) {
		Furniture f = new Furniture("Quaint", "sofa");
		Door north = new Door("Magenta", "North");
		Item cream = new Item("creamy", "fresh", "cream");
		map.addRoom(new Room("Small", f, north, null, cream));
		Furniture f2 = new Furniture("Sad", "record player");
		Door north2 = new Door("Beige", "North");
		Door south2 = new Door("Massive", "South");
		map.addRoom(new Room("Funny", f2, north2, south2, null));
		Furniture f3 = new Furniture("Tight", "pizza");
		Door north3 = new Door("Dead", "North");
		Door south3 = new Door("Smart", "South");
		Item coffee = new Item("caffeinated", "delicious", "coffee");
		map.addRoom(new Room("Refinanced", f3, north3, south3, coffee));
		Furniture f4 = new Furniture("Flat", "energy drink");
		Door north4 = new Door("Vivacious", "North");
		Door south4 = new Door("Slim", "South");
		map.addRoom(new Room("Dumb", f4, north4, south4, null));
		Furniture f5 = new Furniture("Beautiful", "bag of money");
		Door north5 = new Door("Purple", "North");
		Door south5 = new Door("Sandy", "South");
		map.addRoom(new Room("Bloodthirsty", f5, north5, south5, null));
		Furniture f6 = new Furniture("Perfect", "air hockey table");
		Door south = new Door("Minimalist", "South");
		Item sugar = new Item("sweet", "tasty", "sugar");
		map.addRoom(new Room("Rough", f6, null, south, sugar));
	}
	
	public void turn() {
		System.out.println("\n" + map.getLocation().toString() + "\n");
		System.out.println(instructions);
		try {
			String userInput = bf.readLine();
			parseInput(userInput);
		} catch (IOException e) {
			System.out.println("Error reading input");
		}
	}

	public boolean parseInput(String userInput) {
		String input = userInput.toUpperCase();
		switch (input) {
			case "N":
				// North
				map.moveNorth(map.getLocation());
				break;
			case "S":
				// South
				map.moveSouth(map.getLocation());
				break;
			case "L":
				// Look
				player.look(map.getLocation());
				break;
			case "I":
				// Inventory
				player.checkInventory();
				break;
			case "D":
				player.checkInventory();
				setResult(player.getItems());
				isDone = true;
				break;
			case "H":
				// Help
				System.out.println("HELP");
				break;
			default:
				System.out.println("What?");
				return false;
		}
		return true;
	}

	public boolean isOver() {
		return !isDone;
	}

	public void setResult(Item[] items) {
		boolean coffee = false;
		boolean cream = false;
		boolean sugar = false;
		if (items[0] != null) {
			coffee = true;
		}
		if (items[1] != null) {
			cream = true;
		}
		if (items[2] != null) {
			sugar = true;
		}
		if (coffee && cream && sugar) {
			result = "You drink the beverage and are ready to study!\nYou win!";
		}
		else if (coffee && sugar && !cream) {
			result = "You eat the sugar, but without caffeine, you cannot study.\nYou lose!";
		}
		else if (!coffee && cream && sugar) {
			result = "You drink the sweetened cream, but without caffeine, you cannot study.\nYou lose!";
		}
		else if (!sugar && cream && coffee) {
			result = "Without sugar, the coffee is too bitter.  You cannot study.\nYou lose!";
		}
		else if (!coffee && !cream && sugar) {
			result = "You eat the sugar, but without caffeine, you cannot study.\nYou lose!";
		}
		else if (coffee && !cream && !sugar) {
			result = "Without cream, you get an ulcer and cannot study.\nYou lose!";
		}
		else if (!coffee && cream && !sugar) {
			result = "You drink the cream, but without caffeine, you cannot study.\nYou lose!";
		}
		else {
			result = "You drink the air, as you have no coffee, sugar, or cream. The air is invigorating, but not invigorating enough.  You cannot study.\nYou lose!";
		}
	}

	public String getResult() {
		return result;
	}
}
