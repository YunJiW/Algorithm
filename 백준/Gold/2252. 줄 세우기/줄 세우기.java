import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int degree[] = new int[N+1];
        ArrayList<Integer>[] list = new ArrayList[N+1];

        for(int idx =0; idx <=N;idx++){
            list[idx] = new ArrayList<>();
        }

        for(int idx =0; idx <M;idx++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A].add(B);
            degree[B]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int idx =1 ; idx <=N;idx++){
            if(degree[idx] == 0){
                queue.offer(idx);
            }
        }

        while(!queue.isEmpty()){
            sb.append(queue.peek()+ " ");
            int cur = queue.poll();

            for(int idx = 0; idx <list[cur].size();idx++){
                int nxt = list[cur].get(idx);
                degree[nxt]--;
                if(degree[nxt] == 0){
                    queue.offer(nxt);
                }
            }
        }

        System.out.println(sb);

    }
}
