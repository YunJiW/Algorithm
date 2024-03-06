import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static int[] distance,connect;
    static int INF =987654321;

    static ArrayList<Edge>[] list;
    static int cnt;


    static class Edge implements Comparable<Edge>{
        int a;
        int dis;

        public Edge(int a, int dis) {
            this.a = a;
            this.dis = dis;
        }

        public int compareTo(Edge o){
            return this.dis - o.dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        n= Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        distance = new int[n+1];
        connect = new int[n+1];

        for(int idx =0; idx <=n;idx++){
            list[idx] = new ArrayList<>();
        }

        for(int idx =0; idx <m;idx++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            list[a].add(new Edge(b,dis));
            list[b].add(new Edge(a,dis));
        }

        Arrays.fill(distance,INF);
        dijkstra();

        for(int idx = 2; idx <=n;idx++){
            if(connect[idx] == 0 ) continue;
            cnt++;
            sb.append(idx +" " + connect[idx] + "\n");
        }
        System.out.println(cnt);
        System.out.print(sb);
    }

    private static void dijkstra() {
        distance[1] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        //시작점
        pq.add(new Edge(1,0));
        while(!pq.isEmpty()){
            Edge edge = pq.poll();

            //길이가 더길면 갱신 할이유없음.
            if(edge.dis > distance[edge.a])
                continue;

            for(Edge e : list[edge.a]){
                if (distance[e.a] > e.dis + edge.dis){
                    distance[e.a] = e.dis + edge.dis;
                    connect[e.a] = edge.a;
                    pq.add(new Edge(e.a,distance[e.a]));
                }
            }
        }
    }
}
