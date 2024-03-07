import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] needNum;
    static int[] parentNum;

    static List<List<Node>> l  =new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        needNum = new int[N+1];
        parentNum = new int[N+1];
        for(int idx = 0; idx <=N;idx++){
            l.add(new ArrayList<>());
        }

        while(M-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int need = Integer.parseInt(st.nextToken());

            l.get(x).add(new Node(y,need));
            parentNum[y]++;
        }

        run();

        for(int idx =1 ;idx<=N;idx++){
            if(l.get(idx).size() == 0){
                System.out.println(idx + " " + needNum[idx]);
            }
        }

    }

    static void run(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        needNum[N] = 1;

        while(!q.isEmpty()){
            int vertex = q.poll();

            for(int idx = 0;idx<l.get(vertex).size();idx++){
                Node nextNode = l.get(vertex).get(idx);

                needNum[nextNode.vertex] += needNum[vertex] * nextNode.need;
                parentNum[nextNode.vertex]--;

                if(parentNum[nextNode.vertex] == 0){
                    q.offer(nextNode.vertex);
                }
            }
        }
    }

    static class Node{
        int vertex;
        int need;

        Node(int vertex,int need){
            this.vertex = vertex;
            this.need = need;
        }
    }
}
