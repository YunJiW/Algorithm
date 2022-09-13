import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];
		int[] B = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int index = 0; index < N; index++) {
			A[index] = Integer.parseInt(st.nextToken());

		}
		st = new StringTokenizer(br.readLine());
		for (int index = 0; index < N; index++) {
			B[index] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		Arrays.sort(B);
		
		int sum = 0;
		for(int index = 0 ;index < N;index++)
		{
			sum += (A[index] * B[N-index-1]);
		}

		
		System.out.println(sum);
		

	}
}
