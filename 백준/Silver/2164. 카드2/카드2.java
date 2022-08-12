//가장 맨위의 값 -> 맨처음값을 버리고 그 다음값을 remove 하고 add하면 

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;


//순서
/*
	1. 제일 위에 카드를 버린다
	2. 제일 위의 카드를 맨밑으로 보낸다.
	
	큐를 통한 진행
*/
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> arr =new LinkedList<>();
		
		//넣고
		for(int i = 1 ; i<=N;i++) {
			arr.add(i);
		}
		
		while(arr.size() != 1)
		{
			arr.poll();
			arr.add(arr.poll());
		}
		
		System.out.println(arr.get(0));
	}

}
