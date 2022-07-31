import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int days;
			int[] won;
			//사는 날짜 세기
			int count = 0;
			//싸게 산 값 더해놓기
			int cheap_sum=0;
			
			//이익 값 계산
			long all_sum = 0;
			days = sc.nextInt();
			won = new int[days];
			int max = 0;
			// 값 전부 받기
			for (int i = 0; i < days; i++) {
				int day_won = sc.nextInt();
				if(max < day_won)
					max = day_won;
				won[i] = day_won;
			}
			for(int i = 0 ; i< won.length;i++)
			{
				if(won[i] < max) {
					cheap_sum += won[i];
					count++;
				}
				else if(won[i] == max)
				{
					all_sum = all_sum + (won[i] *count) - cheap_sum;
					max = 0;
					cheap_sum =0;
					count = 0;
					//그 이후부터 다시 max 찾기
					for(int j = i+1; j<won.length;j++)
					{
						
						if(max < won[j])
							max = won[j];

					}
				}
					
			}
			
			System.out.println("#" + test_case + " " + all_sum);


		}
	}
}
