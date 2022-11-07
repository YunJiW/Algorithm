import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

//부분집합을 이용해서 구역 나누고
//BFS를 활용해서 연결이 되있는지 체크
//전체적으로 방문했는지체크
public class Main {

	static int Min = Integer.MAX_VALUE;
	static int N;

	// 각 구역의 인원
	static int Person_cnt[];
	// 각 구역에 인접한 지역들
	static ArrayList<Integer>[] adj;

	// A구역 나누기 용 true -> A구역 false -> B구역
	static boolean Check_A[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); 

		Person_cnt = new int[N + 1];
		Check_A = new boolean[N + 1];
		adj = new ArrayList[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int index = 1; index <= N; index++) {
			Person_cnt[index] = Integer.parseInt(st.nextToken());
			adj[index] = new ArrayList<>();
		}

		for (int index = 1; index <= N; index++) {
			st = new StringTokenizer(br.readLine());
			int near_cnt = Integer.parseInt(st.nextToken());
			for (int near = 0; near < near_cnt; near++) {
				adj[index].add(Integer.parseInt(st.nextToken()));
			}
		}

		div_A_B(1);
		
		if(Min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(Min);

	}

	private static void div_A_B(int depth) {
		if (depth == N + 1) {

			// 각 구역이 연결이 되있을 경우 차이 값을 구해준다.
			if (Checking()) {
				int sumA = 0, sumB = 0;
				
				for(int index =1;index <=N;index++)
				{
					if(Check_A[index])
						sumA += Person_cnt[index];
					else
						sumB += Person_cnt[index];
				}
				
				Min = Math.min( Min,Math.abs(sumA - sumB));
			}

			return;
		}

		// A구역에 포함된경우
		Check_A[depth] = true;
		div_A_B(depth + 1);

		// A구역에 포함이 되지 않은 경우
		Check_A[depth] = false;
		div_A_B(depth + 1);
	}

	private static boolean Checking() {
		boolean visited[] = new boolean[N + 1];

		int chk_A = -1;
		for (int index = 1; index <= N; index++) {
			if (Check_A[index]) {
				chk_A = index;
				break;
			}
		}

		int chk_B = -1;
		for (int index = 1; index <= N; index++) {
			if (!Check_A[index]) {
				chk_B = index;
				break;
			}
		}

		// A의 구역에 포함된 구역이 하나도 없거나 B 구역에 포함된 구역이 하나도 없을 경우 false
		if (chk_A == -1 || chk_B == -1)
			return false;

		Queue<Integer> que = new LinkedList<>();

		// A 구역 부터 연결되있는지 체크함.
		que.offer(chk_A);
		visited[chk_A] = true;

		while (!que.isEmpty()) {
			int cur = que.poll();

			for (int index = 0; index < adj[cur].size(); index++) {
				// 이미 간곳의 경우
				if (visited[adj[cur].get(index)])
					continue;

				// A 구역이 아닐경우
				if (!Check_A[adj[cur].get(index)])
					continue;

				visited[adj[cur].get(index)] = true;
				que.offer(adj[cur].get(index));
			}
		}

		// B구역 체크
		que.offer(chk_B);
		visited[chk_B] = true;

		while (!que.isEmpty()) {
			int cur = que.poll();

			for (int index = 0; index < adj[cur].size(); index++) {
				// 이미 간곳의 경우
				if (visited[adj[cur].get(index)])
					continue;

				// B 구역이 아닐경우
				if (Check_A[adj[cur].get(index)])
					continue;

				visited[adj[cur].get(index)] = true;
				que.offer(adj[cur].get(index));
			}
		}

		// 전부 방문했는지 체크
		for (int index = 1; index <= N; index++) {
			if (!visited[index])
				return false;
		}

		return true;
	}

}
