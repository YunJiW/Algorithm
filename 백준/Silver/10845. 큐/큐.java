import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> queue = new LinkedList<>();
		
		StringBuilder sb = new StringBuilder();
		while(N --> 0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String com = st.nextToken();
			
			
			switch(com) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				queue.offer(num);
				break;
			case "pop":
				if(queue.isEmpty())
					sb.append("-1").append("\n");
				else {
					sb.append(queue.get(0)).append("\n");
					queue.remove(0);
				}
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				if(queue.isEmpty())
					sb.append("1").append("\n");
				else
					sb.append("0").append("\n");
				break;
			case "front":
				if(queue.size() == 0)
					sb.append("-1").append("\n");
				else
					sb.append(queue.get(0)).append("\n");
				break;
			case "back":
				if(queue.size() == 0)
					sb.append("-1").append("\n");
				else
					sb.append(queue.get(queue.size()-1)).append("\n");
				break;
			
			}
			
		}
		System.out.println(sb);
		
	}

}
