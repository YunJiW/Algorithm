import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

	static int N;

	// 1~ 9번 선수
	static int[] player = new int[10];
	static boolean[] visited = new boolean[10];

	static int result[][];

	static int Max_ans = Integer.MIN_VALUE;

	static boolean[] checking;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		result = new int[N][10];

		// 각 선수의 이닝별 결과 입력
		for (int col = 0; col < N; col++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int row = 1; row <= 9; row++) {
				result[col][row] = Integer.parseInt(st.nextToken());
			}
		}
		player[4] = 1;

		Mixing(player,2);

		System.out.print(Max_ans);
	}

	// 4번 타자는 1번 선수 고정
	private static void Mixing(int[] player,int depth) {
        if(depth == 10){
            Max_ans = Math.max(Max_ans, games(player));
            return;
        }

        for(int i = 1; i < player.length; i++){
            if(player[i] == 0){
                player[i] = depth;
                Mixing(player, depth+1);
                player[i] = 0;                
            }
        }
	}

	private static int games(int[] player) {
		// 점수 체크용
		int score = 0;
		int out_cnt = 0;
		int ining = 0;

		// 첫 시작 1번타자
		int H_C = 1;

		// 1루 2루 3루 현재 상황 -> 있는 지 없는지

		while (ining < N) {
			out_cnt = 0;
			// 아웃 카운트가 3이 넘어가면 이닝 전환
			checking = new boolean[] { false, false, false, false };
			while (out_cnt < 3) {
				// 현재 타자가 결과값이 0일경우 아웃카운터 1증가
				if (result[ining][player[H_C]] == 0)
					out_cnt++;
				// 아닐경우
				else {
					checking[0] = true;
					for (int pos = 3; pos >= 0; pos--) {
						if (checking[pos]) {
							checking[pos] = false;
							if (result[ining][player[H_C]] + pos > 3) {
								score++;
							} else {
								checking[result[ining][player[H_C]] + pos] = true;
							}
						}
					}
				}
				if ((H_C + 1) % 10 == 0)
					H_C = 1;
				else
					H_C = (H_C + 1) % 10;
			}
			ining++;
		}

		return score;
	}
}
