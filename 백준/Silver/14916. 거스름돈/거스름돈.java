import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //1원 3원
        int coin = 0;
        //동전의 개수가 최소가 되게 -> 값이 큰 동전으로 최대한 주고 남은 것을 2원짜리로 준다.
        while(N > 0){
            //5로 나눈 나머지가 0일때 -> 그냥 나머지면됨.
            if(N % 5 == 0){
                coin += N / 5;
                N %= 5;
            }else {
                N -= 2;
                coin += 1;
            }
        }
        //N이 0보다 작은경우 -> 거스름돈을 줄수 없는 경우.
        if(N < 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(coin);
    }
}