import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];

		day_money[] All_day = new day_money[N + 1];

		for (int index = 0; index < N; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t_day = Integer.parseInt(st.nextToken());
			int P_money = Integer.parseInt(st.nextToken());

			All_day[index] = new day_money(t_day, P_money);
		}

		for (int index = 0; index < N; index++) {
			if (index + All_day[index].getT() <= N) {
				dp[index + All_day[index].getT()] = Math.max(dp[index + All_day[index].getT()],
						dp[index] + All_day[index].getP());
			}
			
			dp[index + 1] = Math.max(dp[index+1],dp[index]);
		}
		System.out.println(dp[N]);
	}

	static class day_money {
		private int t;
		private int p;

		day_money(int t, int p) {
			this.t = t;
			this.p = p;
		}

		public int getT() {
			return t;
		}

		public int getP() {
			return p;
		}
	}
}
