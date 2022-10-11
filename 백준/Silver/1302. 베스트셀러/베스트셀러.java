import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		HashMap<String, Integer> map = new HashMap<>();

		for (int index = 0; index < N; index++) {
			String S = br.readLine();

			map.put(S, map.getOrDefault(S, 0) + 1);
		}
		
		int max =Integer.MIN_VALUE;
		
		for(String books : map.keySet())
		{
			if(max < map.get(books))
			{
				max = map.get(books);
			}
		}
		
		
		ArrayList<String> check = new ArrayList<>();
		
		for(String books : map.keySet())
		{
			if(max == map.get(books))
				check.add(books);
		}
		
		Collections.sort(check);
		
		
		System.out.print(check.get(0));
	}

}
