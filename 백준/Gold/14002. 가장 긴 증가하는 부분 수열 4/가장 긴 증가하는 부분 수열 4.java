import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 제시된 값들을 넣어둘 배열
		int number[] = new int[N];
		for (int index = 0; index < N; index++) {
			number[index] = Integer.parseInt(st.nextToken());
		}

		int dp[] = new int[N + 1];
		int tmp[] = new int[N + 1];
		int result = 0;
		int resultIdx = 0;
		for (int index = 0; index < N; index++) {
			dp[index] = 1;

			// tmp는 직전값의 위치를 저장
			for (int nums = 0; nums < index; nums++) {
				if (number[index] > number[nums] && dp[nums] + 1 > dp[index]) {
					dp[index] = dp[nums] + 1;
					tmp[index] = nums;
				}
			}
			if (dp[index] > result) {
				result = dp[index];
				resultIdx = index;
			}

		}
		int[] answer = new int[result];
		int idx = resultIdx;

		for (int check = result - 1; check>=0; check--) {
			answer[check] = number[idx];
			idx = tmp[idx];
		}
		System.out.println(answer.length);
		for(int index = 0; index <answer.length;index++) {
			System.out.print(answer[index] +" ");
		}

	}

}
