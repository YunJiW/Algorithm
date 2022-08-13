import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 카드 개수 N
		int N = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());

		int[] card = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		// 작은 순서부터 합을 더해서 가깝게 할거기때문에 sort
		Arrays.sort(card);
		int sum = 0;
		int same = 0;
		// 카드 세장의 합.
		for (int i = 0; i < card.length; i++) {
			for (int j = i + 1; j < card.length; j++) {
				for (int k = j + 1; k < card.length; k++) {
					sum = card[i] + card[j] + card[k];
					if (sum > M) {
						break;
					}else
					{
                        //M보다 작거나 같으면서 그중 가장 큰값 뽑기
						if(sum > same)
							same = sum;
					}
				}
			}
		}
		System.out.println(same);
	}

}
