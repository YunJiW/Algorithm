import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	
	static long num = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[][] dp = new long[N + 1][10];

		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}

		for (int index = 2; index <= N; index++) {

			for (int checking = 0; checking < 10; checking++) {
				
				//0일때 1밖에 못받음
				if (checking == 0) {
					dp[index][checking] = dp[index - 1][1]  % num;
				}

				//9일때 8밖에 못받음
				else if (checking == 9) {
					dp[index][checking] = dp[index - 1][8] % num;
				}
				
				//그외는 +1 -1 의 합
				else {
					dp[index][checking] = (dp[index-1][checking-1] + dp[index-1][checking+1]) % num;
				}
			}
		}
		
		long sum = 0;
		
		for(int index =0; index< 10;index++)
		{
			sum += dp[N][index];
		}
		
		System.out.print(sum % num);
	}
}
