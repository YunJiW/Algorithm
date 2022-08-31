import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String,Integer> Hearsay = new HashMap<>();
		
		ArrayList<String> hearSay = new ArrayList<>();
		int cnt = 0;
		for(int index=0; index < N; index++)
		{
			String say = br.readLine();
			Hearsay.put(say,1);
		}
		
		for(int k = 0; k < M;k++) {
			String hear = br.readLine();
			Hearsay.put(hear,Hearsay.getOrDefault(hear, 0) + 1);
		}
		
		for(String na : Hearsay.keySet())
		{
			if(Hearsay.get(na) == 2)
			{
				hearSay.add(na);
				cnt++;
			}
		}
		Collections.sort(hearSay);
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		for(int num = 0 ; num<hearSay.size();num++)
		{
			sb.append(hearSay.get(num)).append("\n");
		}
		
		System.out.print(sb);
		
		
		
		
	}
}
