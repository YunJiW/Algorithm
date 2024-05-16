import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int number[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            number[idx] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(number);

        int res = 0;

        //전체 숫자 확인
        for (int idx = 0; idx < N; idx++) {
            int choice = number[idx];
            int left = 0;
            int right = N - 1;
            while (left < right) {

                //같은 수가 나오면안되기 때문에 바꿔주기
                if (left == idx) left++;
                else if (right == idx) right--;

                //만약 둘이 같은 곳을 바라보면 안되기 때문에 끝내줘야함.
                if(left == right) break;

                if(number[left] + number[right] > choice){
                    right--;
                }else if(number[left] + number[right] < choice){
                    left++;
                }else {
                    res+=1;
                    break;
                }

            }
        }
        System.out.println(res);

    }
}
