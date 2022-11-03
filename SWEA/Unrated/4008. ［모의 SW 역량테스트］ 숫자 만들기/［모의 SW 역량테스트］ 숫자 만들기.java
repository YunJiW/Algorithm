
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
class Solution
{

	
	//사용되는 숫자 개수
	static int N;

	//정렬한 배열 넣어둠
	static int oper_arr[];
	//기호 넣어둘거
	static char oper[];
	//각 기호당 넣어둘 개수들 받아두기
	// 0 : +
	// 1 : -
	// 2 : *
	// 3 : /
	static int operation[];
	//담아둘 숫자들 -> 테스트 케이스당 전부 고정됨
	static int number[];
	
	//최댓값과 최솟값 구하기
	static long Min = Long.MAX_VALUE;
	static long Max = Long.MIN_VALUE;
	
	static boolean check[];
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		//값들을 받아둠 StringBuilder;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			
			number = new int[N];
			operation = new int[4];
			oper_arr = new int[N-1];
			check = new boolean[N-1];
			Min = Long.MAX_VALUE;
			Max = Long.MIN_VALUE;
			
 
			st = new StringTokenizer(br.readLine());
			for(int index =0 ; index < 4; index++)
			{
				operation[index] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			
			for(int index =0 ;index <N;index++)
			{
				number[index] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0);
			
			sb.append("#").append(test_case).append(" ").append(Max-Min).append("\n");
			
		}
		System.out.print(sb);
	}
	
	private static void dfs(int depth) {
		//연산 전부 받고 나서 계산
		if(depth == N-1)
		{
			int sum = number[0];
			//수식 계산
			for(int index = 1; index < N;index++)
			{
				if(oper_arr[index-1] == 0)
				{
					sum += number[index];
					
				}else if(oper_arr[index -1] ==1)
				{
					sum -= number[index];
				}else if(oper_arr[index -1] ==2)
				{
					sum *= number[index];
				}else if(oper_arr[index -1] == 3)
				{
					if(number[index] != 0)
						sum /= number[index];
					else
						return;
				}
			}
			 
			Min = Math.min(sum, Min);
			Max = Math.max(sum, Max);
			

			return;
		}
		
		for(int index = 0; index < 4;index++)
		{
			if(operation[index] > 0)
			{
				operation[index]--;
				oper_arr[depth] = index; 
				dfs(depth+1);
				operation[index]++;
			}
		}
		
		
		
		
	}
}