import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] num = new int[10];
		
		String Number = br.readLine();
		
		for(int index = 0 ; index <Number.length();index++)
		{
			int k = Number.charAt(index) -'0';
			if(k == 9)
				k = 6;
			num[k]++;
		}
		if(num[6] >= 2)
		{
			
			num[6] = (int) Math.round(num[6]/2.0);
		}
		int max = 0;
		
		for(int index = 0 ; index < 10 ;index++)
		{
			max = Math.max(max, num[index]);
		}
		
		System.out.println(max);
	}
}
