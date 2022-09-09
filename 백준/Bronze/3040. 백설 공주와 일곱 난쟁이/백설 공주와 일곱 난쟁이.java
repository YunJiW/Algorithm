import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] num = new int[9];
		ArrayList<Integer> ans = new ArrayList<>();
		int sum = 0;
		int fake1 = 0;
		int fake2 = 0;
		StringBuilder sb = new StringBuilder();

		for (int index = 0; index < 9; index++) {
			num[index] = Integer.parseInt(br.readLine());
			sum += num[index];
		}
		for (int i = 0; i < num.length; i++) {
			for (int j = 1; j < 9; j++) {
				if (num[i] + num[j] == sum - 100) {
					fake1 = i;
					fake2 = j;
					break;
				}
			}
		}
		for (int index = 0; index < num.length; index++) {
			if (index == fake1 || index == fake2) {
				continue;
			}
			sb.append(num[index]).append("\n");
		}

		System.out.print(sb);
	}
}
