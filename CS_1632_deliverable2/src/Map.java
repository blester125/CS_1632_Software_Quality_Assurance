public class Map {
	private Room location;
	
	public Map() {
		location = null;
	}
	
	public void addRoom(Room room) {
		Room temp = location;
		if (temp == null) {
			location = room;
		} else {
			while (temp.northRoom != null) {
				temp = temp.northRoom;
			}
			temp.northRoom = room;
			room.southRoom = temp;
		}
	}
	
	public Room getLocation() {
		return location;
	}
	
	public void setLocation(Room r) {
		location = r;
	}
	
	public boolean moveNorth(Room loc) {
		if (loc.getNorthDoor() != null) {
			if (loc.getNorthRoom() != null) {
				location = loc.getNorthRoom();
				return true;
			}
		}
		return false;
	}
	
	public boolean moveSouth(Room loc) {
		if (loc.getSouthDoor() != null) {
			if (loc.getSouthRoom() != null) {
				location = loc.getSouthRoom();
				return true;
			}
		}
		return false;
	}
}
