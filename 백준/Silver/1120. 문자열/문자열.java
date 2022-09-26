import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		String A = st.nextToken();
		String B = st.nextToken();

		int Min = Integer.MAX_VALUE;
		int cnt;
		for (int index = 0; index <= (B.length() - A.length()); index++) {
			cnt = 0;
			for (int j = 0; j < A.length(); j++) {
				if (A.charAt(j) != B.charAt(j + index))
					cnt++;
			}

			Min = Math.min(cnt, Min);
		}

		System.out.print(Min);
	}

}
