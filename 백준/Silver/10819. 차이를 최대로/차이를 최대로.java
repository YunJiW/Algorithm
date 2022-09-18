import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
public class Main {
	static int[] num;
	static int[] arr;
	static boolean[] check;
	
	
	static int N;
	static int result;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		arr = new int[N];
		num = new int[N];
		check = new boolean[N];
	
		for(int index = 0; index < N; index++)
		{
			arr[index] = Integer.parseInt(st.nextToken());
		}
		dfs(0);
		
		System.out.println(result);
		
		
	}
	private static void dfs(int depth) {
		if(depth == N)
		{
			int sum = 0;
			for(int index = 0 ; index <N-1;index++)
			{
				sum += Math.abs(num[index] - num[index+1]);
			}
			result = Math.max(result, sum);
			return;
		}
		
		for(int index = 0 ; index<N;index++)
		{
			if(!check[index]) {
				check[index] = true;
				num[depth] = arr[index];
				dfs(depth+1);
				check[index] = false;
			}
		}
	}
}
