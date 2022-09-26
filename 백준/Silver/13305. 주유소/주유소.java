import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] distance = new long[N - 1];
		long[] cost = new long[N];
		
		long Min = Integer.MAX_VALUE;
		long sum = 0;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int index = 0; index < N - 1; index++) {
			distance[index] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int index = 0; index < N; index++) {
			cost[index] = Long.parseLong(st.nextToken());
		}
		
		Min = cost[0];
		
		for(int i= 0; i < N-1;i++)
		{
			if(cost[i] < Min)
			{
				Min = cost[i];
			}
			sum += (Min * distance[i]);
		}
		System.out.print(sum);
	}
}
