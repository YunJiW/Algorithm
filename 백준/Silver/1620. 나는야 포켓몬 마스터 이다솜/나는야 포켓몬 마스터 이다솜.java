import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> Coll_num = new HashMap<>();
		HashMap<Integer,String> Coll_name = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		// 도감에 넣기
		for (int index = 1; index <= N; index++) {
			String name = br.readLine();
			Coll_num.put(name, index);
			Coll_name.put(index, name);
		}
		
		//문제가 영문일경우 숫자출력, 숫자면 영문 출력
		for (int prob = 1; prob <= M; prob++) {
			String findStr = br.readLine();
			//숫자일경우 문자열 넣기
			if(isStringNum(findStr)) {
				int name_num = Integer.parseInt(findStr);
				sb.append(Coll_name.get(name_num)).append("\n");
			}
			//문자일경우 숫자넣기
			else {
				sb.append(Coll_num.get(findStr)).append("\n");
			}
	}
		
		System.out.print(sb);

	}
	//숫자인지 판단
	static boolean isStringNum(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
}
