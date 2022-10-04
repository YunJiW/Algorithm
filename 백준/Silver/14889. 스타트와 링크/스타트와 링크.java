import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

	public static int[][] person;
	public static boolean[] check;

	public static int min = Integer.MAX_VALUE;
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		person = new int[N][N];
		check = new boolean[N];

		for (int col = 0; col < N; col++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int row = 0; row < N; row++) {
				person[col][row] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(min);

	}

	public static void dfs(int idx,int depth) {
		if (depth == N / 2) {
			diff();
			return;
		}

		for (int index = idx; index < N; index++) {
			if (!check[index]) {
				check[index] = true;
				dfs(index+1,depth + 1);
				check[index] = false;

			}
		}
	}
	public static void diff() {
		int start = 0;
		int link = 0;

		for (int i = 0; i < N-1; i++) {
			for (int j = i + 1; j < N; j++) {
				if(check[i] ==true && check[j] == true)
				{
					start += person[i][j];
					start += person[j][i];
				}
				
				else if(check[i] == false && check[j] == false)
				{
					link += person[i][j];
					link += person[j][i];
				}

			}
		}
		int diff = Math.abs(start - link);
		
		
		if(diff == 0)
		{
			System.out.print(diff);
			System.exit(0);
		}
		
		min = Math.min(min,diff);
		
	}

}
