import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, Q;

    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());


        tree = new long[N+1];
        for (int tc = 0; tc < Q; tc++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            int p = Integer.parseInt(st.nextToken());
            
            //x를 추가
            if(command == 1){
                int x = Integer.parseInt(st.nextToken());
                update(p,x);
            }else{
                int q = Integer.parseInt(st.nextToken());
                sb.append(sum(q) - sum(p-1) ).append("\n");

            }
        }
        System.out.println(sb);


    }
    private static void update(int idx, int val){
        while(idx <= N){
            tree[idx] += val;
            idx+=(idx& -idx);
        }
    }

    private static long sum(int idx){
        long res =0;
        while(idx >0){
            res+= tree[idx];
            idx -= (idx & -idx);
        }
        return res;
    }
}
