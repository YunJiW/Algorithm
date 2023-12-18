import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //n의 범위가 엄청 크기때문에 long으로 받는다.
        long n = Long.parseLong(br.readLine());

        //나누는 수가 100만 고정이기 때문에 피사노 주기는 15만이다.
        int pisano = 1500000;

        long arr[] = new long[pisano];

        arr[0] = 0;
        arr[1] = 1;


        for(int idx = 2; idx <pisano && idx <=n;idx++){
            arr[idx] = (arr[idx-2] +arr[idx-1]) %1000000;
        }

        if(n >= pisano){
            n%= pisano;
        }

        System.out.println(arr[(int)n]);
    }
}