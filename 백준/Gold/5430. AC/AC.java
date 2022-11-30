import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int Test_Case = Integer.parseInt(br.readLine());
		for (int T = 0; T < Test_Case; T++) {
			// 뒤집기 -> 0 원래상태 1 뒤집은상태
			int R_chk = 0;
			// 명령어 받기용
			String Command = br.readLine();
			Deque<Integer> List = new ArrayDeque<>();
			int cnt = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), "[|,|]");
			for (int index = 0; index < cnt; index++) {
				List.add(Integer.parseInt(st.nextToken()));
			}
			for (int com = 0; com < Command.length(); com++) {
				char command = Command.charAt(com);

				if (command == 'R') {
					// 0은 원래 상태
					// 1은 뒤집힌 상태
					R_chk = (R_chk + 1) % 2;
					continue;
				}

				if (command == 'D') {
					// 비어있다면 error 출력하고 이번 test_case를 끝냄
					if (List.isEmpty()) {
						sb.append("error").append("\n");
						R_chk = 2;
						break;
					}
					// 비어있지 않다면 현재 뒤집어져있는지 아닌지 보고 뒤집어져있으면 끝값을 지우고
					// 뒤집어지지않았다면 첫값을 지움
					else {
						if (R_chk == 0) {
							List.removeFirst();
						} else {
							List.removeLast();
						}
					}
				}
			}
				if (R_chk == 0) {
					sb.append("[");
					while (!List.isEmpty()) {
						if(List.size() == 1)
							sb.append(List.pollFirst());
						else
							sb.append(List.pollFirst()).append(",");
						
					}
					sb.append("]").append("\n");
				} else if(R_chk == 1) {
					sb.append("[");
					while (!List.isEmpty()) {
						if(List.size() == 1)
							sb.append(List.pollLast());
						else
							sb.append(List.pollLast()).append(",");
					}
					sb.append("]").append("\n");
				} 

		}
		System.out.print(sb);

	}
}
