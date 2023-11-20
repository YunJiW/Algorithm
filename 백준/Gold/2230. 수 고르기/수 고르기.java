import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int num[] = new int[N];

        for(int idx = 0; idx < N;idx++){
            num[idx] = Integer.parseInt(br.readLine());
        }
        //숫자 정렬
        Arrays.sort(num);

        int start = 0;
        int end = 0;


        int ans  = Integer.MAX_VALUE;

        while(end < N){
            if(num[end] - num[start] < M){
                end+=1;
                continue;
            }

            //결국엔 이게 최솟값임.
            if(num[end] - num[start] ==M){
                ans = M;
                break;
            }

            ans = Math.min(ans,num[end]-num[start]);
            start+=1;
        }
        System.out.println(ans);
    }
}
