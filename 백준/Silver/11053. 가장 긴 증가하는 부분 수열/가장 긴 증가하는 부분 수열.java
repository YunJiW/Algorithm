import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];
		int[] dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int index = 0; index < N; index++) {
			A[index] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			dp[i] = 1;

			for (int j = 0; j < i; j++) {
				if (A[j] < A[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}

		}
		int max = -1;
		
		for(int index = 0; index<N;index++)
		{
			if(max <= dp[index])
				max =dp[index];
		}
		System.out.println(max);
	}
}
