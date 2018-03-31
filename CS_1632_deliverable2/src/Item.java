public class Item {
	public String adjective1;
	public String adjective2;
	public String noun;

	public Item(String adj1, String adj2, String n) {
		adjective1 = adj1;
		adjective2 = adj2;
		noun = n;
	}
	
	public String getAdj1() {
		return adjective1;
	}
	
	public String getAdj2() {
		return adjective2;
	}
	
	public String getNoun() {
		return noun;
	}
}