import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		//토큰이 없을때까지 반복
		while(st.hasMoreTokens())
		{
			int key = Integer.parseInt(st.nextToken());
			map.put(key,map.getOrDefault(key, 0) + 1 );
		}
		
		
		int M = Integer.parseInt(br.readLine());
		
		//값을 넣어 놓은 StringBuilder
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens())
		{
			int check = Integer.parseInt(st.nextToken());
			//key 값이 있으면 그값이 가지고있는 value를 추가
			if(map.containsKey(check))
			{
				sb.append(map.get(check)).append(" ");
			}
			else
				sb.append(0).append(" ");
		}
		System.out.println(sb);
	}
}
