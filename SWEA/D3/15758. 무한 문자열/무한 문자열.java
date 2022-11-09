
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            String t = st.nextToken();
            
            String S_LCD = S;
            String T_LCD = t;
            
            int len = LCD(S.length(),t.length());
            
            while(S_LCD.length() != len)
            	S_LCD+=S;
            
            while(T_LCD.length() != len)
            	T_LCD += t;
            
            if(S_LCD.equals(T_LCD))
            	sb.append("#").append(test_case).append(" ").append("yes").append("\n");
            else
            	sb.append("#").append(test_case).append(" ").append("no").append("\n");
            	
            
		}
		System.out.println(sb);
	}
                
    private static int LCD(int a, int b) {
    	return (a*b)/gcd(a,b);
	}

	private static int gcd(int length, int length2) {
    	while(length2 > 0)
    	{
    		int temp = length;
    		length = length2;
    		length2= temp % length2;
    	}
    	
    	return length;
	}

}
