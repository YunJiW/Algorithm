import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		int num = 10;
		int check = 1;
		for (int index = 1; index <= N; index++) {
			if(index % num == 0)
			{
				check++;
				num*=10;
			}
			cnt += check;
			
			
		}
		
		System.out.println(cnt);
	}
}
