import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //k를 1부터 1씩키워감
        int k = 1;

        //학생수
        int N = Integer.parseInt(br.readLine());
        String studentId[] = new String[N];
        //학생의 번호를 받아둠.
        for(int idx = 0; idx <N;idx++){
            studentId[idx] = br.readLine();
        }

        while (true){
            //돌때마다 초기화
            HashSet<String> set = new HashSet<>();
            //학생 번호 길이 -> 길이가 전부 같다고 명시되있기 때문에 가능함.
            int len = studentId[0].length();
            for(int idx =0; idx < N;idx++){
                String curStdId = studentId[idx].substring(len-k);

                //서로 다른지 체크
                if(!set.contains(curStdId)){
                    set.add(curStdId);
                }
                //서로다르게 안만들어지는경우가 아니면 끝냄
                else{
                    break;
                }
            }

            //전부 뽑힌경우
            if(set.size() == N){
                break;
            }
            k+=1;
        }

        System.out.println(k);

    }
}
