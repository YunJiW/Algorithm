import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int P_Nums = Integer.parseInt(br.readLine());

		int[][] State = new int[P_Nums][2];
		int[] ranking = new int[P_Nums];

		for (int i = 0; i < P_Nums; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 각 몸무게 와 키를 넣어둠.
			State[i][0] = x;
			State[i][1] = y;
		}

		for (int i = 0; i < P_Nums; i++) {
			int cnt = 1;
			for (int j = 0; j < P_Nums; j++) {
				if(i == j)
					continue;
				//둘 다 작으면 cnt++;
				if(State[i][0] < State[j][0])
				{
					if(State[i][1] < State[j][1])
						cnt++;
				}
			}
			ranking[i] = cnt;
		}
		
		for(int i : ranking)
			System.out.println(i);

	}
}
