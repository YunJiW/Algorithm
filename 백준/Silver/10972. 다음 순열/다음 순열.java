import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] permutation = new int[N];

		for (int index = 0; index < N; index++) {
			permutation[index] = Integer.parseInt(st.nextToken());
		}

		if (next_permutation(permutation)) {
			for (int nums : permutation) {
				System.out.print(nums + " ");
			}
			System.out.println();
		} else {
			System.out.println(-1);
		}

	}

	static boolean next_permutation(int[] arr) {
		int a = arr.length - 1;
		while (a > 0 && arr[a - 1] >= arr[a])
			a--;
		if (a <= 0)
			return false;

		int b = arr.length - 1;
		while (arr[a - 1] >= arr[b])
			b--;

		int tmp = arr[a - 1];
		arr[a - 1] = arr[b];
		arr[b] = tmp;

		int start = a;
		int end = arr.length - 1;

		while (start < end) {
			tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			start++;
			end--;
		}

		return true;
	}

}
