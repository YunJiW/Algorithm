import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(),"-");
		
		int sum = Integer.MAX_VALUE;
		
		while(st.hasMoreTokens())
		{
			int temp = 0;
			
			StringTokenizer adder = new StringTokenizer(st.nextToken(), "+");
			
			
			while(adder.hasMoreTokens())
			{
				temp += Integer.parseInt(adder.nextToken());
			}
			
			if(sum == Integer.MAX_VALUE)
			{
				sum = temp;
			}else {
				sum -= temp;
			}
		}
		
		System.out.println(sum);
		
	}
}
