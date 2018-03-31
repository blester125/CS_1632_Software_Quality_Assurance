import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class arraySortTest {

	public static int[][] randomArrays = new int[200][50];
	
	@Before
	// Generate random Arrays that will be used for testing.
	public void setUp() {
		Random r = new Random();
		for (int i = 0; i < randomArrays.length; i++) {
			int minLen = 25;
			int maxLen = 50;
			int minNum = -200;
			int maxNum = 200;
			// set length of the new array between 25 and 50
			int arrayLength = r.nextInt((maxLen - minLen) + 1) + minLen;
			int[] newArray = new int[arrayLength];
			// Fill the array with numbers from -200 to 200
			for (int j = 0; j < newArray.length; j++) {
				newArray[j] = r.nextInt((maxNum - minNum) + 1) + minNum;
			}
			randomArrays[i] = newArray;
		}
	}
	
	// Invariant: Test that the result is monotonically increasing after sort.
	@Test
	public void incresingOrderTest() {
		for (int i = 0; i < randomArrays.length; i++) {
			Arrays.sort(randomArrays[i]);
			for (int j = 0; j < randomArrays[i].length - 1; j++) {
				if (randomArrays[i][j] > randomArrays[i][j + 1]) {
					fail();
				}
			}
		}
	}

	// Invariant: Test that the output is the same size as the input.
	@Test
	public void sameSizeTest() {
		int[][] resultArrays = randomArrays.clone();
		for (int i = 0; i < randomArrays.length; i++) {
			Arrays.sort(resultArrays[i]);
			assertEquals(randomArrays[i].length, resultArrays[i].length);
		}
	}
	
	// Invariant: Test that this is pure so that two sorts on the same input 
	//            produces the same output.
	@Test
	public void pureTest() {
		for (int i = 0; i < randomArrays.length; i++) {
			int[] array1 = randomArrays[i].clone();
			Arrays.sort(randomArrays[i]);
			Arrays.sort(array1);
			assertArrayEquals(array1, randomArrays[i]);
		}
	}
	
	// Invariant: Test that this is a idempotent function. 
	//            That is, running it on the output will not change it.
	@Test
	public void idempotentTest() {
		for (int i = 0; i < randomArrays.length; i++) {
			Arrays.sort(randomArrays[i]);
			int[] array1 = randomArrays[i].clone();
			Arrays.sort(randomArrays[i]);
			assertArrayEquals(array1, randomArrays[i]);
		}
	}
}
