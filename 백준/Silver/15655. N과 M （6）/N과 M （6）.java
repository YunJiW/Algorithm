import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();

	static int[] arr;
	static int[] nums;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];
		check = new boolean[N];
		arr = new int[M];

		st = new StringTokenizer(br.readLine(), " ");
		for (int index = 0; index < N; index++) {

			nums[index] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		dfs(0, 0);

		System.out.print(sb);
	}

	static void dfs(int at, int depth) {
		if (depth == M) {
			for (int nums : arr) {
				sb.append(nums).append(" ");
			}
			sb.append('\n');
			return;
		}

		for (int index = at; index < N; index++) {
			
			if(depth == 0) {
				arr[depth] = nums[index];
				dfs(at + 1, depth + 1);
			}
			else if(nums[index] > arr[depth-1]) {
				arr[depth] = nums[index];
				dfs(at + 1, depth + 1);
			}
		}
	}

}
