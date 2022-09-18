import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		
		Stack<Character> s = new Stack<>();
		
		boolean check = false;
		StringBuilder sb = new StringBuilder();
		
		
		for(char ch : S.toCharArray())
		{
			if(ch == '<')
			{
				check = true;
				while(!s.isEmpty())
				{
					sb.append(s.pop());	
				}
				sb.append(ch);
				
			}else if(ch =='>')
			{
				check = false;
				sb.append(ch);
			}else if(ch == ' ' )
			{
				while(!s.isEmpty())
				{
					sb.append(s.pop());
				}
				sb.append(" ");
				
			}else {
				if(check == false)
				{
					s.push(ch);
				}else
				{
					sb.append(ch);
				}
			}
		}
		while(!s.isEmpty())
		{
			sb.append(s.pop());
		}
		
		System.out.println(sb);
	}
}
