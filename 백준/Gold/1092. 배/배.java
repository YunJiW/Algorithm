import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int crane_size = Integer.parseInt(br.readLine());
        List<Integer> crane = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int idx= 0; idx < crane_size;idx++){
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int box_size = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx < box_size;idx++){
            box.add(Integer.parseInt(st.nextToken()));
        }
        //크레인 제한 무게 내림차순 정렬
        //박스 무게 내림차순 정렬
        Collections.sort(crane,Collections.reverseOrder());
        Collections.sort(box,Collections.reverseOrder());

        //만약 크레인 제한 무게가 가장 높은 애보다 무게가 높은 박스가 있으면 -1 출력
        if(crane.get(0) < box.get(0)){
            System.out.println(-1);
            return;
        }

        int start = 0;

        int start_idx = 0;
        int count = 0;
        //시작
        while(!box.isEmpty()){
            int index = 0;
            for(int i = 0; i < crane_size;){
                if(index == box.size()) break;
                else if(crane.get(i) >= box.get(index)){
                    box.remove(index);
                    i++;
                }else{
                    index+=1;
                }
            }
            count+=1;
        }
        System.out.println(count);
    }
}
