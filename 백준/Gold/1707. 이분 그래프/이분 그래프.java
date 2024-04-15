import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static List<Integer>[] list;
    public static int color[];

    public static int v, e;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;

        int K = Integer.parseInt(br.readLine());


        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            list = new List[v + 1];

            for (int idx = 0; idx <= v; idx++) {
                list[idx] = new ArrayList<>();
            }

            //간선 정보
            for(int idx = 0; idx < e; idx++){
                st = new StringTokenizer(br.readLine());
                int a =Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }
            color = new int[v+1];
            //이분그래프 체크 진행
            run();

        }

    }

    private static void run() {
        Queue<Integer> que = new LinkedList<>();


        for(int idx =1; idx <=v;idx++){
            if(color[idx] ==0){
                color[idx] = 1;
                que.offer(idx);
            }

            while(!que.isEmpty()){
                int cur = que.poll();

                for(int next : list[cur]){
                    //같은 색상으로 가는 경우 -> 이분탐색이 아니다.
                    if(color[next] == color[cur]){
                        System.out.println("NO");
                        return;
                    }

                    if(color[next] == 0){
                        que.offer(next);
                        if(color[cur] == 1){
                            color[next] =2;
                        }else{
                            color[next] = 1;
                        }
                    }
                }
            }
        }

        System.out.println("YES");

    }
}
