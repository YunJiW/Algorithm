import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		int[] arr = new int[N];
		
		int max = Integer.MIN_VALUE;
		
		for(int index =0 ; index <arr.length;index++)
		{
			arr[index] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		
		for(int index = 0 ; index < arr.length;index++)
		{
			max =Math.max(max,arr[index] * (arr.length-index));
		}
		
		System.out.print(max);
	}

}
