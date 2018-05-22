package eu.sollers.task1;

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
		assertEquals(solTest.solution(new int[] { 1, 1, 0, 1, 0, 0 }), 4);
	}

//	@Test
//	void nullTest() {
//		assertEquals(solTest.solution(null), -1);
//	}

	@Test
	void oneElementTest() {
		assertEquals(solTest.solution(new int[] { 1 }), 0);
	}

	@Test
	void twoDiffElementsTest() {
		assertEquals(solTest.solution(new int[] { 1, 0 }), 1); // one must be reversed!
	}

	@Test
	void twoTheSameElementsTest() {
		assertEquals(solTest.solution(new int[] { 1, 1 }), 0); // one must be reversed!
	}

	@Test
	void test1() {
		assertEquals(solTest.solution(new int[] { 1, 0, 0, 1, 0, 0 }), 4);
	}

	@Test
	void test2() {
		assertEquals(solTest.solution(new int[] { 1, 0, 0 }), 2);
	}

	@Test
	void allTheSame() {
		assertEquals(solTest.solution(new int[] { 1, 1, 1, 1, 1, 1 }), 4); // one must be reversed!
	}

}
