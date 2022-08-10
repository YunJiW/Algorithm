import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static boolean prime[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		
		int max = 0 ;
		
		int[] arr = new int[N];
		for(int i = 0 ; i< N;i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
			if(max < arr[i])
				max = arr[i];
		}
		prime = new boolean[max+1];
		get_prime();
		
		int cnt = 0;
		for(int ans : arr) {
			if(prime[ans] != true)
				cnt++;
		}
		
		System.out.print(cnt);
		
	}
	
	public static void get_prime() {
		prime[0] = prime[1] = true;
		
		for(int i = 2 ; i< Math.sqrt(prime.length);i++)
		{
			if(prime[i]) continue;
			for(int j = 2*i; j<prime.length;j +=i)
			{
				prime[j] = true;
			}
		}
	}
}
