import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;

        if(N <= K){
            System.out.println(count);
            return;
        }

        int buy= 0;
        while(true){
            count = 0;
            //물병 체크용 복사
            int copyN = N;
            while(copyN != 0){
                if(copyN %2 == 1){
                    count+=1;
                }
                copyN/=2;
            }

            //물병을 다 만들고 K보다 작거나 같은 경우
            if(count <= K){
                break;
            }
            N+=1;
            buy +=1;

        }

        System.out.println(buy);
    }
}
