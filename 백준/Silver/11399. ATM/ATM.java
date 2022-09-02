import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> time = new ArrayList<>();
		
		for(int index = 0 ; index< N; index++)
		{
			time.add(Integer.parseInt(st.nextToken()));
		}
		//정렬
		Collections.sort(time);
		
		//정렬 후 계산
		long Each_Sum = 0;
		long Sum_All = 0;
		
		
		for(int index = 0 ; index < time.size(); index++)
		{
			Each_Sum += time.get(index);
			Sum_All += Each_Sum;
		}
		System.out.println(Sum_All);
	
		
	}

}
