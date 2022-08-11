import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

//괄호

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		

		for (int test_case = 0; test_case < T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String arr = st.nextToken();

			
			Stack<Character> Vps = new Stack<>();
			int cnt;

			for (cnt = 0; cnt < arr.length(); cnt++) {
				// 비어있을경우
				if (Vps.isEmpty() && arr.charAt(cnt) != ')') {
//					System.out.println("VPS push = " + Vps.push(arr.charAt(cnt)));
					Vps.push(arr.charAt(cnt));
					continue;
					
					//비어있을때 )나오면 무조건 No
				} else if (Vps.isEmpty() && arr.charAt(cnt) == ')') {
					System.out.println("NO");
					break;
				} else if (Vps.peek().equals('(') && arr.charAt(cnt) == ')') {
					Vps.pop();
//					System.out.println("VPS POP = " + Vps.pop());
					continue;
				} else {
//					System.out.println("VPS push = " + Vps.push(arr.charAt(cnt)));
					Vps.push(arr.charAt(cnt));
				}

			}
			if (Vps.isEmpty() && cnt == arr.length()) {
				System.out.println("YES");
			}else if(!Vps.isEmpty() && cnt == arr.length()) {
				System.out.println("NO");
			}
		}

	}
}
