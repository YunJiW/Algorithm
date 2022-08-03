
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            double sum = 0;
            double avg = 0;
            for(int num = 0 ; num<10;num++)
            {
                int n = sc.nextInt();
                sum += n;
            }
            avg = sum / 10.0;
            int a =(int)Math.round(avg);
            System.out.println("#" + test_case + " " + a );
		}
	}
}