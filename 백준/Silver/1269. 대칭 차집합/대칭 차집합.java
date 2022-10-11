import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> A = new HashSet<>();
		HashSet<Integer> B = new HashSet<>();
		
		int cnt = 0;
		
		st= new StringTokenizer(br.readLine()," ");
		for(int index =0 ; index <a;index++)
		{
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		st= new StringTokenizer(br.readLine()," ");
		for(int index=0;index <b;index++)
		{
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int nums : A)
		{
			if(!B.contains(nums))
				cnt++;
		}
		for(int nums: B) {
			if(!A.contains(nums))
				cnt++;
		}
		
		System.out.println(cnt);
	}
}
