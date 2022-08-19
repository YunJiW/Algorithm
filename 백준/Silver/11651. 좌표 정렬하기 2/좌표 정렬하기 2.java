import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Cordinate[] cor = new Cordinate[N];
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cor[i] = new Cordinate(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(cor,new Comparator<Cordinate>(){

			@Override
			public int compare(Cordinate o1, Cordinate o2) {
				if(o1.y != o2.y) {
					return o1.y - o2.y;
				}else {
					return o1.x - o2.x;
				}
			}
			
		});
		
		for(int cnt = 0; cnt<cor.length;cnt++)
		{
			sb.append(cor[cnt]);
		}
		System.out.println(sb);

	}

	public static class Cordinate {
		int x;
		int y;

		Cordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return x + " " + y + "\n";
		}

	}
}
