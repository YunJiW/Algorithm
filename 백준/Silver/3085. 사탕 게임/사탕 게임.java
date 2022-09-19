import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	static int N;
	static int Max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		Character[][] Candy = new Character[N][N];

		for (int row = 0; row < N; row++) {
			String s = br.readLine();
			for (int col = 0; col < s.length(); col++) {
				Candy[row][col] = s.charAt(col);
			}
		}
		char temp;

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				temp = Candy[row][col];

				if ((col + 1 < N) && (temp != Candy[row][col + 1])) {
					Candy[row][col] = Candy[row][col + 1];
					Candy[row][col + 1] = temp;

					check_max(Candy);
					Candy[row][col + 1] = Candy[row][col];
					Candy[row][col] = temp;
				}

				if ((row + 1 < N) && (temp != Candy[row + 1][col])) {
					Candy[row][col] = Candy[row + 1][col];
					Candy[row + 1][col] = temp;

					check_max(Candy);

					Candy[row + 1][col] = Candy[row][col];
					Candy[row][col] = temp;
				}

				if ((col - 1 > 0) && (temp != Candy[col - 1][row])) {
					Candy[row][col] = Candy[row][col - 1];
					Candy[row][col - 1] = temp;

					check_max(Candy);

					Candy[row][col - 1] = Candy[row][col];
					Candy[row][col] = temp;
				}

				if ((row - 1 > 0) && (temp != Candy[row - 1][col])) {
					Candy[row][col] = Candy[row - 1][col];
					Candy[row - 1][col] = temp;

					check_max(Candy);

					Candy[row - 1][col] = Candy[row][col];
					Candy[row][col] = temp;
				}

			}
		}
		System.out.println(Max);

	}

	public static void check_max(Character[][] ck) {
		// 행중에 가장 큰값
		for (int rows = 0; rows < N; rows++) {
			int cnt = 1;
			for (int cols = 0; cols < N-1; cols++) {
				if(ck[rows][cols] == ck[rows][cols+1])
				{
					cnt++;
				}
				else
					cnt = 1;
				Max = Math.max(Max, cnt);
			}
		}
		// 열중에 가장 큰값
		for (int rows = 0; rows < N; rows++) {
			int cnt =1;
			for (int cols = 0; cols < N-1; cols++) {
				if(ck[cols][rows] == ck[cols+1][rows])
				{
					cnt++;
				}else
					cnt =1;
                Max = Math.max(Max, cnt);
			}
			
		}
	}
}
