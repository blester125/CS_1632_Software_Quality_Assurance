public class Door {
	public String adjective;
	public String direction;

	public Door(String adj, String dir) {
		adjective = adj;
		direction = dir;
	}

	public String toString() {
		return "A " + adjective + " door leads " + direction + ".";
	}
}