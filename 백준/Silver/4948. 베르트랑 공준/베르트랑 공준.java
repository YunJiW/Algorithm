import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
	public static boolean[] num;
	
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			int N = Integer.parseInt(br.readLine());
			
			if(N == 0)
				break;
			
			
			num = new boolean[2*N+1];
			num[1] = true;
			num[0] = true;
			int cnt =0;
			
			
			for(int i = 2; i<=Math.sqrt(2*N);i++)
			{
				if(num[i]) continue;
				for(int j = 2*i; j <=2*N; j += i )
				{
					num[j] = true;
				}
			}
			
			for(int index = N+1;index <=2*N;index++)
			{
				if(num[index] == false)
				{
					cnt++;
				}
			}
			
			sb.append(cnt).append('\n');
			
			
			
		}
		System.out.print(sb);
	}
}
