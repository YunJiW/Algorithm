import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		ArrayList<String> arr = new ArrayList<>();

		// 단어들을 넣어둠.
		// 단어를 넣을때 중복되는 단어가 있는지 확인하고 있을 경우 pass
		for (int i = 0; i < N; i++) {
			String word = sc.next();
			if (arr.size() == 0)
				arr.add(word);
			else {
				// 단어가 포함되어있을시 continue로 패스
				if (arr.contains(word))
					continue;
				else {
					arr.add(word);
				}
			}

		}
		String[] answer = new String[arr.size()];
		for(int i = 0 ;i<answer.length;i++)
		{
			answer[i] = arr.get(i);
		}
		//1. 길이가 짧은 것부터 분류
		//2. 길이가 같으면 사전 순으로
		Arrays.sort(answer,new Comparator<String>(){

			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length())
					return s1.compareTo(s2);
				else {
					return s1.length() - s2.length();
				}
			}
			
		});
		//답을 답을 String 배열
		for(String ans : answer)
			System.out.println(ans);
			
	}
}