import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		
		
		if(N  < 100)
		{
			System.out.println(N);
			return;
		}

		else
		{
			cnt = 99;
			for (int index = 100; index <= N; index++) {
				String num = String.valueOf(index);
				if(index < 1000)
				{
					int diff1 = Character.getNumericValue(num.charAt(0)) - Character.getNumericValue(num.charAt(1));
					int diff2 = Character.getNumericValue(num.charAt(1)) - Character.getNumericValue(num.charAt(2));
					
					if(diff1 == diff2)
						cnt++;
				}
			}
		}
		System.out.println(cnt);
		
	}
}
