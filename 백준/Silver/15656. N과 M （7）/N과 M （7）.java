import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

	static int[] arr;
	static int[] nums;
	static boolean[] check;

	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];
		check = new boolean[N];
		arr = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int index = 0; index < N; index++) {
			nums[index] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);

		Sorting(0);
		
		System.out.print(sb);

	}

	private static void Sorting(int depth) {
		if (depth == M) {
			for (int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append('\n');
			return;
		}

		for (int index = 0; index < N; index++) {
			arr[depth] = nums[index];
			Sorting(depth+1);
		}
	}

}
