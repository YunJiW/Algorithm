import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String alpha = br.readLine();

		int cnt = 0;
		for (int index = 0; index < alpha.length(); index++) {
			char k = alpha.charAt(index);

			if (k == 'c') {
				if ((index + 1) <= (alpha.length() - 1)
						&& (alpha.charAt(index + 1) == '=' || alpha.charAt(index + 1) == '-')) {
					index++;
					cnt++;
				}
				else
					cnt++;
			} else if (k == 'd') {
				if ((index + 1) <= (alpha.length() - 1) && alpha.charAt(index + 1) == '-') {
					index++;
					cnt++;
				}
				else if ((index + 2) <= (alpha.length() - 1) && alpha.charAt(index + 1) == 'z'
						&& alpha.charAt(index + 2) == '=') {
				}else
					cnt++;

			} else if (k == 'l' || k == 'n') {
				if ((index + 1) <= (alpha.length() - 1) && alpha.charAt(index + 1) == 'j') {
					index++;
					cnt++;
				}
				else
					cnt++;
			} else if (k == 's' || k == 'z') {
				if ((index + 1) <= (alpha.length() - 1) && alpha.charAt(index + 1) == '=') {
					index++;
					cnt++;
				}
				else
					cnt++;
			} else
				cnt++;
		}
		
		System.out.println(cnt);

	}
}
