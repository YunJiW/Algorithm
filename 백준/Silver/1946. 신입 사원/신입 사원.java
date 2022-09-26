
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;
public class Main {

	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		StringBuilder sb = new StringBuilder();
		while(T --> 0)
		{
			boolean check;
			int N = Integer.parseInt(br.readLine());
			person[] rank = new person[N];
			for(int index = 0 ; index < N;index++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int docu = Integer.parseInt(st.nextToken());
				int in = Integer.parseInt(st.nextToken());
				rank[index] = new person(docu,in);
			}
			
			Arrays.sort(rank, new Comparator<person>() {

				public int compare(person o1, person o2) {
					
					return o1.getdoc() - o2.getdoc();
				}
				
			});
			int cnt = 1;
			int stand = rank[0].getinter();
			for(int num = 1; num <N;num++)
			{
				if(stand > rank[num].getinter()) {
					stand = rank[num].getinter();
					cnt++;
				}
			}
			
			
			sb.append(cnt).append('\n');
		}
		System.out.print(sb);
	}

	static class person {
		int doc;
		int inter;

		public person(int doc, int inter) {
			this.doc = doc;
			this.inter = inter;
		}

		public int getinter() {
			return inter;
		}

		public int getdoc() {
			return doc;

		}

	}
}
