import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		int num = 0;

		for (int command = 0; command < N; command++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String com = st.nextToken();

			switch (com) {
			case "push": // push일경우에만 num을 받음.
				num = Integer.parseInt(st.nextToken());
				// 값을 넣어줌
				arr.add(num);
				break;
			case "pop":
				if (arr.size() == 0)
					System.out.println("-1");
				else {
					System.out.println(arr.get(arr.size() - 1));
					arr.remove(arr.size() -1);
				}
				break;
			case "top":
				if(arr.size() == 0)
					System.out.println("-1");
				else {
					System.out.println(arr.get(arr.size()-1));
				}
				break;
			case "size":
				System.out.println(arr.size());
				break;
			case "empty":
				if(arr.size() == 0 )
					System.out.println("1");
				else
					System.out.println("0");
				break;

			}

		}
	}
}
