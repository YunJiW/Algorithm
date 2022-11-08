import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// 최대값이 10000이기 때문에 전체로 만들어둠
	static boolean Number[] = new boolean[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		isPrime();

		int Min_Prime = Integer.MAX_VALUE;
		int Sum_Prime = 0;

		for (int index = M; index <= N; index++) {
			if (!Number[index]) {
				Min_Prime = Math.min(index, Min_Prime);
				Sum_Prime += index;
			}
		}
		if (Sum_Prime == 0) {
			System.out.println(-1);
		} else {

			System.out.println(Sum_Prime);
			System.out.println(Min_Prime);
		}
	}

	private static void isPrime() {
		Number[0] = Number[1] = true;

		for (int index = 2; index <= 5000; index++) {
			if (Number[index])
				continue;
			for (int checking = index * 2; checking <= 10000; checking += index) {
				if (!Number[checking])
					Number[checking] = true;
			}
		}

	}

}
