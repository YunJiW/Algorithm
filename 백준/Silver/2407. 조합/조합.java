import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	
	public static BigInteger[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		
		dp = new BigInteger[n+1][n+1];
		
		for(int index =1; index<=n;index++) {
			for(int i = 0; i<=index; i++)
			{
				if(i == index || i == 0)
					dp[index][i] = new BigInteger("1");
				else
					dp[index][i] = dp[index-1][i-1].add(dp[index-1][i]);
			}
		}
		
		System.out.println(dp[n][r]);
	}
}
