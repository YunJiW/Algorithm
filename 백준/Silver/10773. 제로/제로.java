// 주요 알고리즘: Stack

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> money = new Stack<>();
		
		while(K --> 0)
		{
			int num = Integer.parseInt(br.readLine());
			
			if(num != 0)
				money.push(num);
			else
				money.pop();
		}
		int sum = 0;
		
		while(!money.isEmpty())
		{
			sum += money.pop();
		}
		
		System.out.println(sum);
		
		
		
	}
}
