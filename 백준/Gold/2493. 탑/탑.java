import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Stack;

public class Main {
	static class top_check {
		int height;
		int idx;

		top_check(int height, int idx) {
			this.height = height;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		Stack<top_check> stack = new Stack<>();

		StringBuilder sb = new StringBuilder();
		for (int index = 1; index <= n; index++) {
			int height = Integer.parseInt(st.nextToken());

			if (stack.isEmpty()) {
				stack.push(new top_check(height, index));
				sb.append("0 ");

			} else {
				while (true) {
					if(stack.isEmpty()) {
						sb.append("0 ");
						stack.push(new top_check(height,index));
						break;
					}

					top_check high = stack.peek();

					if (high.height > height) {
						sb.append(high.idx).append(" ");
						stack.push(new top_check(height, index));
						break;
					} else {
						stack.pop();
					}
				}
			}
		}

		System.out.println(sb);
	}
}
