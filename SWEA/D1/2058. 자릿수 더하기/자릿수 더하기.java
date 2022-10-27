
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int sum = 0;
        
        for(int index =0; index <number.length(); index++)
        {
            sum += number.charAt(index) -'0';
        }
        System.out.print(sum);
	}
}