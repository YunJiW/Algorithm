
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		long S = Long.parseLong(br.readLine());
		
		long i = 1;
		int cnt = 0;
		while(i <= S)
		{
			S -= i;
			i++;
			cnt++;
			
		}
		System.out.print(cnt);
	}
}
