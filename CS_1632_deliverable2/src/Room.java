public class Room {
	public String adjective;
	public Furniture furnishing;
	public Door northDoor;
	public Door southDoor;
	public Room northRoom;
	public Room southRoom;
	public Item item;

	public Room(String adj, Furniture f, Door n, Door s, Item i) {
		adjective = adj;
		furnishing = f;
		northDoor = n;
		northRoom = null;
		southDoor = s;
		southRoom = null;
		item = i;
	}

	public Item getItem() {
		return item;
	}
	
	public Room getNorthRoom() {
		return northRoom;
	}
	
	public Door getNorthDoor() {
		return northDoor;
	}
	
	public Room getSouthRoom() {
		return southRoom;
	}
	
	public Door getSouthDoor() {
		return southDoor;
	}
	
	public String toString() {
		String s = "You see a " + adjective + " room.\n";
		s += furnishing.toString() + "\n";
		if (northDoor != null) {
			s += northDoor.toString() + "\n";
		}
		if (southDoor != null) {
			s += southDoor.toString() + "\n";
		}
		return s;
	}
}
