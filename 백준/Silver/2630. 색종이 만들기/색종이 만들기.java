import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

	static int[][] paper;
	
	static int N;
	static int White=0;
	static int Blue=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		paper = new int[N][N];

		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int x = 0; x < N; x++) {
				paper[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		check(0, 0, N);

		System.out.println(White);
		System.out.println(Blue);
	}

	private static void check(int i, int j, int n) {

		if (checkpapaer(i, j, n)) {
			if(paper[j][i] == 0)
				White++;
			else
				Blue++;
			
			return;
		}
		int newSize = n / 2;

		check(i, j, newSize);
		check(i + newSize, j, newSize);
		check(i, j + newSize, newSize);
		check(i + newSize, j + newSize, newSize);
	}

	private static boolean checkpapaer(int i, int j, int n) {
		int color = paper[j][i];

		for (int y = j; y < j + n; y++) {
			for (int x = i; x < i + n; x++) {
				if (paper[y][x] != color)
					return false;
			}
		}

		return true;
	}
}
