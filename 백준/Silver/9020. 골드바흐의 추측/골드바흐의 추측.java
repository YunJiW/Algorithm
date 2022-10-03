
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static boolean[] Sosu = new boolean[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		isPrime();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] check = new int[2];
			int min = Integer.MAX_VALUE;
			int diff;
			for(int index = 0 ;index <=N;index++)
			{
				if(!Sosu[N/2 - index ] && !Sosu[N/2 + index])
				{
					sb.append(N/2 - index).append(" ").append(N/2 + index).append("\n");
					break;
				}
			}
			
		}
		System.out.print(sb);
	}

	public static void isPrime() {
		Sosu[0] = Sosu[1] = true;

		for (int index = 2; index < Math.sqrt(Sosu.length); index++) {
			if (Sosu[index])
				continue;
			for (int j = 2 * index; j < Sosu.length; j += index) {
				Sosu[j] = true;
			}
		}
	}
}
