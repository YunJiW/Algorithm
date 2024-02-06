import java.util.*;
import java.io.*;


public class Main {

    static int[] list;
    static int[] seq;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list = new int[N];
        seq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx <N;idx++){
            list[idx] = Integer.parseInt(st.nextToken());
        }


        seq[0] = list[0];
        int lengthOfseq = 1;

        for(int idx =1 ; idx <N;idx++){
            int key = list[idx];

            if(seq[lengthOfseq -1] < key){
                lengthOfseq++;
                seq[lengthOfseq-1] = key;
            }
            else{
                int lo = 0;
                int hi = lengthOfseq;

                while(lo < hi){
                    int mid = (lo+hi)/2;

                    if(seq[mid] < key){
                        lo = mid+1;
                    }else{
                        hi = mid;
                    }
                }

                seq[lo] = key;
            }
        }

        System.out.println(N - lengthOfseq);

    }
}
