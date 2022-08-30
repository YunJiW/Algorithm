import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// Block 개수
		int B = Integer.parseInt(st.nextToken());

		int[][] Grass = new int[N][M];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		// 땅 입력 땅의 최소값과 최대값을 적어둠.
		for (int cols = 0; cols < N; cols++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int rows = 0; rows < M; rows++) {
				Grass[cols][rows] = Integer.parseInt(st.nextToken());
				if (min > Grass[cols][rows])
					min = Grass[cols][rows];
				if (max < Grass[cols][rows])
					max = Grass[cols][rows];
			}
		}
		//최소 땅높이와 시간 체크용
		int minTime = Integer.MAX_VALUE;
		int height = 0;

		// 최솟값부터 해서 최대값까지 블럭 땅 고르는데 걸리는 시간과 땅의 높이 출력
		for (int heght = min; heght <= max; heght++) {
			int Block = B;
			int time = 0;

			for (int cols = 0; cols < N; cols++) {
				for (int rows = 0; rows < M; rows++) {
					//땅 파기
					if(Grass[cols][rows] > heght) {
						time += (Grass[cols][rows] - heght)*2;
						Block += (Grass[cols][rows] - heght);
					}
					//땅 쌓기
					else if(Grass[cols][rows] < heght) {
						time +=(heght - Grass[cols][rows]);
						Block -=(heght - Grass[cols][rows]);
					}
				}
			}
			if(Block >= 0 && minTime >= time) {
				minTime = time;
				height = heght;
			}
		}
		System.out.println(minTime + " " + height);
	}
}
