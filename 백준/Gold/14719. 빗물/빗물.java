import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());


        int result = 0;
        int wall[] = new int[w];

        st = new StringTokenizer(br.readLine());
        for(int idx =0; idx <w;idx++){
            wall[idx] = Integer.parseInt(st.nextToken());
        }


        for(int index =1 ;index < w-1;index++){
            int left = 0;
            int right = 0;

            for(int left_check = 0; left_check <index;left_check++){
                left = Math.max(left,wall[left_check]);
            }

            for(int right_check = index+1; right_check < w;right_check++){
                right = Math.max(right,wall[right_check]);
            }

            if(wall[index] < left && wall[index] < right)
                result+= Math.min(left,right) - wall[index];

        }

        System.out.println(result);

    }
}