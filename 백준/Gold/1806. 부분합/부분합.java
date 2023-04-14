import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //정수 개수
        int N = Integer.parseInt(st.nextToken());
        //만들어야하는 합
        int S = Integer.parseInt(st.nextToken());

        //합 비교용도
        int check_sum = 0;
        //길이 체크용도
        int size = 0;

        //결과 출력을 위해서 최소길이 체크 용도
        int min_size = 0;

        //수열을 가지고 있을 배열
        int num_list[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int idx =0; idx < N;idx++){
            num_list[idx] = Integer.parseInt(st.nextToken());
        }

        int right = 0;
        int left = 0;

        while(right !=N){
            //두 포인터 중 하나가 마지막에 도착한경우
            //첫 포인터가 마지막에 도착할떄까지 체크
            if(left == N) {
                check_sum -= num_list[right++];
                size -= 1;
                if (check_sum == S) {
                    min_size = check_size(min_size, size);
                }
                continue;
            }
            //check_sum 이 S보다 크거나 같은 경우
            if(check_sum >= S){
                check_sum -= num_list[right++];
                size-=1;
            }
            //check_sum 이 S보다 작은경우
            else if(check_sum < S){
                check_sum += num_list[left++];
                size+=1;
            }
            if(check_sum >= S){
                min_size = check_size(min_size,size);
            }



        }

        System.out.println(min_size);

    }

    //최소 길이 체크용
    private static int check_size(int minSize, int size) {
        if(minSize == 0){
            return size;
        }else{
            minSize = Math.min(minSize,size);
            return minSize;
        }
    }
}
