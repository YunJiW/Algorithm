import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		if(E == 15)
			E=0;
		if(S == 28)
			S=0;
		if(M == 19)
			M=0;
		
		
		int num = 1;
		while(true)
		{
			if(num % 15 == E && num %28 == S && num % 19 == M)
				break;
			num++;
		}
		
		System.out.println(num);
	}

}
