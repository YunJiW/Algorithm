import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, m;
    static int arr[];
    static char[] op;
    static int res = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String line = br.readLine();

        m = n / 2;
        arr = new int[m + 1];
        op = new char[m];

        //숫자와 연산자 분리
        for (int idx = 0; idx < n; idx++) {
            if (idx % 2 == 0) {
                arr[idx / 2] = line.charAt(idx) - '0';
            } else {
                op[idx / 2] = line.charAt(idx);
            }
        }

        dfs(arr[0], 0);

        System.out.println(res);

    }

    private static void dfs(int sum, int idx) {
        if (idx >= m) {
            res = Math.max(sum, res);
            return;
        }

        int sum2 = calc(op[idx], sum, arr[idx + 1]);
        dfs(sum2, idx + 1);

        if (idx + 1 < m) {
            int sum3 = calc(op[idx + 1], arr[idx + 1], arr[idx + 2]);
            dfs(calc(op[idx], sum, sum3), idx + 2);
        }
    }

    private static int calc(char oper, int num1, int num2) {

        switch (oper) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            default:
                return num1 * num2;
        }
    }
}
