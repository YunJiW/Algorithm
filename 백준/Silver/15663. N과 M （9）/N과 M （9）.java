
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

	static int N;
	static int M;

	static int number[];
	static int round[];
	static boolean[] visit;
	
	static StringBuilder sb = new StringBuilder();
	//중복을 체크할 해쉬 셋
	static HashSet<String> set = new HashSet<>();
	


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		number = new int[N];
		visit = new boolean[N];

		round = new int[M];
		st = new StringTokenizer(br.readLine());

		for (int index = 0; index < N; index++) {
			number[index] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(number);

		permutation(0);
		
		System.out.print(sb);

	}

	private static void permutation(int depth) {
		if (depth == M) {
			StringBuilder sb2 = new StringBuilder();
			for(int num : round)
			{
				sb2.append(num).append(" ");
			}
			
			//중복 제거 String으로 체크
			if(!set.contains(sb2.toString())) {
				sb.append(sb2.toString()).append("\n");
				set.add(sb2.toString());
			}
			return;
		}

		for (int index = 0; index < N; index++) {
			if (!visit[index]) {
				visit[index] = true;
				round[depth] = number[index];
				permutation(depth + 1);
				visit[index] = false;
			}

		}
	}

}
