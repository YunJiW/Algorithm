import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Coordinate[] Cor = new Coordinate[N];

		for (int T = 0; T < N; T++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			// x 좌표 y좌표 입력
			Cor[T] = new Coordinate(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()));
		}

		Arrays.sort(Cor, new Comparator<Coordinate>() {

			@Override
			public int compare(Coordinate o1, Coordinate o2) {
				//x축비교
				if (o1.x > o2.x || o1.x < o2.x) {
					return o1.x - o2.x;
					//x축이 같을 경우 y 축비교
				} else {
					return o1.y - o2.y;
				}
			}

		});
		StringBuilder sb = new StringBuilder();

		for (int chk = 0; chk < N; chk++) {
			sb.append(Cor[chk]);
		}
		
		System.out.println(sb);

	}

	public static class Coordinate {
		int x;
		int y;

		Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return x + " " + y + "\n";
		}
	}
}
