
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Long> q = new PriorityQueue<>();
		
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			Long x = Long.parseLong(br.readLine());
			
			if(x == 0 && q.isEmpty())
			{
				sb.append(0).append('\n');
				continue;
				
			}
			
			if(x != 0)
			{
				q.offer(x);
			}else {
				sb.append(q.poll()).append('\n');
			}
				

		}
		System.out.print(sb);
	}
}
