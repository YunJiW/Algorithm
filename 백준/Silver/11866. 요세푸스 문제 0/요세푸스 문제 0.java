import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;



public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> arr = new LinkedList<>();
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		for (int num = 1; num <= N; num++) {
			arr.offer(num);
		}
		int chk;
		while(!arr.isEmpty()) {
			for(chk = 1 ; chk < K;chk++)
			{
				arr.add(arr.poll());
			}
			sb.append(arr.poll()).append(", ");
			
			
			
			
		}
		sb.delete(sb.length() -2, sb.length());
		sb.append(">");
		System.out.println(sb);
	}
}
