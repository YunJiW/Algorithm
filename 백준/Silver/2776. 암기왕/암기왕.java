import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.util.StringTokenizer;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		
		
		

		while (T-- > 0) {
			HashSet<Integer> note = new HashSet<>();
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int index =0 ; index <N;index++)
			{
				note.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine()," ");
			for(int index = 0; index < M ;index++)
			{
				int check = Integer.parseInt(st.nextToken());
				if(note.contains(check))
				{
					sb.append('1').append('\n');
				}
				else
					sb.append('0').append('\n');
			}
			System.out.print(sb);
			
		}
	}

}
