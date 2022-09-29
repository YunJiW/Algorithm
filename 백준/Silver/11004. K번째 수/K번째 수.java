
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int index = 0; index < N; index++) {
			arr[index] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		System.out.print(arr[K-1]);
	}
}
