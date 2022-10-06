import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
public class Main {
	
	static int[][] arr;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			arr= new int[N+1][N+1];
			
			for(int index = 0; index <M;index++)
			{
				st = new StringTokenizer(br.readLine()," ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				arr[start][end] = arr[end][start] =1;
			}
			sb.append(N-1).append("\n");
		
		}
		System.out.print(sb);
	}
}
