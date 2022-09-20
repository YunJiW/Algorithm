import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];
		
		dp[1] = 1;
		int min;
		for(int index =2 ; index <=N;index++)
		{
			min = Integer.MAX_VALUE;
			
			
			for(int i=1;i*i <=index;i++) {
				min = Math.min(min, dp[index - i*i]);
			}
			
			
			dp[index] = min+1;
		}
		
		
		
		
		
		
		System.out.println(dp[N]);

	}
}
