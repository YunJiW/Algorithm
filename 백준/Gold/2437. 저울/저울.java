import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N  = Integer.parseInt(br.readLine());

        //N개만큼 추가 존재.
        int weight[] = new int[N];

        //가능한 최대 무게까지 만들어둔다.
        boolean all[] = new boolean[100000001];



        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int idx= 0; idx < N;idx++){
            weight[idx] = Integer.parseInt(st.nextToken());
            all[weight[idx]] = true;
        }
        //추를 크기순 오름차순 정렬
        Arrays.sort(weight);



        //이 추를 가지고 만들 수 있는 무게를 체크한다.
        int sum = 0;
        for(int idx = 0; idx < N;idx++){
            if(sum + 1 < weight[idx])
                break;

            sum+= weight[idx];
        }

        System.out.println(sum+1);


    }
}
