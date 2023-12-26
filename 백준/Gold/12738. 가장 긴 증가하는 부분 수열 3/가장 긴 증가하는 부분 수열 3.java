import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int seq[] = new int[N];
        int LIS[] = new int[N];

        for(int idx = 0; idx <N;idx++){
            seq[idx] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = seq[0];
        int lengthOfLIS = 1;


        for(int index =1 ; index <N;index++){
            int key = seq[index];

            if(LIS[lengthOfLIS - 1] < key){
                lengthOfLIS++;
                LIS[lengthOfLIS - 1] = key;
            }else{

                int lo = 0;
                int hi = lengthOfLIS;

                while(lo < hi){
                    int mid = (lo+hi)/2;

                    if(LIS[mid] < key){
                        lo = mid+1;
                    }else{
                        hi = mid;
                    }
                }

                LIS[lo] = key;
            }
        }


        System.out.println(lengthOfLIS);
    }
}