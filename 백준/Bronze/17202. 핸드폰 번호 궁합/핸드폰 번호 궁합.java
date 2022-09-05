
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String B = br.readLine();
		
		String arr ="";
		String ans ="";
		
		
		//핸드폰 값을 받아둠
		for(int index = 0; index <B.length();index++)
		{
			arr += A.charAt(index);
			arr += B.charAt(index);
		}
		
		
		while(arr.length() != 2)
		{
			ans ="";
			char[] charArray = arr.toCharArray();
			for(int index = 0 ;index < charArray.length - 1;index++)
			{
				int sum = Character.getNumericValue(charArray[index]) + Character.getNumericValue(charArray[index+1]);
				sum = sum%10;
				ans += sum;
				
			}
			
			arr = ans;
		}
		
		System.out.println(arr);
		
	}
}
