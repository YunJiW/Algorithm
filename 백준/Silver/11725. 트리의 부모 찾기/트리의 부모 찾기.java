import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	static int N;
	static boolean[] check;
	static int[] parent;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

		for(int index =0; index <=N;index++) {
			tree.add(new ArrayList<>());
		}
		
		
		for (int index = 1; index < N; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			tree.get(n1).add(n2);
			tree.get(n2).add(n1);
		}
		check = new boolean[N+1];
		parent = new int[N+1];
		
		bfs(1,tree,parent,N);
		
		for(int index = 2; index <=N;index++)
		{
			System.out.println(parent[index]);
		}
		
	}
	
	static void bfs(int start,ArrayList<ArrayList<Integer>> list, int[] parents,int n) {
		LinkedList<Integer> que = new LinkedList<>();
		que.offer(start);
		check[start] = true;
		while(!que.isEmpty())
		{
			int val = que.poll();
			for(int item : list.get(val)) {
				if(!check[item]) {
					check[item] = true;
					que.offer(item);
					parents[item] = val;			}
			}
		}
		
	}
}
