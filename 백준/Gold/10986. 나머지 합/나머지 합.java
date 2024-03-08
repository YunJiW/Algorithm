import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        long res = 0;
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long Sum[] = new long[N+1];
        long cnt[] = new long[M];

        st = new StringTokenizer(br.readLine());
        for(int idx =1 ;idx <=N;idx++){
            Sum[idx] = (Sum[idx-1] + Integer.parseInt(st.nextToken()))%M;

            if(Sum[idx] == 0){
                res +=1;
            }

            cnt[(int)Sum[idx]]++;
        }

        for(int idx = 0;idx <M;idx++){
            if(cnt[idx] > 1){
                res+=(cnt[idx] * (cnt[idx]-1)/2);
            }
        }


        System.out.println(res);
    }
}
