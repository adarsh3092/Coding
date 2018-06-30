package Array;

public class CorrectPossition {

	public static void main(String[] args) {
		int ar[] = { 5, 6, 8, 2, 9, 4 };// 6,
		int index[] = { 2, 0, 1, 3, 5, 4 };
		for (int i = 0; i < ar.length; i++) {
			if (index[i] != i) {
				int tmp_arr = ar[index[i]];
				int tmp_index = index[index[i]];
				ar[index[i]] = ar[i];
				ar[i] = tmp_arr;
				index[index[i]] = index[i];
				index[i] = tmp_index;
			}
		}
		for (int i : ar) {
			System.out.print(i + " ");
		}
	}

}
