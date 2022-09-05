import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static boolean[] check;
	static int[][] arr;

	static int N;
	static int M;
	static int V;

	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];

		// 방문여부확인
		check = new boolean[N + 1];

		for (int index = 0; index < M; index++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			arr[start][end] = arr[end][start] = 1;

		}
		dfs(V);
		sb.append("\n");
		check = new boolean[N+1];
		
		bfs(V);
		
		System.out.println(sb);

	}

	//DFS 풀이
	public static void dfs(int start) {
		check[start] = true;
		sb.append(start + " ");

		for (int index = 0; index <= N; index++) {
			if (arr[start][index] == 1 && !check[index]) {
				dfs(index);
			}

		}
	}

	//BFS풀이
	public static void bfs(int start) {
		q.offer(start);
		check[start] = true;

		while (!q.isEmpty()) {
			start = q.poll();
			sb.append(start + " ");

			for (int index = 1; index <= N; index++) {
				if(arr[start][index] == 1 & !check[index])
				{
					q.offer(index);
					check[index] = true;
				}
			}
		}
	}
}
