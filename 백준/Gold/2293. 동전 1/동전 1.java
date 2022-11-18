import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
public class Main {
	
	static int N;
	static int K;
	
	static int Coin_value[];
	
	static int Cnt = 0;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Coin_value = new int[N+1];
		
		for(int index = 1 ; index <=N ;index++){
			Coin_value[index] = Integer.parseInt(br.readLine());
		}
		
		int dp[] = new int[K+1];
		dp[0] = 1;
		
		for(int i = 1; i <=N;i++)
		{
			for(int j = Coin_value[i]; j <=K;j++)
			{
				dp[j] += dp[j - Coin_value[i]];
			}
		}
		
		
		System.out.println(dp[K]);
	}

}
