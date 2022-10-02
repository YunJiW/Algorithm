import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	public static int[] arr;

	public static int N;
	public static int M;
	
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		
		dfs(0);
		System.out.print(sb);
	}

	public static void dfs(int depth) {
		if(depth == M)
		{
			for(int num: arr)
			{
				sb.append(num).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		
		for(int index = 0 ; index <N;index++)
		{
			if(depth == 0)
			{
				arr[depth] = index+1;
				dfs(depth+1);
			}else
			{
				if(arr[depth-1] <= index+1)
				{
					arr[depth] = index+1;
					dfs(depth+1);
				}
			}
			
			
		}
	}

}
