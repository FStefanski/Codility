package eu.sollers.task3;

import java.util.HashMap;
import java.util.Map;

/**
 * An array of N dice is given. You can turn (not roll) a dice to adjective
 * faces (sides) in one move - for 1 adjective are 2,3,4,5 and parallel is 6.
 * You can turn the dice to parallel face in two moves. All parallel faces sum
 * up to 7 (e.g. 1+6, 2+5, 3+4).
 * 
 * Find the smallest number of moves that all dice show the same number (pips).
 * 
 * Focus on correctness, performance will no be the focus of the assessment.
 * 
 * @author Frederik Stefanski
 */
public class Solution {

	public int solution(int[] A) {
		// int[] oneToSixArray = { 1, 2, 3, 4, 5, 6 }; // all possible dots (pips)

		Map<Integer, Integer> duplicatesMap = new HashMap<Integer, Integer>(); // O(n)
		// key = possible dots, value = numberOfDuplicates
		duplicatesMap.put(1, 0);
		duplicatesMap.put(2, 0);
		duplicatesMap.put(3, 0);
		duplicatesMap.put(4, 0);
		duplicatesMap.put(5, 0);
		duplicatesMap.put(6, 0);

		if (A == null) {
			return 0;
		} else {
			for (int index = 0; index < A.length; index++) { // O(n)

				// key = A[index], value = numberOfDuplicates
				duplicatesMap.put(A[index], (duplicatesMap.get(A[index]) + 1));
			}

			int minimalNumberOfTurns = 0;
			int numberOfAllTurns = 0;

			int numberOfAllElements = A.length;
			int numberOfDuplicatesDots = 0;
			int numberOfParralelDots = 0;

			for (int index = 1; index < 7; index++) { // O(n)

				numberOfDuplicatesDots = duplicatesMap.get(index);
				numberOfParralelDots = duplicatesMap.get(7 - index);

				// minimalValueOfTurns is the smallest number of turns that have to be made for
				// all elements different than the chosen dot (including two times the parallel
				// value e.g. for dot 1, 2 times number of dots 6)
				// numberOfAllTurns = NumberOfAllElements - DuplicatesOfTheActualDot +
				// numberOfParallelsDots;
				numberOfAllTurns = numberOfAllElements - numberOfDuplicatesDots + numberOfParralelDots;

				if (index == 1) {
					minimalNumberOfTurns = numberOfAllTurns;
				}
				if (numberOfAllTurns < minimalNumberOfTurns) {
					minimalNumberOfTurns = numberOfAllTurns;
				}
			}

			// System.out.println("\nElements count: \n1, 2, 3, 4, 5, 6");
			// for (Map.Entry<Integer, Integer> entry : duplicatesMap.entrySet()) {
			// System.out.print(entry.getValue() + " ");
			// }
			// System.out.println("Result " + minimalNumberOfTurns);

			return minimalNumberOfTurns;
		}

	}
}
