import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
public class Main {
	
	public static long K;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());
		
		
		long ans = pow(N,M);
		
		System.out.println(ans);
	}

	private static  long pow(long N, long M) {
		if(M == 1)
			return N % K;
		
		long temp = pow(N,M/2);
		
		if(M % 2 == 1)
		{
			return (temp * temp %K) * N % K;
		}
		return temp * temp %K;
		
		
	}

}
