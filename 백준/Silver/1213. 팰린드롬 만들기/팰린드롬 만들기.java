import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();

		int[] alpha = new int[26];
		
		StringBuilder sb = new StringBuilder();

		for (int index = 0; index < S.length(); index++) {
			alpha[S.charAt(index) - 65]++;
		}

		int odd = 0;

		for (int index = 0; index < 26; index++) {
			if (alpha[index] % 2 == 1)
				odd++;
		}

		if (odd > 1) {
			System.out.print("I'm Sorry Hansoo");
		} else {
			//문자 개수가 짝수일경우
			if(S.length() %2 ==0)
			{
				if(odd == 1)
				{
					System.out.print("I'm Sorry Hansoo");
					return;
				}
				else
				{
					for(int index =0 ; index <26;index++)
					{
						for(int j = 0; j < alpha[index]/2; j++)
						{
							sb.append((char)(index + 65));
						}
					}
					
					for(int index = 25;index >= 0; index--)
					{
						for(int j = 0; j<alpha[index]/2; j++)
						{
							sb.append((char)(index + 65));
						}
					}
					
				}
			}else {
				for(int index =0 ; index <26;index++)
				{
					for(int j = 0; j < alpha[index]/2; j++)
					{
						sb.append((char)(index + 65));
					}
				}
				
				for(int index= 0 ;index <26;index++)
				{
					if(alpha[index] % 2 == 1)
						sb.append((char)(index+65));
				}
				
				for(int index = 25;index >= 0; index--)
				{
					for(int j = 0; j<alpha[index]/2; j++)
					{
						sb.append((char)(index + 65));
					}
				}
				
			}
			
			
		}
		
		System.out.print(sb);

	}

}
