
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//탐욕 알고리즘


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int check = 0;
		
		while(N >= 0)
		{
			// 5로 나눠질 경우
			if( N % 5 == 0) {
				check += N/5;
				System.out.println(check);
				return;
			}
			//안 나눠질경우 3을 빼주며 봉투를 1개 늘려줌.
			N -= 3;
			check++;
		}
		
		// 안나눠질경우 -1 리턴
		System.out.println("-1");
		
		
		
	}
}
