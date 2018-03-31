public class Player {
	public Item items[];
	public String item_names[] = {"COFFEE", "CREAM", "SUGAR"};
	// Item 1 is coffee - caffeinated, delicious
	// Item 2 is cream - creamy, fresh
	// Item 3 is sugar - sweet, tasty

	public Player() {
		items = new Item[3];
	}

	public void addInventory(Item i) {
		switch (i.getNoun()) {
			case "coffee":
				items[0] = i;
				break;
			case "cream":
				items[1] = i;
				break;
			case "sugar":
				items[2] = i;
				break;
		}
	}

	public int checkInventory() {
		int sum = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i] == null) {
				System.out.println("YOU HAVE NO " + item_names[i] + "!");
			}
			else {
				if (i == 0) {
					System.out.println("You have a cup of " + items[i].getAdj2() + " " + items[i].getNoun() + ".");
				} else {
					System.out.println("You have some " + items[i].getAdj2() + " " + items[i].getNoun() + ".");
				}
				sum++;
			}
		}
		return sum;
	}

	public boolean look(Room location) {
		Item i = location.getItem();
		if (i == null) {
			System.out.println("You don't see anything out of the ordinary.");
			return false;
		} else {
			System.out.println("There might be something here...");
			System.out.println("You found some " + i.getAdj1() + " " + i.getNoun());
			addInventory(i);
			return true;
		}
	}

	public Item[] getItems() {
		return items;
	}
}