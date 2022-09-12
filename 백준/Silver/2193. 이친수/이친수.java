import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] dp = new long[N+1];
		
		dp[1] =1;
		if(N >= 2)
			dp[2] = 1;
		
		for(int index =3 ;index <=N;index++)
		{
			dp[index] = dp[index-2] + dp[index-1];
		}
		
		
		System.out.println(dp[N]);
	}
}
