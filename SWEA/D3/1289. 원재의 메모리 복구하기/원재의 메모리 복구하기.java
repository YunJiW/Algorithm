import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		char bit;
		int count;
		for (int tc = 1; tc <= T; tc++) {
			String bits = br.readLine();
			bit = '0';
			count = 0;
			for (int index = 0; index < bits.length(); index++) {
				if (bit != bits.charAt(index)) {
					bit = bits.charAt(index);
					count += 1;
				}
			}
			sb.append("#" + tc + " ").append(count).append("\n");
		}
		System.out.println(sb);

	}

}
