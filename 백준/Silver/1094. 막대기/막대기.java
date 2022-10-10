import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int stick = 64;
		
		int X = Integer.parseInt(br.readLine());
		
		
		int cnt = 0;
		
		if(X == stick)
		{
			System.out.println(1);
			return;
		}
		
		while(X != 0)
		{
			int check = stick/2;
			
			while(true) {
				if(check <= X)
				{
					cnt++;
					X-=check;

					break;
				}
				else
				{
					check/=2;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
