import java.util.*;
import java.io.*;

public class Main {

    public static int[] house;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        house = new int[N];

        for(int idx =0; idx <N;idx++){
            house[idx] = Integer.parseInt(br.readLine());
        }

        //정렬
        Arrays.sort(house);

        int min = 1;
        int max = house[N-1] - house[0] +1;

        //핵심로직1
        while(min < max){
            int mid = (max+min)/2;

            //적게 설치됬다는 것은 거리가 너무 멀다.
            if(isPossible(mid) < C){
                max = mid;
            }
            //많거나 같은 경우는 더 설치가 가능할수도있기 때문에 min을 땡긴다.
            else{
                min = mid +1;
            }
        }

        System.out.println(min-1);

    }

    //핵심로직2
    private static int isPossible(int distance) {
        int cnt = 1;
        int lastLocation = house[0];

        for(int idx = 1 ; idx <house.length;idx++){
            int locate = house[idx];

            if(locate - lastLocation >= distance){
                lastLocation = locate;
                cnt+=1;
            }
        }
        return cnt;
    }
}
