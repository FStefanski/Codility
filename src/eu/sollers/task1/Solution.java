package eu.sollers.task1;

/**
 * A[] is an array of 0 and 1 - find max number of possible same values which
 * are adjacent (0 or 1, e.g. 00, 11), if is changed from 0 to 1 or vice versa
 * (on coin must be reversed!) or vice versa. E.g. 110100 => max result is 2 (2
 * different pairs 11 and 00), change one 0 to 1 gives 111100 => max result is 4
 * (4 different pairs 11, 11, 11, 00). Focus on correctness, performance will no
 * be the focus of the assessment.
 * 
 * You can change at most three lines.
 *
 * @author Frederik Stefanski
 */
public class Solution {

	public int solution(int[] A) {
		int n = A.length;
		int result = 0; // result before coin reverse
		for (int i = 0; i < n - 1; i++) {
			if (A[i] == A[i + 1])
				result = result + 1;
		}
		int r = -1; // change 1: int r = 0; result after coin reverse
		// if reversing values has no positive effect it always has an negative in
		// breaking one pair since start r = -1 => result = result + r;
		for (int i = 0; i < n; i++) {
			int count = 0;
			if (i > 0) {
				if (A[i - 1] != A[i])
					count = count + 1;
				else
					count = count - 1;
			}
			if (i < n - 1) {
				if (A[i + 1] != A[i])
					count = count + 1;
				else
					count = count - 1;
			}
			r = Math.max(r, count);
		}
		return result + r;
	}

	public static void main(String[] args) {
		Solution solTest = new Solution();

		System.out.println(solTest.solution(new int[] { 1, 1, 0, 1, 0, 0 })); // 4

		System.out.println(solTest.solution(new int[] { 1, 0, 0, 1, 0, 0 })); // 4

		System.out.println(solTest.solution(new int[] { 1, 0, 0 })); // 2

		System.out.println(solTest.solution(new int[] { 1, 1, 1, 1, 1, 1 })); // 5
	}
}

/* original code */
// public int solution(int[] A) {
// int n = A.length;
// int result = 0;
// for (int i = 0; i < n - 1; i++) {
// if (A[i] == A[i + 1])
// result = result + 1;
// }
// int r = 0;
// for (int i = 0; i < n; i++) {
// int count = 0;
// if (i > 0) {
// if (A[i - 1] != A[i])
// count = count + 1;
// else
// count = count - 1;
// }
// if (i < n - 1) {
// if (A[i + 1] != A[i])
// count = count + 1;
// else
// count = count - 1;
// }
// r = Math.max(r, count);
// }
// return result + r;
// }
