import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N번째 피보나치 수
		int N = Integer.parseInt(br.readLine());

		long fibo = 0;
		long fibo1 = 1;
		long fibo2 = 0;

		for (int i = 1; i < N; i++) {
			fibo2 = fibo + fibo1;
			fibo = fibo1;
			fibo1 = fibo2;
		}
		
		
		if(N == 1)
			System.out.println(fibo1);
		else if(N == 0)
			System.out.println(fibo);
		else
			System.out.println(fibo2);

	}
}
