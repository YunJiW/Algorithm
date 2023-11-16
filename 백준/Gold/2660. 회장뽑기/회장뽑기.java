import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static int member[];

    //최소 점수 체크용
    static int min = Integer.MAX_VALUE;

    static int min_size = 0;

    static int result[];


    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        member = new int[N + 1];

        for (int idx = 0; idx <= N; idx++) {
            list.add(new ArrayList<>());
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //-1나오면 관계 설명 끝
            if (a == -1) {
                break;
            }
            list.get(a).add(b);
            list.get(b).add(a);
        }

        //전체 친구 점수 체크
        for (int idx = 1; idx <= N; idx++) {
            member[idx] = friendScore(idx);
            //최소점수 체크
            min = Math.min(min, member[idx]);
        }


        for (int num = 1; num <= N; num++) {
            if(min == member[num]){
                min_size+=1;
            }
        }
        sb.append(min+ " " + min_size).append("\n");
        for(int num = 1; num <=N;num++){
            if(min == member[num]){
                sb.append(num+ " ");
            }
        }
        System.out.println(sb);



    }

    //각 위치의 친구점수 체크
    private static int friendScore(int idx) {
        int cnt = 0;
        boolean visited[] = new boolean[N+1];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(idx,0));
        visited[idx] = true;

        while(!queue.isEmpty()){
            Node cur = queue.poll();

            for(int node= 0; node <list.get(cur.v).size();node++){
                int next = list.get(cur.v).get(node);

                if(visited[next])
                    continue;

                visited[next] = true;
                queue.offer(new Node(next,cur.cnt+1));

            }
            cnt = cur.cnt;
        }

        return cnt;
    }


    public static class Node{
        int v;
        int cnt;

        public Node(int v, int cnt) {
            this.v = v;
            this.cnt = cnt;
        }
    }
}
