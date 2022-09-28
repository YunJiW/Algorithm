
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 물새는곳
		int N = Integer.parseInt(st.nextToken());

		// 테이프 길이
		int L = Integer.parseInt(st.nextToken());

		double range_min;
		double range_max;
		int cnt;

		double[] repair = new double[N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int index = 0; index < N; index++) {
			repair[index] = Integer.parseInt(st.nextToken());
		}
		// 정렬
		Arrays.sort(repair);
		range_min = repair[0] - 0.5;
		range_max = range_min + L;
		cnt = 1;

		for (int index = 1; index < N; index++) {
			if(repair[index] > range_min && repair[index] < range_max)
			{
				continue;
			}else {
				cnt++;
				range_min = repair[index] - 0.5;
				range_max = range_min + L;
			}
				
		}
		
		System.out.print(cnt);

	}

}
