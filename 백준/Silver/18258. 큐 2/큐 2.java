import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String S = st.nextToken();

			switch (S) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				queue.offer(num);
				break;
			case "pop":
				if (queue.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(queue.poll()).append('\n');
				}
				break;
			case "size":
				sb.append(queue.size()).append('\n');
				break;
			case "empty":
				if(queue.isEmpty())
					sb.append(1).append('\n');
				else
					sb.append(0).append('\n');
				break;
			case "front":
				if(queue.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(queue.peekFirst()).append('\n');
				break;
			case "back":
				if(queue.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(queue.peekLast()).append('\n');
				break;
			}

		}
		System.out.print(sb);

	}

}
