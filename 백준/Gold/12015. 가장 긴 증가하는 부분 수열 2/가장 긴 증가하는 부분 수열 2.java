import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        int[] LIS = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int idx =0; idx <N;idx++){
            seq[idx] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = seq[0];
        int lengthLIS = 1;

        for(int idx = 1 ;idx <N;idx++){
            int key = seq[idx];

            if(LIS[lengthLIS -1] < key){
                lengthLIS++;
                LIS[lengthLIS -1] = key;
            }else{
                int lo= 0;
                int hi = lengthLIS;

                while(lo <hi){
                    int mid =(lo+hi)/2;

                    if(LIS[mid] < key){
                        lo = mid+1;
                    }else{
                        hi = mid;
                    }
                }
                LIS[lo] = key;
            }
        }

        System.out.println(lengthLIS);

    }
}
