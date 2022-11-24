import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Stack;
// L D B P
public class Main{
	
	static String Main_String;
	static int command = 0;
	
	static Stack<String> Left_stack;
	static Stack<String> right_stack;
	static String edit_cmd[];
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		//처음 받은 문자열
		Main_String = br.readLine();
		String[] arr = Main_String.split("");
		Left_stack = new Stack<>();
		right_stack = new Stack<>();
		//처음 문자열 
		for(int index =0; index < arr.length;index++)
		{
			Left_stack.push(arr[index]);
		}
		
		
		command = Integer.parseInt(br.readLine());
		edit_cmd = new String[command];
		for(int index = 0; index < command; index++)
		{
			edit_cmd[index] = br.readLine();
		}
		//실행
		Run();
		while(!right_stack.isEmpty())
		{
			sb.append(right_stack.pop());
		}
		
		System.out.print(sb);
	}
	private static void Run() throws IOException{
		
		for(int index =0; index <command;index++)
		{
			char cmd = edit_cmd[index].charAt(0);
			
			switch(cmd) {
			case 'L':
				if(!Left_stack.isEmpty())
					right_stack.push(Left_stack.pop());
				break;
			case 'D':
				if(!right_stack.isEmpty())
				{
					Left_stack.push(right_stack.pop());
				}
				break;
			case 'B':
				if(!Left_stack.isEmpty())
					Left_stack.pop();
				break;
			case 'P':
				char ch = edit_cmd[index].charAt(2);
				Left_stack.push(String.valueOf(ch));
				break;
			}
		}
		while(!Left_stack.isEmpty())
		{
			right_stack.push(Left_stack.pop());
		}
		
	}
}
