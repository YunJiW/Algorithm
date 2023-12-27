import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long lo = 1;
        long hi = K;

        while(lo < hi){
            long mid = (lo+hi)/2;
            long count = 0;


            //최대가 N^2까지기 때문에
            //범위체크가 필요하다.
            for(int idx = 1 ; idx <=N;idx++){
                count+= Math.min(mid/idx,N);
            }


            //K가 count 보다 작거나 같은 경우
            if(K <= count){
                hi = mid;
            }
            else{
                lo = mid +1;
            }

        }

        System.out.println(lo);


    }
}