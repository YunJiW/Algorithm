import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int L;
	static int C;

	static boolean check[];
	static char alpha[];
	static char make[];

	static String ans;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		check = new boolean[C];
		alpha = new char[C];
		make = new char[L];

		st = new StringTokenizer(br.readLine());

		for (int index = 0; index < C; index++) {
			String ch = st.nextToken();
			alpha[index] = ch.charAt(0);
		}
		
        //먼저 정렬
		Arrays.sort(alpha);

		making(0);

		System.out.println(sb);

	}

	private static void making(int depth) {
		if (depth == L) {
			// 최소 모음 1개와 자음 2개가 없을 시
			if (!checking())
				return;

			for (int index = 0; index < make.length; index++) {
				sb.append(make[index]);
			}
			sb.append("\n");

			return;
		}

		for (int index = 0; index < C; index++) {
			if (!check[index]) {
				if (depth == 0) {
					check[index] = true;
					make[depth] = alpha[index];
					making(depth + 1);
					check[index] = false;
                    //사전순으로 정렬이 되는지 확인
				} else {
					if (make[depth - 1] > alpha[index])
						continue; 

					check[index] = true;
					make[depth] = alpha[index];
					making(depth + 1);
					check[index] = false;

				}
			}
		}

	}

	private static boolean checking() {
		// 모음 개수
		int vo_cnt = 0;
		// 자음 개수
		int cnt = 0;

		// 모음의 개수와 자음의 개수 체크
		for (int index = 0; index < make.length; index++) {
			if (make[index] == 'a' || make[index] == 'e' || make[index] == 'i' || make[index] == 'o'
					|| make[index] == 'u') {
				vo_cnt++;
			} else
				cnt++;

		}

		if (vo_cnt >= 1 && cnt >= 2)
			return true;

		return false;
	}

}
