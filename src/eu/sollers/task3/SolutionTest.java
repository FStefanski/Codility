package eu.sollers.task3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Frederik Stefanski
 *
 */
class SolutionTest {

	Solution solTest = new Solution();

	@Test
	void example() {
		assertEquals(solTest.solution(new int[] { 1, 2, 3 }), 2);
	}

	@Test
	void example1() {
		assertEquals(solTest.solution(new int[] { 1, 1, 6 }), 2);
	}

	@Test
	void example2() {
		assertEquals(solTest.solution(new int[] { 1, 6, 2, 3 }), 3);
	}

	@Test
	void nullTest() {
		assertEquals(solTest.solution(null), 0);
	}

	@Test
	void oneElement() {
		assertEquals(solTest.solution(new int[] { 1 }), 0);
	}

	@Test
	void twoElements() {
		assertEquals(solTest.solution(new int[] { 1, 2 }), 1);
	}

	@Test
	void twoParalelElements() {
		assertEquals(solTest.solution(new int[] { 5, 2 }), 2);
	}

	// TODO
	// @Test
	// void elementsOutOfRange() {
	// assertEquals(solTest.solution(new int[] { 5, 2, 8, 9 }), 2);
	// }
	//
	// @Test
	// void elementsOutOfRange2() {
	// assertEquals(solTest.solution(new int[] { 5, 1, 4, 8, 9 }), 2);
	// }
}
