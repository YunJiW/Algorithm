import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	static int F;
	static int S;
	static int G;
	static int U;
	static int D;

	static int button_cnt = 0;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		check = new boolean[F+1];

		int cnt = bfs();

		if (cnt == -1) {
			System.out.print("use the stairs");
		} else {
			System.out.println(cnt);
		}

	}

	public static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(S);
		check[S] = true;

		while (!q.isEmpty()) {
			int floor = q.poll();

			if (floor != 0) {
				if (floor == G)
					return button_cnt;

				if (floor + U <= G && floor + U <= F && U != 0) {
					if (!check[floor + U]) {
						check[floor + U] = true;
						q.offer(floor + U);
						button_cnt++;
					}
				} else if (D != 0 && floor - D <= 0 && floor + U <= F) {
					if (!check[floor + U]) {
						check[floor + U] = true;
						q.offer(floor + U);
						button_cnt++;
					}
				} else if (D != 0 && floor - D > 0) {
					if (!check[floor - D]) {
						check[floor - D] = true;
						q.offer(floor - D);
						button_cnt++;
					}
				}
			}
		}
		return -1;
	}
}
