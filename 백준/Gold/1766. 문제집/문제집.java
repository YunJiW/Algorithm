import java.util.*;
import java.io.*;


public class Main {

    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] indegree = new int[N+1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int idx =0; idx <=N;idx++){
            list.add(new ArrayList<>());
        }

        for(int idx = 0; idx <M;idx++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            list.get(first).add(second);
            indegree[second]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int idx = 1; idx <=N;idx++){
            if(indegree[idx] == 0){
                pq.offer(idx);
            }
        }

        StringBuilder sb = new StringBuilder();
        //핵심로직
        while(!pq.isEmpty()){
            int cur = pq.poll();
            sb.append(cur + " ");

            for(int next : list.get(cur)){
                indegree[next]--;

                if(indegree[next] == 0){
                    pq.offer(next);
                }
            }
        }
        System.out.println(sb);

    }
}