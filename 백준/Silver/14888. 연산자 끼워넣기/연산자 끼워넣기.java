import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
public class Main {
	
	//숫자 개수
	static int N;
	
	//사칙연산 개수
	static int oper_num[];
	//사칙연산 경우의 수 만들기용
	static int operation[];
	
	static int number_sel[];
	static int Max = Integer.MIN_VALUE;
	static int Min = Integer.MAX_VALUE;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		number_sel = new int[N];
		operation = new int[N-1];
		oper_num = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for(int index =0; index <N;index++)
		{
			number_sel[index] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int index =0 ;index <4; index++)
		{
			oper_num[index] = Integer.parseInt(st.nextToken());
		}
		
		Search(0);
		
		
		System.out.println(Max);
		System.out.println(Min);
		
		
	}
	private static void Search(int depth) {
		if(depth == N-1)
		{
			int sum = number_sel[0];
			for(int index = 1; index < N;index++)
			{
				if(operation[index-1] == 0)
				{
					sum += number_sel[index];
					
				}else if(operation[index -1] ==1)
				{
					sum -= number_sel[index];
				}else if(operation[index -1] ==2)
				{
					sum *= number_sel[index];
				}else if(operation[index -1] == 3)
				{
					if(number_sel[index] != 0)
						sum /= number_sel[index];
					else
						return;
				}
			}
			
			Min = Math.min(sum, Min);
			Max = Math.max(sum, Max);
			return ;
		}
		
		
		for(int index = 0; index < 4; index++)
		{
			if(oper_num[index] > 0)
			{
				oper_num[index]--;
				operation[depth] = index;
				Search(depth+1);
				oper_num[index]++;
			}
	
	
		}
	}

}
