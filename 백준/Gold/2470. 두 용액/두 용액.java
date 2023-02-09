import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] sol = new int[N];
		for(int index = 0; index <N;index++) {
			sol[index] = Integer.parseInt(st.nextToken());
			
		}
		
		//정렬
		Arrays.sort(sol);
		
		
		//각 배열의 위치체크용
		int min = 0;
		int max = sol.length-1;
		
		int number[] = new int[2];
		int Min = Integer.MAX_VALUE;
		while(min < max) {
			int sum = sol[min] + sol[max];
			int checking = Math.abs(sum);
			
			//저장한 값보다 작을경우 갱신
			//작은 값을 올려줌
			if(Min > checking) {
				Min = checking;
				number[0] = sol[min];
				number[1] = sol[max];
			}
			if(sum > 0) {
				max-=1;
			}else
				min+=1;
		}
		System.out.println(number[0] + " " + number[1]);
	}

}
