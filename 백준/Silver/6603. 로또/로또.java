import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

	public static int[] lotto;
	public static int[] arr;
	public static int k;
	public static StringBuilder sb =new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			k = Integer.parseInt(st.nextToken());
			
			if(k == 0)
				break;
			lotto = new int[k];
			arr= new int[6];

			for (int index = 0; index < k; index++) {
				lotto[index] = Integer.parseInt(st.nextToken());
			}
			dfs(0);
			

			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	
	public static void dfs(int depth)
	{
		if(depth == 6)
		{
			for(int num : arr)
				sb.append(num).append(" ");
			
			sb.append('\n');
			return;
		}
		
		for(int index =0 ; index < k ;index++)
		{
			if(depth == 0)
			{
				arr[depth] = lotto[index];
				dfs(depth+1);
			}
			else
			{
				
				if(lotto[index] > arr[depth-1])
				{
					arr[depth] = lotto[index];
					dfs(depth+1);
				}
			}

		}
	}

}
