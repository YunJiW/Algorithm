import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 나무의 수 N 필요한 나무 길이 M
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 나무 높이 받아두기
		st = new StringTokenizer(br.readLine());
		int[] tree = new int[N];

		// 자르기 위해서 최대값을 받음
		int max = 0;
		int min = 0;

		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if (max < tree[i])
				max = tree[i];
		}

		while (min < max) {
			int mid = (max + min) / 2;
			long sum = 0;
			for (int i : tree) {
				if (i < mid)
					continue;
				sum = sum + (i - mid);
			}

			if (sum < M)
				max = mid;
			else
				min = mid + 1;
		}
		System.out.println(min - 1);

	}
}
