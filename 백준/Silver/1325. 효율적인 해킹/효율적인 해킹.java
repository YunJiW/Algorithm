import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int count;
    //최대 해킹수 갱신용
    static int Max  = 0;
    static List<List<Integer>> Com_number = new ArrayList<>();
    static boolean[][] visit;
    //각 숫자별 해킹되는 컴퓨터 수 체크
    static int[] Com_count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Com_count = new int[N + 1];
        visit = new boolean[N+1][N+1];

        for (int idx = 0; idx <= N; idx++) {
            Com_number.add(new ArrayList<>());
        }

        //신뢰 별로 그래프 생성
        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            Com_number.get(second).add(first);
        }
        check();

        for (int idx = 1; idx <= N; idx++) {
            if (Com_count[idx] == Max) {
                sb.append(idx).append(" ");
            }
        }
        System.out.println(sb);

    }

    private static void check() {
        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i <=N;i++){
            queue.offer(i);
            while(!queue.isEmpty()){

                int cur = queue.poll();
                if(visit[i][cur]){
                    continue;
                }
                visit[i][cur] = true;
                Com_count[i]+=1;
                for(int num : Com_number.get(cur)){
                    if(visit[i][num]){
                        continue;
                    }
                    if(num < i){
                        for(int k = 1; k <=N;k++){
                            if(visit[i][k])
                                continue;
                            if(visit[num][k]){
                                visit[i][k] = true;
                                Com_count[i]+=1;
                            }
                        }
                    }else{
                        queue.offer(num);
                    }
                }
            }
            Max = Math.max(Max,Com_count[i]);
        }

    }
}

