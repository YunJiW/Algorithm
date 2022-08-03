
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

        int[] arr= new int[T];
        int mid = 0;
		for(int test_case = 0; test_case < T; test_case++)
		{
            
            arr[test_case] = sc.nextInt();
            
		}
        Arrays.sort(arr);
        mid = arr[arr.length/2 ];
        System.out.println(mid);
	}
}