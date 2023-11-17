import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static int[] arr;
    static List<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        k = Integer.parseInt(br.readLine());
        //완전이진트리기 때문에 개수는 2^k -1개 만큼 있다.
        arr = new int[(int) Math.pow(2, k) - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int index = 0; index < arr.length; index++) {
            arr[index] = Integer.parseInt(st.nextToken());
        }

        //각 깊이의 리스트 생성
        for (int idx = 0; idx < k; idx++) {
            list.add(new ArrayList<>());
        }

        search(0, arr.length - 1, 0);

        for (int idx = 0; idx < k; idx++) {
            for (int num : list.get(idx)) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void search(int start, int end, int depth) {
        if (depth == k) {
            return;
        }

        int mid = (start + end) / 2;

        list.get(depth).add(arr[mid]);

        search(start, mid - 1, depth + 1);
        search(mid + 1, end, depth + 1);
    }
}
