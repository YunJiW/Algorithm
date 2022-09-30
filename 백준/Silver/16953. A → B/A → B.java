import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		String B_S = String.valueOf(B);

		int cnt = 0;
		while (A < B) {
			if (B_S.charAt(B_S.length() - 1) != '1' && B % 2 != 0) {
				System.out.print(-1);
				return;
			}

			if (B_S.charAt(B_S.length() - 1) == '1' && B_S.length() > 1) {
				B_S = B_S.substring(0, B_S.length() - 1);
				B = Long.parseLong(B_S);
				
			}
            else {
				B = B / 2;
				B_S = String.valueOf(B);
			}
            cnt++;
		}
		if (A != B) {
			System.out.println(-1);
		} else {
			System.out.println(cnt + 1);
		}
	}
}
