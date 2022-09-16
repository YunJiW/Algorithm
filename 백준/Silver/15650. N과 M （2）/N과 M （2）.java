import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
public class Main {
	public static int[] arr;
	public static int N;
	public static int M;
	
	public static StringBuilder sb = new StringBuilder();

	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		
		arr = new int[M];
		
		dfs(1,0);
		
		System.out.print(sb);
		
	}

	private static void dfs(int at, int depth) {
		if(depth == M)
		{
			for(int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int index = at; index<= N;index++)
		{
			arr[depth] = index;
			dfs(index+1,depth+1);
		}
	}
}
