import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int map[][] = new int[N][M];

		for (int col = 0; col < N; col++) {
			String S = br.readLine();
			for (int row = 0; row < M; row++) {
				map[col][row] = S.charAt(row) - '0';
			}
		}
		
		int len = Math.min(N, M);
		
		while(len >=1)
		{
			for(int col = 0; col<=N-len;col++)
			{
				for(int row=0;row <= M-len; row++)
				{
					int num = map[col][row];
					if(num == map[col][row+len-1] && num == map[col+len-1][row] && num == map[col+len-1][row+len-1])
					{
						System.out.print(len*len);
						return;
					}
				}
			}
			len --;
		}

	}
}
