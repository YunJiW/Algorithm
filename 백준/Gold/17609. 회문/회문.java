import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc <T;tc++){
            String s = br.readLine();

            int left = 0;
            int right = s.length()-1;

            sb.append(palindrome(s,left,right,0)).append("\n");
        }
        System.out.print(sb);
    }

    private static int palindrome(String s, int left, int right, int cnt) {
        while(left < right){
            //둘이 같을경우 계속 진행됨.
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
                continue;
            }

            //이미 하나를 제거하고 나서 다시 또 여기에 온 경우 회문이 아니다.
            if(cnt != 0){
                return 2;
            }
            cnt+=1;
            //오른쪽 문자를 하나 제거하고 체크해본다. 
            //왼쪽 문자를 하나 제거하고 체크
            int res_right = palindrome(s,left,right-1,cnt);
            int res_left = palindrome(s,left+1,right,cnt);
            //1로 끝날 경우 -> 유사회문이 가능하기 때문에 right에서 1빼주고 정상진행.
            //2인 경우 회문이아니기 때문에 오른쪽 문자 제거로 넘어간다.
            if(res_right == 1 || res_left == 1){
                return cnt;
            }
            else{
                return 2;
            }

        }
        return cnt;
    }
}
