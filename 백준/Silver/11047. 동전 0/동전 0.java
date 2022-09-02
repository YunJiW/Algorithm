import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 동전 개수
		int N = Integer.parseInt(st.nextToken());

		// 만들어야하는 값
		int K = Integer.parseInt(st.nextToken());

		int[] coin = new int[N];
		
		int coin_cnt = 0;
		
		
		// 동전의 값들 넣어둠
		for (int index = 0; index < N; index++) {
			coin[index] = Integer.parseInt(br.readLine());
		}
		
		for(int index = N -1 ; index >= 0 ;index--)
		{
			if(coin[index] <=K) {
				coin_cnt +=(K/coin[index]);
			}
			K = K % coin[index];
		}
		
		
		
		System.out.println(coin_cnt);

	}
}
