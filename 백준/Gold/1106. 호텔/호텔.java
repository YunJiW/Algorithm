import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int person = Integer.parseInt(st.nextToken());
		int city = Integer.parseInt(st.nextToken());
		
		int citys[][] = new int[city][2];
		
		//적어도 100명까지에서 최솟값이기 때문
		int dp[] = new int[person+101];

		Arrays.fill(dp,999999999);
		dp[0] = 0;
		
		
		//각 도시들의 0 -> 홍보 비용  1 -> 그에따라 놀어나는 고객
		for(int index = 0; index < city;index++) {
			st = new StringTokenizer(br.readLine());
			citys[index][0] = Integer.parseInt(st.nextToken());
			citys[index][1] = Integer.parseInt(st.nextToken());
		}
		
		
		//각 값에 대해서 최댓값구하기
		for(int index = 0; index < citys.length;index++) {
			int coin = citys[index][0];
			int coin_per_person = citys[index][1];
			for(int checking = coin_per_person; checking < person+101;checking++) {
				dp[checking] = Math.min(dp[checking],coin+dp[checking-coin_per_person]);
			}
		}
		int result = Integer.MAX_VALUE;
		for(int index = person; index < person+101;index++) {
			result = Math.min(result,dp[index]);
		}
		System.out.println(result);
	}
}
