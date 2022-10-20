import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		StringBuilder sb = new StringBuilder();
		int [] Point = new int[N];
		
		int[] Sort = new int[N];
		
		
		for(int index =0 ;index <N;index++)
		{
			int num = Integer.parseInt(st.nextToken());
			Point[index] = num;
			Sort[index] = num;
		}
		Arrays.sort(Sort);
		
		
		
		HashMap<Integer,Integer> Map = new HashMap<>();
        int order = 0;
		for(int index =0 ;index <Sort.length;index++)
		{
			if(!Map.containsKey(Sort[index])){
				Map.put(Sort[index], order);
                order++;
            }
		}
		
		for(int index =0 ;index <N; index++)
		{
			sb.append(Map.get(Point[index])).append(" ");
		}
		System.out.println(sb);
	}
}
