import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;

    static List<ArrayList<City>> list;

    static int [] distance, preCity;
    static int start, end;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();


        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        distance = new int[N+1];
        preCity = new int[N+1];

        Arrays.fill(distance,Integer.MAX_VALUE);

        list = new ArrayList<>();
        for(int idx = 0; idx <=N;idx++){
            list.add(new ArrayList<>());
        }

        for(int idx =0 ; idx <M;idx++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(from).add(new City(to,weight));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        dijkstra(start);
        sb.append(distance[end]).append("\n");


        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        while (preCity[end] != 0){
            cnt+=1;
            stack.push(preCity[end]);
            end = preCity[end];
        }
        sb.append(cnt +1).append("\n");

        while(!stack.isEmpty()){
            sb.append(stack.pop()+ " ");
        }

        System.out.print(sb);
    }

    private static void dijkstra(int start) {
        Queue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start,0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            City curCity = pq.poll();
            int cur = curCity.to;
            if(distance[cur] < curCity.weight){
                continue;
            }
            for(City next : list.get(cur)){
                if(distance[next.to] > distance[cur] + next.weight){
                    distance[next.to] = distance[cur] + next.weight;
                    preCity[next.to] = cur;
                    pq.offer(new City(next.to,distance[next.to]));
                }
            }


        }

    }


    public static class City implements Comparable<City>{
        int to;
        int weight;

        public City(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(City o) {
            return this.weight - o.weight;
        }
    }
}
