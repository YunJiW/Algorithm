import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;
public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;

		StringBuilder sb = new StringBuilder();
		for (int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] dump = new int[100];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int index = 0; index < 100; index++) {
				dump[index] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(dump);
			
			for(int index = 0; index < N;index++)
			{
				dump[99] -= 1;
				dump[0] +=1;
				Arrays.sort(dump);
			}
			
			int diff = dump[99] - dump[0];
			sb.append("#").append(test_case+1).append(" ").append(diff).append('\n');
		}
		
		System.out.print(sb);
	}
}
