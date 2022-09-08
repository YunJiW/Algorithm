import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int day;
		StringBuilder sb = new StringBuilder();
		for(int testcase = 0 ; testcase<T;testcase++)
		{
			day = 1;
			int wear = Integer.parseInt(br.readLine());
			HashMap<String,Integer> wearing = new HashMap<>(); 
			//이름 의상 종류 받기
			for(int name = 0 ; name < wear;name++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				String wear_name = st.nextToken();
				String wear_kind = st.nextToken();
				
				wearing.put(wear_kind,wearing.getOrDefault(wear_kind, 0)+1);
				//2가지이상 섞는 경우
				
			}
			for(int val : wearing.values())
			{
				day *=(val+1);
			}
			sb.append(day-1).append("\n");
			
		}
		
		System.out.print(sb);
	}
}
