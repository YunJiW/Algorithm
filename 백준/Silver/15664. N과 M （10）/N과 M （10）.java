import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Arrays;
public class Main {

	static int N;
	static int M;
	
	static StringBuilder sb = new StringBuilder();
	
	static boolean[] visit;
	static HashSet<String> set = new HashSet<>();
	
	static int[] arr;
	static int[] number;
	
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		number = new int[N];
		visit = new boolean[N];
		arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int index =0 ;index < N;index++)
		{
			number[index] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(number);
		permutation(0);
		
		System.out.print(sb);
		
	}



	private static void permutation(int depth) {
		if(depth == M)
		{
			StringBuilder sb2 = new StringBuilder();
			for(int num : arr) {
				sb2.append(num).append(" ");
			}
			if(!set.contains(sb2.toString())) {
				sb.append(sb2.toString()).append("\n");
				set.add(sb2.toString());
			}
			return;
		}
		
		for(int index = 0; index <N;index++)
		{
			//0일경우는 방문여부 체크하고 넣기
			if(depth == 0)
			{
				if(!visit[index]) {
					visit[index] = true;
					arr[depth] = number[index];
					permutation(depth+1);
					visit[index] = false;
				}
			}
			//depth가 1보다 클경우 그전값과 비교해서 그전값보다 크거나 같은지 체크
			else {
				if(!visit[index] && arr[depth - 1] <= number[index])
				{
					visit[index] = true;
					arr[depth] = number[index];
					permutation(depth+1);
					visit[index] = false;
				}
			}
	
		}
		
	}
}
