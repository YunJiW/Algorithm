import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int Map[][] = new int[n+1][3];

		for (int index = 1; index <=n; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Map[index][0] = Integer.parseInt(st.nextToken());
			Map[index][1] = Integer.parseInt(st.nextToken());
			Map[index][2] = Integer.parseInt(st.nextToken());
		}

		int Max_dp[][] = new int[n+1][3];
		int Min_dp[][] = new int[n+1][3];

		for (int index = 0; index < 3; index++) {
			Max_dp[1][index] = Map[1][index];
			Min_dp[1][index] = Map[1][index];
		}

		for (int index = 2; index <=n; index++) {
			//최댓값
			Max_dp[index][0] = Math.max(Max_dp[index - 1][0], Max_dp[index - 1][1]) + Map[index][0];
			
			Max_dp[index][1] = Math.max(Max_dp[index - 1][0], Math.max(Max_dp[index - 1][1], Max_dp[index - 1][2]))+ Map[index][1];
			
			Max_dp[index][2] = Math.max(Max_dp[index - 1][1], Max_dp[index - 1][2]) + Map[index][2];

			
			//최소값
			Min_dp[index][0] = Math.min(Min_dp[index - 1][0], Min_dp[index - 1][1]) + Map[index][0];
			
			Min_dp[index][1] = Math.min(Min_dp[index - 1][0], Math.min(Min_dp[index - 1][1], Min_dp[index - 1][2]))+ Map[index][1];
			
			Min_dp[index][2] = Math.min(Min_dp[index - 1][1],Min_dp[index - 1][2]) + Map[index][2];

		}

		int Max = Math.max(Max_dp[n][0], Math.max(Max_dp[n][1], Max_dp[n][2]));
		int Min = Math.min(Min_dp[n][0], Math.min(Min_dp[n][1], Min_dp[n][2]));

		System.out.print(Max + " " + Min);

	}
}
