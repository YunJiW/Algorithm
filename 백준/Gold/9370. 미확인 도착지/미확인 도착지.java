import java.util.*;
import java.io.*;

public class Main {

    static final int INF = 987654321;

    static int T,n,m,t,s,g,h;

    static ArrayList<ArrayList<Node>> graph;

    static int [] distance;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for(int idx = 0; idx <=n;idx++){
                graph.add(new ArrayList<>());
            }

            for(int idx = 0; idx <m;idx++){
                st = new StringTokenizer(br.readLine());

                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                graph.get(p1).add(new Node(p2,weight));
                graph.get(p2).add(new Node(p1,weight));
            }

            //오름차순 정렬되게
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            int des[] = new int[t];
            for(int idx =0 ;idx <t; idx++){
                des[idx] = Integer.parseInt(br.readLine());
            }

            for(int d : des){
                long res1 = dijstra(s,g) + dijstra(g,h) + dijstra(h,d);
                long res2 = dijstra(s,h) + dijstra(h,g) + dijstra(g,d);
                long res3 = dijstra(s,d);

                if(Math.min(res1,res2) == res3){
                    pq.offer(d);
                }
            }

            while(!pq.isEmpty()){
                sb.append(pq.poll()+ " ");
            }
            sb.append("\n");

        }
        System.out.println(sb);



    }

    public static long dijstra(int start,int end){
        distance = new int[n+1];
        Arrays.fill(distance,INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int curTo = node.end;
            int dist = node.weight;

            if(distance[curTo] < dist) continue;

            for(int idx = 0; idx <graph.get(curTo).size();idx++){
                int cost = distance[curTo] + graph.get(curTo).get(idx).weight;

                if(cost < distance[graph.get(curTo).get(idx).end]){
                    distance[graph.get(curTo).get(idx).end] = cost;
                    pq.offer(new Node(graph.get(curTo).get(idx).end,cost));
                }

            }


        }
        return distance[end];
    }

    public static class Node implements Comparable<Node>{
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
