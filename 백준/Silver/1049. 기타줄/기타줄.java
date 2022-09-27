import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 끊어진줄 N
		int N = Integer.parseInt(st.nextToken());

		// 기타줄 브랜드 M
		int M = Integer.parseInt(st.nextToken());

		guitar[] shop = new guitar[M];

		for (int index = 0; index < shop.length; index++) {
			st = new StringTokenizer(br.readLine(), " ");

			shop[index] = new guitar(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int min_pack = Integer.MAX_VALUE;
		int min_piece = Integer.MAX_VALUE;

		int sum = 0;

		if (N < 6) {
			for (int index = 0; index < M; index++) {
				min_pack = Math.min(min_pack,shop[index].getpack());
				min_piece = Math.min(min_piece,shop[index].getpiece());
			}
			sum = Math.min(min_pack,min_piece*N);
			
		} else {
			for (int index = 0; index < M; index++) {
				min_pack = Math.min(min_pack,shop[index].getpack());
				min_piece = Math.min(min_piece,shop[index].getpiece());
			}
			
			if(min_pack*(N/6) > min_piece*N) {
				sum += min_piece*N;
			}else
			{
				sum += min_pack*(N/6);
				N = N%6;
				sum += Math.min(min_pack,min_piece*(N%6));
			}
			
		}
		
		System.out.print(sum);

	}

	static class guitar {
		int pack;
		int piece;

		guitar(int pack, int piece) {
			this.pack = pack;
			this.piece = piece;
		}

		public int getpack() {
			return pack;
		}

		public int getpiece() {
			return piece;
		}
	}

}