import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int K =  Integer.parseInt(br.readLine());

        int sensor[] = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int idx = 0; idx <N;idx++){
            sensor[idx] = Integer.parseInt(st.nextToken());
        }

        //센서 좌표 정렬
        Arrays.sort(sensor);

        //가까운 두 센서간의 거리 차이 계산용
        int diff[] = new int[N-1];

        for(int idx =1; idx < N;idx++){
            diff[idx-1] = sensor[idx] - sensor[idx-1];
        }

        //차이순 정렬
        Arrays.sort(diff);

        int result = 0;

        //N-K까지인 이유 -> K개 만큼 설치되기 때문에 -> K개는 거리가 0이다.
        for(int idx =0; idx <N-K;idx++){
            result+=diff[idx];
        }

        System.out.println(result);



    }
}
