import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] line = new int[N+1];


        for(int idx =1 ; idx <=N;idx++){
            int count = Integer.parseInt(st.nextToken());

            //핵심 로직
            for(int check = 1; check <=N;check++){
                if(count == 0){
                    if(line[check] == 0){
                        line[check] = idx;
                        break;
                    }
                    else{
                        continue;
                    }
                }
                else if(line[check] == 0){
                    count-=1;
                }
            }
        }
        for(int idx = 1; idx <=N;idx++){
            System.out.print(line[idx] + " ");
        }

    }
}
