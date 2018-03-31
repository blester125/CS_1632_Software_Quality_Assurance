import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class MainPanelTest {

	public static MainPanel main;
	public static int randomInput[] = new int[100];
	
	@Before
	public void setUp() {
		main = new MainPanel(15);
		Random rand = new Random();
		for (int i = 0; i < randomInput.length; i++) {
			randomInput[i] = rand.nextInt(401);
			System.out.println(randomInput[i]);
		}
	}
	
	@Test
	public void handlePositive() {
		int returnedInt = main.convertToInt(1);
		assertEquals(1, returnedInt);
	}
	
	@Test
	public void handleNegative() {
		try {
			int reurnedInt = main.convertToInt(-1);
			fail();
		} catch (NumberFormatException e) {
			assertEquals(1,1);
		}
	}
	
	@Test
	public void handleZero() {
		assertEquals(0, main.convertToInt(0));
	}
}
