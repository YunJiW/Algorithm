import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

	static int INF = 123456789;

	static int Map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int bus = Integer.parseInt(br.readLine());

		Map = new int[N + 1][N + 1];

		StringTokenizer st;
		for (int index = 0; index < bus; index++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			// 비용이 다른데 같은 방향인 버스가 존재하기때문에 체크해야함.
			if (Map[start][end] > weight || Map[start][end] == 0)
				Map[start][end] = weight;
		}
		// 현재 직접적으로 못가는 곳은 INF 처리를 해둠.
		for (int row = 1; row <= N; row++) {
			for (int col = 1; col <= N; col++) {
				if (Map[row][col] == 0 && row != col) {
					Map[row][col] = INF;
				}
			}
		}
		// 전체적으로 돌면서 최소값을 계산 -> 플로이드-워셜 알고리즘. O(n^3)이기때문에 최대 도시의 개수가 중요하다.
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					Map[i][j] = Math.min(Map[i][j], Map[i][k] + Map[k][j]);
				}
			}
		}

		for (int row = 1; row <= N; row++) {
			for (int col = 1; col <= N; col++) {
				if (Map[row][col] == INF) {
					System.out.print(0 + " ");
				} else {
					System.out.print(Map[row][col] + " ");
				}
			}
			System.out.println();
		}
	}
}
