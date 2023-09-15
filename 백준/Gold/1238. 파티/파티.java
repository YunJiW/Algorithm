import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

    static final int INF = 99999999;

    //마을개수
    public static int N;
    
    //도로 개수
    public static int M;
    
    //도착마을
    public static int X;

    public static ArrayList<ArrayList<Node>> arrList,reverse_List;


    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arrList = new ArrayList<>();
        reverse_List = new ArrayList<>();

        //각 좌표별 리스트 생성
        for(int idx =0 ; idx <=N;idx++){
            arrList.add(new ArrayList<>());
            reverse_List.add(new ArrayList<>());
        }
        //주어진 그래프로 리스트 구현
        for(int index = 0;index <M;index++){
            st = new StringTokenizer(br.readLine());
            int start= Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());


            arrList.get(start).add(new Node(end,weight));
            reverse_List.get(end).add(new Node(start,weight));

        }

        //dist1 -> 시작점에서 X사이의 거리
        int[] dist1= dijkstra(arrList);
        //dist2 -> x에서 시작점까지 거리
        int[] dist2= dijkstra(reverse_List);

        int ans = 0;
        for(int idx = 1; idx <=N;idx++){
            ans = Math.max(ans,dist1[idx] + dist2[idx]);
        }

        System.out.println(ans);
        br.close();
    }

    private static int[] dijkstra(ArrayList<ArrayList<Node>> arrList) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X,0));

        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist,INF);
        dist[X] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(!visited[cur.end]){
                visited[cur.end] = true;

                for(Node node: arrList.get(cur.end)){
                    if(!visited[node.end] && dist[node.end] > dist[cur.end] + node.weight){
                        dist[node.end] = dist[cur.end] + node.weight;
                        pq.add(new Node(node.end,dist[node.end]));
                    }
                }
            }
        }
        return dist;
    }


}
class Node implements Comparable<Node>{
    int end;
    int weight;
    public Node(int end, int weight){
        this.end =end;
        this.weight =weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}
