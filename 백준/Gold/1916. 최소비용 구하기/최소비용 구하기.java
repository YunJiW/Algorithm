import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayList;
public class Main {
	
	static class Node{
		int end;
		int weight;
		
		private Node(int end,int weight)
		{
			this.end = end;
			this.weight =weight;
		}
	}
	
	static ArrayList<ArrayList<Node>> city;
	static int cites;
	static int bus;
	
	static boolean visited[];
	static int dist[];
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		city = new ArrayList<ArrayList<Node>>();
		
		//도시개수와 버스 개수
		cites = Integer.parseInt(br.readLine());
		bus = Integer.parseInt(br.readLine());
		
		for(int index=0;index <=cites;index++)
		{
			city.add(new ArrayList<>());
		}
		
		for(int index =0; index <bus;index++) {
			st = new StringTokenizer(br.readLine());
			int start =Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			city.get(start).add(new Node(end,weight));
		}
		st = new StringTokenizer(br.readLine());
		
		int start_spot = Integer.parseInt(st.nextToken());
		int end_spot =Integer.parseInt(st.nextToken());
		
		
		visited = new boolean[cites+1];
		dist = new int[cites+1];
		
		for(int index=0;index<=cites;index++)
		{
			dist[index] =Integer.MAX_VALUE;
		}
		dist[start_spot] = 0;
		
		dijkstra(city);
		
		System.out.println(dist[end_spot]);
		
	}


	private static void dijkstra(ArrayList<ArrayList<Node>> city) {
		for(int index =0; index <cites;index++)
		{
			int NodeValue = Integer.MAX_VALUE;
			int NodeIdx= 0;
			
			for(int check =1; check<=cites;check++)
			{
				if(!visited[check] && dist[check] < NodeValue)
				{
					NodeValue =dist[check];
					NodeIdx= check;
				}
			}
			
			visited[NodeIdx] = true;
			
			for(int check =0; check<city.get(NodeIdx).size();check++)
			{
				Node adjNode = city.get(NodeIdx).get(check);
				
				if(dist[adjNode.end] > dist[NodeIdx] + adjNode.weight) {
					dist[adjNode.end] = dist[NodeIdx]+adjNode.weight;
				}
			}
		}
	}

}
