import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		int cnt = 0;
		for (int index = 2; index <= N; index++) {
			for(int j = index; j <=N; j+= index)
			{
				if(arr[j] == 1 ) continue;

				arr[j] = 1;
				cnt++;
				
				if(cnt == K)
				{
					System.out.println(j);
					return;
				}
				
			}
		}
	}
}
