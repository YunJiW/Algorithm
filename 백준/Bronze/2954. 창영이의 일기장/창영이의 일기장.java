import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;


// a e i o u 다음 p 하나 더 쓰고 그 모음을 하나 더씀 -> 앞의 5개의 문자가 나올경우 그 다음 2개를 버림.
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		String ans = "";
		while(st.hasMoreTokens())
		{
			String senten = st.nextToken();
			
			
			for(int index = 0; index < senten.length();index++)
			{
				ans +=  String.valueOf(senten.charAt(index));
				if(senten.charAt(index) == 'a' ||senten.charAt(index) == 'e'|| senten.charAt(index) == 'i'||senten.charAt(index) == 'o'||senten.charAt(index) == 'u') {
					index +=2;
				}
			}
			ans+=" ";
		}
		ans = ans.substring(0,ans.length()-1);
		System.out.println(ans);
	}

}
