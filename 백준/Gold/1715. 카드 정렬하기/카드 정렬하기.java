import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for(int idx=0;idx<N;idx++) {
			que.offer(Integer.parseInt(br.readLine()));
		}
		int sumsum=0;
		
		//한개면 묶을 필요없음.
		if(que.size() == 1) {
			System.out.println(0);
			return;
		}
		//마지막 한뭉치가 될때까지 진행
		while(que.size() >1) {
			int card1 = que.poll();
			int card2 = que.poll();
			int sum = card1 + card2;
			
			sumsum += sum;
			que.offer(sum);
		}
		//진행하여 구한 누적한 카드계산수
		System.out.println(sumsum);
	}

}
