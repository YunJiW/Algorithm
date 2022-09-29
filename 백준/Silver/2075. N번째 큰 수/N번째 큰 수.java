import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] box = new long[N * N];
		int idx = 0;
		for (int index = 0; index < N; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				box[idx++] = Long.parseLong(st.nextToken());
			}
		}
		Arrays.sort(box);
		
		System.out.print(box[N*N-N]);
	}

}
