import java.util.StringTokenizer;
import java.util.LinkedList;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 문서의 개수 N , 몇 번째로 인쇄 되었는지 궁금한 문서 M
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			LinkedList<int[]> arr = new LinkedList<>();
			st = new StringTokenizer(br.readLine());


			// 순서 및 중요도 넣기
			for (int i = 0; i < N; i++) {
				arr.add(new int[] { i, Integer.parseInt(st.nextToken()) });
			}
			
			int cnt = 0;
			
			
			// 큐가 null이 될때까지 반복
			while (!arr.isEmpty()) {
				
				int[] tmp = arr.poll();
				boolean check = true;

				for (int j = 0; j < arr.size(); j++) {
					// 현재 문서보다 중요도가 더 높을 경우
					if (tmp[1] < arr.get(j)[1]) {
						// 뒤에 다시 넣어줌.
						arr.add(tmp);
						for (int k = 0; k < j; k++) {
							arr.add(arr.poll());
						}
						
						//현재 문서가 가장 큰 중요도를 가진게 아니므로 종료
						check = false;
						break;

					}
				}
				//다음 문서로 넘김
				if(check == false) {
					continue;
				}
				
				
				cnt++;
				if(tmp[0] == M) { //찾고자 하는 문서일 경우 종료
					break;
				}
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
