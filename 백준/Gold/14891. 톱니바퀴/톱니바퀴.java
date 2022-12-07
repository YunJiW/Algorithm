import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;


//N극은 0 S극은 1
public class Main {
	
	static int gears[][];
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		//4개의 톱니바퀴 8개 톱니
		gears= new int[5][9];
		
		for(int index =1; index<=4;index++)
		{
			String gear_set = br.readLine();
			for(int setting = 1; setting <= 8;setting++)
			{
				gears[index][setting] = (gear_set.charAt(setting-1) - '0');
			}
			
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=0; testcase <T ;testcase++)
		{
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			int states[] = new int[5];
			
			
			states[number] = Integer.parseInt(st.nextToken());
			//좌 우 체크
			int checking = number;
			while(number + 1 <= 4)
			{
				if(gears[number][3] != gears[number+1][7])
				{
					states[number+1] = states[number] * (-1);
				}
				number +=1;
			}
			
			
			while(checking - 1 > 0)
			{
				if(gears[checking][7] != gears[checking-1][3])
				{
					states[checking-1] = states[checking] * (-1);
				}
				checking-=1;
			}
			
			runing(states);
		}
		int sum = 0;
		for(int index =1 ;index <=4;index++)
		{
			if(gears[index][1] == 0)
				continue;
			else {
				sum += Math.pow(2, index-1);
			}
		}
		
		
		System.out.println(sum);
		
		
	}

//	private static void print() {
//		
//		for(int i =1 ; i<=4;i++)
//		{
//			for(int j=1;j<=8;j++)
//			{
//				System.out.print(gears[i][j]);
//			}
//			System.out.println();
//		}
//		
//	}

	private static void runing(int[] states) {
		
		for(int index =1; index <=4;index++)
		{
			//0일경우 안돔
			if(states[index] == 0)
				continue;
			//1 일경우 시계 돌기
			if(states[index] == 1)
			{
				int tmp = gears[index][8];
				for(int i = 8; i > 1;i--)
				{
					gears[index][i] = gears[index][i-1];
				}
				gears[index][1] = tmp;
			}
			//-1일경우 반시계돌기
			else {
				int tmp = gears[index][1];
				for(int i = 1; i <= 7; i++)
				{
					gears[index][i] = gears[index][i+1];
				}
				gears[index][8] = tmp;
			}
		}
	}

}
