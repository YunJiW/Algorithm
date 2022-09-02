import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, String> Site = new HashMap<>();

		// 사이트와 비번 입력
		for (int index = 0; index < N; index++) {
			st = new StringTokenizer(br.readLine(), " ");
			Site.put(st.nextToken(), st.nextToken());
		}

		StringBuilder sb = new StringBuilder();

		for (int index = 0; index < M; index++) {
			sb.append(Site.get(br.readLine())).append("\n");
		}
		
		System.out.print(sb);
	}
}
