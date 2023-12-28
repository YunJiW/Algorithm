import java.util.*;
import java.io.*;


public class Main {

    static int N;
    static int lists[];

    //팀이 만들어진 학생수 체크용도
    static int count;

    //visit => 방문 여부
    //done -> 팀이 만들어지는 사람 체크용도.
    static boolean[] visit,done;


    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        //테스트 갯수만큼 돌기
        for(int tc = 0; tc < T;tc++){
            N = Integer.parseInt(br.readLine());


            st = new StringTokenizer(br.readLine());
            lists = new int[N+1];
            visit = new boolean[N+1];
            done = new boolean[N+1];

            count = 0;
            //각 학생별 만들기.
            for(int idx = 1; idx <=N;idx++){
                lists[idx] = Integer.parseInt(st.nextToken());
            }
            
            for(int index = 1 ; index <=N;index++){
                //팀을 이루지 못한 학생의 경우 탐색 진행
                if(!done[index]){
                    dfs(index);
                }
            }
            sb.append(N-count).append("\n");
        }
        System.out.println(sb);

    }

    public static void dfs(int index){

        //이미 방문했을 경우 -> 사이클이 만들어지는 경우
        if(visit[index]){
            done[index] = true;
            count+=1;
            //방문하지 않은 경우
        }else{
            visit[index] = true;
        }

        //팀을 결성을 못했을 경우
        if(!done[lists[index]]){
            dfs(lists[index]);
        }

        visit[index] = false;
        done[index] = true;
    }
}
