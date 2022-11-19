import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = Integer.parseInt(br.readLine());
            if(N % 2 == 0)
                sb.append("#").append(test_case).append(" ").append("Alice").append("\n");
            else
                sb.append("#").append(test_case).append(" ").append("Bob").append("\n");
		}
        System.out.print(sb);
	}
}