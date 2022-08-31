import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int cnt_zero=0;
        for(int index = 1; index <= N;index++){
            if(index % 5 == 0)
                cnt_zero++;
            if(index % 25 == 0 )
                cnt_zero++;
            if(index %125 == 0)
                cnt_zero++;
        }
        System.out.println(cnt_zero);
    }
}