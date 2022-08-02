

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++){
            int k = sc.nextInt();
            int[] Score = new int[101];
            int max = 0;
            int answer = 0;
            //1000 명 받아서 각 점수에 대해서 ++
            for(int i = 0; i <1000;i++)
            {
                int each = sc.nextInt();
                Score[each]++;
            }
            for(int check_max = 0 ; check_max < Score.length ; check_max ++)
            {
                if(max < Score[check_max]){
                    max = Score[check_max];
                    answer = check_max;
                }else if(max == Score[check_max])
                {
                    if(answer < check_max)
                        answer = check_max;
                }
            }
            
                System.out.println("#" + test_case + " " + answer);
		}
	}
}