import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String Stick = br.readLine();
		
		int sum = 0;

		char[] check = Stick.toCharArray();
		
		Stack<Character> checking = new Stack<>();
		for (int index = 0; index < check.length; index++) {
			
			if(check[index] == '(') {
				checking.push(check[index]);
				continue;
			}
			if (check[index] == ')')
				checking.pop();
			
			if(check[index - 1] == '(') {
				sum += checking.size();
			}else {
				sum++;
			}
			
			
		}
		System.out.println(sum);
	}
}
