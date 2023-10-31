import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int R;

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();


    static int vertex[];

    static int cnt ;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        vertex = new int[N+1];

        cnt = 1;
        for(int idx = 0; idx <=N;idx++){
            list.add(new ArrayList<>());
        }




        //간선 연결
        for(int idx =0;idx <M;idx++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }

        //조건 : 오름차순이기떄문에 정렬 필요.
        for(int idx =0; idx <=N;idx++){
            Collections.sort(list.get(idx));
        }

        dfs(R);


        for(int num =1; num <vertex.length;num++){
            System.out.println(vertex[num]);
        }

    }

    private static void dfs(int index) {
        vertex[index] = cnt;

        for(int idx = 0; idx <list.get(index).size();idx++){
            if(vertex[list.get(index).get(idx)] ==0){
                cnt+=1;
                dfs(list.get(index).get(idx));
            }
        }
    }
}
