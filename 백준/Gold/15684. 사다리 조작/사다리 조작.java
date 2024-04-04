import java.util.*;
import java.io.*;


public class Main {



    static int ladder[][];
    static int N;
    static int M;

    static int H;

    static int res =0;


    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());


        ladder = new int[H+1][N+1];

        for(int idx = 0; idx < M;idx++){
            st= new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            ladder[r][c] = 1;
        }
        
        //핵심 로직
        //1. 사다리 놓기
        //2. 원하는 결과가 나오는지 체크
        for(int idx = 0; idx <= 3 ;idx++){
            comb(1,0,idx);
        }
        System.out.println(-1);

    }

    private static void comb(int nextrow, int cnt, int idx) {
        if(cnt == idx){
            //사다리 체크 진행
            if(check()){
                System.out.println(idx);
                System.exit(0);
            }

            return;
        }

        for(int row =nextrow; row <=H;row++){
            for(int c = 1;c <N;c++){
                //현재 자리에 사다리가 있는경우
                if(ladder[row][c] == 1){
                    continue;
                }
                //내 옆으로 나까지 연결되는 경우
                if(ladder[row][c-1] == 1){
                    continue;
                }
                //내 옆에 사다리가 있는경우(연속으로 붙가능하니까)
                if(ladder[row][c+1] ==1){
                    continue;
                }
                ladder[row][c] = 1;
                comb(row,cnt+1,idx);
                ladder[row][c] = 0;
            }
        }
    }

    private static boolean check() {
        for(int idx =1 ;idx <=N;idx++){
            int curPos = idx;
            int start = 1;

            while(start <=H){
                if(ladder[start][curPos] == 1){
                    curPos+=1;
                    start+=1;
                }else if(ladder[start][curPos-1] == 1){
                    curPos-=1;
                    start+=1;
                }else{
                    start+=1;
                }

            }
            if(idx != curPos)
                return false;
        }
        return true;
    }
}
