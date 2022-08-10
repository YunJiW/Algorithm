import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		// 계산용
        int result = 0;

		for (int i = 1; i < N; i++) {
			int number = i;
			int sum = 0;
			
			//각 자리수의 합 계산
			while(number != 0)
			{
				sum += number %10;
				number/=10;
			}
			
			//각자리수의 합 + i 가 N과 같다면 생성자
			if(sum + i == N)
			{
				result = i;
				break;
			}

		}
        System.out.println(result);
	}
}