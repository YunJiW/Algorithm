import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 

import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
	
	static int set;
	static int N;
	
	static ArrayList<Integer>list[];
	static boolean visited[];
	
	static int result = 0;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		set = Integer.parseInt(st.nextToken());
		
		
		list = new ArrayList[N];
		for(int index = 0;index<N;index++) {
			list[index] = new ArrayList<Integer>();
		}
		visited = new boolean[N];
		for(int index = 0; index <set;index++) {
			st= new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for(int index = 0; index <N;index++) {
			if(result == 0)
				Run(1,index);
		}
		
		
		System.out.println(result);
	}

	private static void Run(int depth,int start) {
		if(depth == 5) {
			result = 1;
			return;
		}
		
		visited[start] = true;
		for(int idx : list[start]) {
			int next = idx;
			if(!visited[next]) {
				Run(depth+1,next);
			}
		}
		visited[start]= false;
		
	}
}
