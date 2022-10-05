import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] nums = new int[N + 1];

		long[] all = new long[N + 1];

		
		st = new StringTokenizer(br.readLine());
		for (int index = 1; index <= N; index++) {
			nums[index] = Integer.parseInt(st.nextToken());
		}

		
		all[0] = 0;
		for (int index = 1; index <= N; index++) {
			all[index] = all[index - 1] + nums[index];
		}

		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			long sum = 0;

			sum = all[end] - all[start -1];

			sb.append(sum).append('\n');
		}
		System.out.print(sb);

	}

}
