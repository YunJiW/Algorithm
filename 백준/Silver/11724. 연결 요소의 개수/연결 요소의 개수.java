import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	public static int[][] graph;
	public static boolean[] check;

	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 정점의 개수
		N = Integer.parseInt(st.nextToken());

		// 간선의 개수
		int M = Integer.parseInt(st.nextToken());

		graph = new int[N + 1][N + 1];
		check = new boolean[N + 1];

		for (int index = 0; index < M; index++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			graph[start][end] = graph[end][start] = 1;
		}
		int count = 0;

		for(int index =1; index <=N;index++)
		{
			if(!check[index])
			{
				dfs(index);
				count++;
			}
		}
		System.out.println(count);

	}

	public static void dfs(int start) {
		check[start] = true;
		
		for(int index = 1 ;index <=N;index++)
		{
			if(graph[start][index] == 1 && !check[index])
			{
				dfs(index);
			}
		}
		
	}
}
