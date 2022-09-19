import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.util.Queue;
import java.util.LinkedList;
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> Card = new LinkedList<>();
		
		StringBuilder sb = new StringBuilder();
		for(int index =1; index<=N;index++)
		{
			Card.offer(index);
		}
		
		
		while(Card.size() != 1)
		{
			sb.append(Card.poll()).append(" ");
			Card.offer(Card.poll());
		}
		
		System.out.print(sb);
		System.out.println(Card.poll());
		
		
	}
}
