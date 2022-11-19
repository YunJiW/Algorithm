
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int cnt = 0;
            char alpha = 'a';
            String text = br.readLine();
            for(int index = 0; index <text.length();index++)
            {
                char text_alpha = text.charAt(index);
                if(alpha == text_alpha)
                {
                    cnt++;
                }
                else
                    break;
                alpha++;
            }
            sb.append('#').append(test_case).append(" ").append(cnt).append("\n");
		}
        System.out.print(sb);
	}
}