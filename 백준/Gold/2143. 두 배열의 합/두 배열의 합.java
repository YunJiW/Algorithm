import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < n; idx++) {
            a[idx] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int b[] = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < m; idx++) {
            b[idx] = Integer.parseInt(st.nextToken());
        }

        for (int idx = 1; idx < n; idx++) {
            a[idx] += a[idx - 1];
        }

        for (int idx = 1; idx < m; idx++) {
            b[idx] += b[idx - 1];
        }

        int aSize = n * (n + 1) / 2;
        int bSize = m * (m + 1) / 2;
        long[] aSum = new long[aSize];
        int index = 0;
        sumCalc(n, a, aSum, index);
        long[] bSum = new long[bSize];
        index = 0;
        sumCalc(m, b, bSum, index);

        Arrays.sort(aSum);
        Arrays.sort(bSum);

        int left = 0;
        int right = bSize - 1;
        long cnt = 0;
        while (left < aSize && right > -1) {
            long aSumValue = aSum[left];
            long bSumValue = bSum[right];
            long sum = aSumValue + bSumValue;

            if (sum == T) {
                long ac = 0, bc = 0;
                while (left < aSize && aSumValue == aSum[left]) {
                    left += 1;
                    ac += 1;
                }

                while (right > -1 && bSumValue == bSum[right]) {
                    right -= 1;
                    bc += 1;
                }

                cnt += ac * bc;
            }
            if (sum > T) {
                right -= 1;
            } else if (sum < T) {
                left += 1;
            }
        }
        System.out.println(cnt);


    }


    private static void sumCalc(int Size, int[] arr, long[] Sum, int index) {
        for (int i = 0; i < Size; i++) {
            for (int j = i; j < Size; j++) {
                int value = arr[j];
                //구간의 합 계산
                if (i > 0) value -= arr[i - 1];
                Sum[index++] = value;
            }
        }
    }
}
