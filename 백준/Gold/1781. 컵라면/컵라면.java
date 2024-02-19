import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer,List<Integer>> map = new HashMap<>();
        StringTokenizer st = null;

        for(int idx = 0; idx < N;idx++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());

            if(map.containsKey(deadline)){
                map.get(deadline).add(ramen);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(ramen);
                map.put(deadline,list);
            }
        }

        List<Integer> keySet=  new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        Queue<Integer> pq = new PriorityQueue<>();
        for(int deadline : keySet){
            for(int num : map.get(deadline)){
                pq.add(num);
                while(pq.size() > deadline){
                    pq.poll();
                }
            }
        }

        int total = 0;
        while(!pq.isEmpty()){
            total+= pq.poll();
        }
        System.out.println(total);


    }


}

