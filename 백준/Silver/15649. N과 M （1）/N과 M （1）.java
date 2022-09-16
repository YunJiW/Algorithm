import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
public class Main {
	static int[] arr;
	static boolean[] check;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//수열 출력
		arr = new int[M];
		//정점 방문확인용
		check = new boolean[N];
		
		dfs(N,M,0);
	}

	private static void dfs(int n, int m, int depth) {
		if(depth== m)
		{
			for(int val : arr)
			{
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for(int index =0; index<n;index++)
		{
			if(!check[index])
			{
				check[index] = true;
				arr[depth] = index+1;
				dfs(n,m,depth+1);
				check[index] = false;
			}
		}
		
	}
}
