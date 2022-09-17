import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] Switch = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int index = 1; index <= N; index++) {
			Switch[index] = Integer.parseInt(st.nextToken());
		}

		int student = Integer.parseInt(br.readLine());

		for (int index = 0; index < student; index++) {
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (gender == 1) {
				for (int k = num; k <= N; k += num) {
					if (Switch[k] == 1) {
						Switch[k] = 0;
					} else {
						Switch[k] = 1;
					}
				}
				
				
			} else if (gender == 2) {
				if(Switch[num] == 1)
					Switch[num] = 0;
				else
					Switch[num] = 1;
				for (int state = 1; index < N; state++) {
					if (num - state <= 0 || num + state > N) {
						break;
					}
					if (Switch[num - state] == Switch[num + state]) {
						if(Switch[num - state] == 1) {
							Switch[num - state] = 0;
							Switch[num + state] = 0;
						}else
						{
							Switch[num - state] = 1;
							Switch[num + state] = 1;
						}
						
					}else
                        break;
				}
			}

		}
		for (int j= 1; j<=N; j++) {
			System.out.print(Switch[j] + " ");
			if(j %20 == 0)
				System.out.println();
		}
		

	}
}
