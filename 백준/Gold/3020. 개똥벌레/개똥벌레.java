import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int downPart[] = new int[height+2];
        int upPart[] = new int[height+2];


        for(int Tc = 0; Tc < (width)/2;Tc++){
            int down = Integer.parseInt(br.readLine());
            int up = height - Integer.parseInt(br.readLine()) + 1;

            downPart[down] +=1;
            upPart[up] +=1;

        }

        for(int idx = 1; idx <= height;idx++){
            downPart[idx] += downPart[idx-1];
        }

        for(int idx= height; idx > 0; idx--){
            upPart[idx] += upPart[idx+1];
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;

        for(int idx =1 ;idx <=height;idx++){
            int sum = (downPart[height] - downPart[idx-1]) + (upPart[1] - upPart[idx+1]);

            if(sum < min){
                min = sum;
                cnt =1;
            }
            else if(sum== min) cnt+=1;
        }


        System.out.println(min + " " + cnt);

    }
}