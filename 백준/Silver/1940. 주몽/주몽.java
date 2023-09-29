import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());


        int materials[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            materials[idx] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(materials);


        int left = 0;
        int right = N-1;
        int sum = 0;

        int result = 0;
        while (left < right) {
            if(materials[left] + materials[right] < M){
                left+=1;
            }
            else if(materials[left] + materials[right] > M){
                right-=1;
                //둘 다 사용했기 때문에 땡김
            }else{
                result+=1;
                left+=1;
                right-=1;
            }
        }

        System.out.print(result);

    }
}