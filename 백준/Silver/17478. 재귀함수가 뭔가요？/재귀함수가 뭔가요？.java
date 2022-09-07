import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static String ans1= "\"재귀함수가 뭔가요?\"";
	static String ans2 ="\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
	static String ans3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지." ;
	static String ans4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
	static String ans5 = "라고 답변하였지.";
	static String ans6 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
	static String k = "____";
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");

		recursion(N);
		
		for(int index = 0 ; index <= N;index++)
		{
			if(index > 0)
				ans5 = ans5.substring(4);
			System.out.println(ans5);
		}
	}

	static int recursion(int N) {
		if (N ==  0) {
			System.out.println(ans1);
			System.out.println(ans6);
			return 0;
		} else {
			System.out.println(ans1);
			System.out.println(ans2);
			System.out.println(ans3);
			System.out.println(ans4);
			
			ans1 = k + ans1;
			ans2 = k + ans2;
			ans3 = k + ans3;
			ans4 = k + ans4;
			ans5 = k + ans5;
			ans6 = k + ans6;
		}

		return recursion(N - 1);
	}
	

}
