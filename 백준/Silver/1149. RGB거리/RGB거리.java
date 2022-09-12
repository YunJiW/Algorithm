import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	static int C_R = 0;
	static int C_G = 1;
	static int C_B = 2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] color_money = new int[N][3];

		for (int index = 0; index < N; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			color_money[index][C_R] = Integer.parseInt(st.nextToken());
			color_money[index][C_G] = Integer.parseInt(st.nextToken());
			color_money[index][C_B] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int index = 1 ; index<N;index++)
		{
			color_money[index][C_R] += Math.min(color_money[index-1][C_G],color_money[index-1][C_B]) ;
			color_money[index][C_G] += Math.min(color_money[index-1][C_R],color_money[index-1][C_B]) ;
			color_money[index][C_B] += Math.min(color_money[index-1][C_G],color_money[index-1][C_R]) ;
		}
		
		System.out.println(Math.min(Math.min(color_money[N-1][C_R],color_money[N-1][C_G]),color_money[N-1][C_B]));
		
	}

}
