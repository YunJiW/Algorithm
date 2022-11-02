//
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

class Solution
{
    //하루 한달 세달 일년 
	static int one;
	static int Month;
	static int Three_Month;
	static int year;
	
	static int Min;
	static int[] Month_plan;
    static int[] Three_month;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());

			one = Integer.parseInt(st.nextToken());
			Month = Integer.parseInt(st.nextToken());
			Three_Month = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());

			Min = Integer.MAX_VALUE;
			// 1 ~ 12 까지 체크
			Month_plan = new int[13];
			Three_month = new int[13];

			st = new StringTokenizer(br.readLine());
			// 각 달당 가는 일 수를 체크해서 1일당 값과 한달 값 비교해서 작은 값을 넣어줌.
			for (int index = 1; index <= 12; index++) {
				Month_plan[index] = Integer.parseInt(st.nextToken());
			}
			checking(0,0);


			if (Min < year) {
				sb.append("#").append(test_case).append(" ").append(Min).append("\n");
			} else
				sb.append("#").append(test_case).append(" ").append(year).append("\n");

		}
		System.out.print(sb);
	}

	// 세달값들 전부 구하기
	private static void checking(int depth, int sum) {
		if(depth > 12)
		{
			Min = Math.min(Min, sum);
			
			return;
		}
		
		if(Month_plan[depth] == 0)
		{
			checking(depth+1,sum);
		}
		
		else {
			checking(depth+1,sum +(Month_plan[depth]*one));
			checking(depth+1,sum + Month);
			checking(depth+3,sum+ Three_Month);
		}
		
		
		

	}

}