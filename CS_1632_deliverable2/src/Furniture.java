public class Furniture {
	public String adjactive;
	public String noun;

	public Furniture(String adj, String noun) {
		adjactive = adj;
		this.noun = noun;
	}

	public String toString() {
		return "It has a " + adjactive + " " + noun + ".";
	}
}