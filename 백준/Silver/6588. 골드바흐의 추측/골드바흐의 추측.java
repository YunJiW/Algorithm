import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static boolean prime[] = new boolean[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		is_prime();

		
		StringBuilder sb = new StringBuilder();

		while(true){
			int a = 0;
			int b = 0;

			// 짝수 받기
			int Even = Integer.parseInt(br.readLine());
			if(Even == 0)
				break;
			for (int index = 3; index <= Even; index += 2) {
				int check_a = index;
				int check_b = 0;
				if (!prime[index])
				{
					check_b = Even - check_a;
					
					if(!prime[check_b])
					{
						if(a == 0 && b == 0)
						{
							a =check_a;
							b =check_b;
							break;
						}
						else if(check_b - check_a > b -a)
						{
							a =check_a;
							b = check_b;
						}
					}
				}
			}
			if(a != 0 && b != 0) {
			sb.append(Even).append(" = ").append(a).append(" + ").append(b).append('\n');
			}
			else {
				sb.append("Goldbach's conjecture is wrong.").append("\n");
			}
		}
		System.out.println(sb);
	}

	// 소수 판별
	private static void is_prime() {
		prime[0] = prime[1] = true;

		for (int index = 2; index < 1000; index++) {
			if (prime[index])
				continue;
			for (int num = index * index; num < 1000001; num += index) {
				if (!prime[num])
					prime[num] = true;
			}
		}
	}
}
