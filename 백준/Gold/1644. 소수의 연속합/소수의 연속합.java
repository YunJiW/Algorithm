import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();

        int result = 0;

        if(N == 1){
            System.out.println(0);
            return;
        }


        for (int idx = 2; idx <= N; idx++) {
            ////소수면 numbers에 넣어두기
            if (isPrime(idx)) {
                numbers.add(idx);

            }
        }

        
        int sum =0;

        int start = 0;
        int end = 0;
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
        while(start <= end){
            if(end == numbers.size()-1){
                sum -= numbers.get(start++);
                if(sum == N){
                    result+=1;
                }

                continue;
            }
            //합이 N을 넘어서는 경우
            if(sum > N){
                sum -=numbers.get(start++);
            }
            else if(sum <= N){
                sum +=numbers.get(end++);
            }

            if(sum == N){
                result+=1;
            }

        }
        //마지막값이 소수이면 +1
        if(numbers.contains(N)){
            result+=1;
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
