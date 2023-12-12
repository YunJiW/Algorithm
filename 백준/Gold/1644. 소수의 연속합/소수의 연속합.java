import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {


    static boolean prime[];
    static List<Integer> numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();
        prime = new boolean[N+1];

        int result = 0;

        if(N == 1){
            System.out.println(0);
            return;
        }

        numbers.add(0);


        for(int i=2;i*i<=N;i++) {
            if(!prime[i]) {
                for(int j=i*i;j<=N;j+=i) {
                    prime[j]=true;
                }
            }
        }

        //누적합 계산
        for(int idx =2 ; idx <=N;idx++){
            if(!prime[idx]){
                numbers.add(idx+numbers.get(numbers.size()-1));
            }
        }

        

        int start = 0;
        int end = 1;
        int size= numbers.size();
        /**
         * 관점
         * 합이 N보다 작은경우
         * 합이 N인 경우
         * 합이 N보다 큰경우
         *
         * right가 끝까지 도착한경우
         * -> 값이 N보다 큰경우면 right땡기면서 체크진행
         * -> 값이 N보다 작아지면 끝. -> 더이상 값이 증가하지않으니까
        *
         */
        while(end < size){
            int sum = numbers.get(end) - numbers.get(start);
            if(sum <= N){
                if(sum == N){
                    result+=1;
                }
                end+=1;
            }else{
                start +=1;
            }
        }

        System.out.println(result);


    }

    private static boolean isPrime(int idx) {

        for (int num = 2; num <= Math.sqrt(idx); num++) {
            if (idx % num == 0) {
                return false;
            }
        }
        return true;
    }
}
