import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		
		int[] num = new int[2];
		
		int check = S.charAt(0) -'0';
		
		num[check] +=1;
		for(int index =1 ; index <S.length();index++)
		{
			if(check == (S.charAt(index)-'0'))
				continue;
			else
			{
				check = S.charAt(index) -'0';
				num[check] +=1;
			}
		}
		int min = Math.min(num[0],num[1]);
		System.out.print(min);
	}
}
