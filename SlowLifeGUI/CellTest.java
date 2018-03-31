import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class CellTest {
	
	public static Cell cell;
	public static char[] randomUpperLetters = new char[100];
	public static char[] randomLowerLetters = new char[100];
	
	@Before
	public void setUp() {
		cell = new Cell();
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			char letter = (char)(rand.nextInt(27) + 65);
			if (letter == 'X') {
				continue;
			} else {
				randomUpperLetters[i] = letter;
			}
		}
		for (int i = 0; i < 100; i++) {
			char letter = (char)(rand.nextInt(27) + 95);
			randomUpperLetters[i] = letter;
		}
	}

	@Test
	public void xUpperTest() {
		cell.setText("X");
		String test = cell.toString();
		assertEquals("X", test);
	}
	
	@Test
	public void xLowerTest() {
		cell.setText("x");
		String test = cell.toString();
		assertEquals(".", test);
	}
	
	@Test
	public void otherUpperTest() {
		for (int i = 0; i < randomUpperLetters.length; i++) {
			String word = "" + randomUpperLetters[i];
			cell.setText(word);
			String test = cell.toString();
			assertEquals(".", test);
		}
	}
	
	@Test
	public void otherLowerTest() {
		for (int i = 0; i < randomLowerLetters.length; i++) {
			String word = "" + randomLowerLetters[i];
			cell.setText(word);
			String test = cell.toString();
			assertEquals(".", test);
		}
	}
	
	@Test
	public void xWordTest() {
		cell.setText("Xhgfjdf");
		String test = cell.toString();
		assertEquals("X", test);
	}
	
	@Test
	public void xLowerWordTest() {
		cell.setText("xhgfjdf");
		String test = cell.toString();
		assertEquals(".", test);
	}
	
	@Test
	public void otherWordTest() {
		cell.setText("adasfres");
		String test = cell.toString();
		assertEquals(".", test);
	}

}
