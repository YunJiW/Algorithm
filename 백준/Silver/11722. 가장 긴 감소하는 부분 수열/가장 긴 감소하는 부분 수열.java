import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];
		int[] dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int index = 0; index < N; index++) {
			A[index] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i <N;i++)
		{
			dp[i] = 1;
			for(int j = 0; j<i;j++)
			{
				if(A[j] > A[i] && dp[j] >= dp[i])
					dp[i] = dp[j]+1;
			}
		}
		
		int max =Integer.MIN_VALUE;
		
		for(int num : dp) {
			max = Math.max(max,num);
		}
		System.out.println(max);
	}
}
