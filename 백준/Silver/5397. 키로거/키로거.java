import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case=1;test_case<=T;test_case++)
		{
			Stack<Character> right = new Stack<>();
			Stack<Character> left = new Stack<>();
			
			String word = br.readLine();
			for(int index =0; index <word.length(); index++) {
				char ch = word.charAt(index);
				
				if(ch == '<') {
					if(!left.isEmpty())
					{
						right.push(left.pop());
					}
					else
						continue;
				}else if(ch == '>') {
					if(!right.isEmpty())
					{
						left.push(right.pop());
					}
					
				}else if(ch == '-') {
					if(!left.isEmpty())
					{
						left.pop();
					}
					
				}else {
					left.push(ch);
				}
			}
			
			
			//오른쪽값을 왼쪽값으로 전부 이동시킨다 -> 스택은 FILO이기때문에
			while(!left.isEmpty())
			{
				right.push(left.pop());
			}
			
			while(!right.isEmpty())
			{
				sb.append(right.pop());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
