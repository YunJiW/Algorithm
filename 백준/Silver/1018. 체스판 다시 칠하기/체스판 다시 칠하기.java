import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	// 체스판 만들기용
	public static boolean[][] chess;
	// 최소값 계산하기 -> 전체 다 바꿀경우 64
	public static int min = 64;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer MN = new StringTokenizer(br.readLine(), " ");

		int M = Integer.parseInt(MN.nextToken());
		int N = Integer.parseInt(MN.nextToken());

		chess = new boolean[M][N];

		// 기본 보드 생성
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				// W일경우 true B일경우 false
				if (str.charAt(j) == 'W') {
					chess[i][j] = true;
				} else
					chess[i][j] = false;
			}
		}
		
		//경우의  수 계산
		int row = M - 7;
		int col = N - 7;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				check(i,j);
			}
		}
		
		System.out.println(min);

	}
	//다시 칠해야하는 정사각형 최솟값 계산
	private static void check(int i, int j) {
		int row = i+8;
		int col = j+8;
		
		int cnt = 0;
		//체스의 맨처음 색깔을 받아둠
		boolean check_WB = chess[i][j];
		
		for(int k = i; k < row;k++)
		{
			for(int q = j; q< col;q++)
			{
				//다를경우 cnt
				if(chess[k][q] != check_WB)
				{
					cnt++;
				}
				check_WB = (!check_WB);
			}
			check_WB = (!check_WB);
		}
		//첫번째 색깔이 반대일 경우 경우의 수와 
		cnt = Math.min(cnt,64-cnt);
		
		
		min = Math.min(min, cnt);
	}

}
