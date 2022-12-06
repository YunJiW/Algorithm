import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		int idx;
		int cost;
		
		Node(int idx, int cost){
			this.idx = idx;
			this.cost = cost;
			
			
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int start_point = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Node>> graph= new ArrayList<ArrayList<Node>>();
		
		for(int index =0 ;index <= V;index++)
		{
			graph.add(new ArrayList<>());
		}
		
		for(int index =0 ; index < E;index++)
		{
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(new Node(end,weight));
		}
		
		
		boolean visit[] = new boolean[V+1];
		int dist[] = new int[V+1];
		
		
		for(int index =0 ;index<=V;index++)
		{
			dist[index] = Integer.MAX_VALUE;
		}
		
		dist[start_point] = 0;
		
		//데이크스트라로 최소비용 구하기
		for(int index=0;index <V;index++)
		{
			int nodeValue = Integer.MAX_VALUE;
			
			int nodeIdx = 0;
			
			for(int check=1; check<=V;check++)
			{
				if(!visit[check] && dist[check] < nodeValue)
				{
					nodeValue = dist[check];
					nodeIdx = check;
				}
			}
			
			visit[nodeIdx] = true;
			
			for(int check =0; check<graph.get(nodeIdx).size();check++)
			{
				Node adjNode = graph.get(nodeIdx).get(check);
				
				if(dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost) {
					dist[adjNode.idx] = dist[nodeIdx]+adjNode.cost;
				}
			}
		}
		
		for(int index =1 ; index <=V;index++)
		{
			if(dist[index] == Integer.MAX_VALUE)
			{
				System.out.println("INF");
			}else
			{
				System.out.println(dist[index]);
			}
		}
	}

}
