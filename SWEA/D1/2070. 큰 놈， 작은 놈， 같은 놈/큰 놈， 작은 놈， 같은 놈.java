import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			sb.append("#"+test_case + " ").append(diff(num1,num2) +"\n");

		}
		
		System.out.println(sb);
	}
	
	public static char diff(int num,int num2) {
		
		if(num == num2) {
			return '=';
		}
		else if(num > num2) {
			return '>';
		}
		
		return '<';
	}
}
