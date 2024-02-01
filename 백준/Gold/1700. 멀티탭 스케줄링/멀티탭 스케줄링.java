import java.util.*;
import java.io.*;


public class Main {

    static int maxSize;

    static int k;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        maxSize = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx <k;idx++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> set = new HashSet<>();

        int cnt= 0;
        for(int idx = 0; idx <k;idx++){
            int num = list.get(idx);

            //중복되면 패스
            if(set.contains(num)) continue;
            //멀티탭 크기보다 set이 작으면 넣어주고 패스
            if(set.size() < maxSize){
                set.add(num);
                continue;
            }

            int max = -1;
            int index = -1;

            for(int number : set){
                int tmp = 0;
                List<Integer> sub = list.subList(idx+1,k);

                //그다음 몇번째 위치에 같은 전자기기가있는가?
                if(sub.contains(number)){
                    tmp = sub.indexOf(number)+1;
                    //없는 경우 현재 기준에서 마지막 위치 값 계산해서 넣어둔다.
                }else {
                    tmp = k-idx-1;
                }

                if(tmp > max){
                    max =tmp;
                    index = number;
                }
            }
            set.remove(index);
            set.add(num);
            cnt+=1;
        }

        System.out.println(cnt);
    }
}
