import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	static int[] nums;
	static int[] arr;
	static boolean[] check;
	
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];
		arr = new int[M];
		check = new boolean[N];
		
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");

		for (int index = 0; index < N; index++) {
			nums[index] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		dfs(0);
		

		System.out.print(sb);
	}
	public static void dfs(int depth)
	{
		if(depth == M)
		{
			for(int num : arr)
			{
				sb.append(num).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int index = 0 ;index < N;index++)
		{
			if(!check[index])
			{
				check[index] = true;
				arr[depth] = nums[index];
				dfs(depth+1);
				check[index] = false;
			}
		}
	}

}
