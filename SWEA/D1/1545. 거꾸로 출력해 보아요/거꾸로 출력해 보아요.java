
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
		for(int test_case = T; test_case >= 0; test_case--)
		{
            sb.append(test_case + " ");

		}
        System.out.print(sb);
	}
}