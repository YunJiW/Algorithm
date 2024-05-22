import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int num[] = new int[N];


        //숫자 받아두기.
        for (int idx = 0; idx < N; idx++) {
            num[idx] = Integer.parseInt(br.readLine());
        }

        //작은순으로 정렬 -> 효율적으로 확인
        Arrays.sort(num);

        int res = num[1] - num[0];
        for (int idx = 2; idx < N; idx++) {
            res = gcd(res, num[idx] - num[idx - 1]);
        }
        //전체 숫자에 대한 최대 공약수가 나온다.
        //그 최대 공약수의 약수 출력하기.
        //정수론
        for (int idx = 2; idx <= res; idx++) {
            if (res % idx == 0) {
                sb.append(idx).append(" ");
            }
        }


        System.out.println(sb);


    }

    public static int gcd(int num, int b) {
        int tmp;

        while (b > 0) {
            tmp = num;
            num = b;
            b = (tmp % num);
        }

        return num;

    }
}
