
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static long num = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] money = new int[N];
		long money_all = 0;

		for (int index = 0; index < N; index++) {
			money[index] = Integer.parseInt(st.nextToken());
			money_all += money[index];
		}
		// 이분탐색을 위한 정렬
		Arrays.sort(money);

		long all = Long.parseLong(br.readLine());
		if (money_all <= all) {
			System.out.print(money[money.length - 1]);
			return;

		} else {
			long min = 0;
			long max = money[money.length - 1];

			long mid = (min + max) / 2;

			while (min <= max) {
				long sum = 0;
				for (int index = 0; index < N; index++) {
					if (money[index] >= mid) {
						sum += mid;
					} else {
						sum += money[index];
					}

				}
				if (sum > all) {
					max = mid - 1;
				} else {
					min = mid + 1;
					num = Math.max(num, mid);
				}
				mid = (min + max) / 2;

			}
			System.out.print(num);
		}
	}
}
