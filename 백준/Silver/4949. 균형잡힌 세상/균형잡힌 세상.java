import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 괄호 넣기용
		Stack<Character> bracket = new Stack<>();

		while (true) {
			String S = br.readLine();
			bracket.clear();
			int i = 0;
			for (i = 0; i < S.length(); i++) {
				if (S.charAt(i) == '(' || S.charAt(i) == '[')
					bracket.push(S.charAt(i));
				else if(!bracket.isEmpty() && S.charAt(i) == ')')
				{
					if(bracket.pop().equals('('))
						continue;
					else {
						break;
					}
				}
				else if(!bracket.isEmpty() && S .charAt(i) == ']')
				{
					if(bracket.pop().equals('['))
						continue;
					else {
						break;
					}
				}
				else if(bracket.isEmpty() && S.charAt(i) == ')' || (bracket.isEmpty() && S.charAt(i) == ']'  ))
				{
					break;
				}
			}
			if(S.equals("."))
				break;
			if(bracket.isEmpty() && i == S.length())
			{
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}

		}
	}
}
