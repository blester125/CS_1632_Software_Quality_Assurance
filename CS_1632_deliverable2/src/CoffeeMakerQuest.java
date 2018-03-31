public class CoffeeMakerQuest {

	public static void main(String args[]) {
		System.out.println("Coffee Maker Quest 2.0");
		Game game = new Game();
		while (game.isOver()) {
			game.turn();
		}
		System.out.println("\n" + game.getResult());
	}
}