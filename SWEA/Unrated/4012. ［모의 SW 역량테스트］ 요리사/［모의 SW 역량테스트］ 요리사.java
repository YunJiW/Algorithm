
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
class Solution{
	
	static int Map[][];
	static int N;
	//식재료들

	static boolean ingred[];
	
	static int Min;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T;test_case++)
		{
			Min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			ingred = new boolean[N];
			Map = new int[N][N];
			
			
			for(int row = 0; row < N;row++)
			{
				st = new StringTokenizer(br.readLine());
				for(int col = 0; col < N; col++)
				{
					Map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			checking(0,0);
			sb.append("#").append(test_case).append(" ").append(Min).append("\n");
			
			
			
		}
		System.out.println(sb);
	}

	private static void checking(int idx ,int depth) {
		if(depth == N/2)
		{
			diff();
			return;
		}
		
		//n개중 2개 뽑기
		for(int index = idx; index <N;index++)
		{
			if(!ingred[index])
			{
				ingred[index] = true;
				checking(index+1,depth+1);
				ingred[index] = false;
				
			}
		}
		
		
	}

	private static void diff() {
		int A_food = 0;
		int B_food= 0;
		
		//식재료 고른 것들의 합
		for(int select_1 = 0; select_1 <N-1;select_1++)
		{
			for(int select_2 = select_1 + 1; select_2 < N; select_2++)
			{
				if(ingred[select_1] ==true && ingred[select_2] == true)
				{
					A_food +=Map[select_1][select_2];
					A_food +=Map[select_2][select_1];
				}
				else if(ingred[select_1] == false && ingred[select_2] == false)
				{
					B_food +=Map[select_1][select_2];
					B_food +=Map[select_2][select_1];
				}
				
			}
		}
		
		int differ = Math.abs(A_food - B_food);
		
		
		Min = Math.min(differ, Min);
		
	}

}