import java.io.*;
import java.util.*;



public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        Jewelry[] jewelries = new Jewelry[N];
        for(int idx=  0;idx <N;idx++){
            st =  new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewelries[idx] = new Jewelry(m,v);
        }

        Arrays.sort(jewelries, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                //둘의 무게가 같으면 가치 역순정렬
                if(o1.mass == o2.mass){
                    return o2.value - o1.value;
                }
                //아니면 무게 순 정렬
                return o1.mass - o2.mass;

            }
        });

        int bag[] = new int[K];
        for(int idx = 0; idx <K;idx++){
            bag[idx] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;

        for(int index = 0,cur = 0; index < K; index++){
            while(cur < N && jewelries[cur].mass <= bag[index]){
                priorityQueue.offer(jewelries[cur++].value);
            }

            if(!priorityQueue.isEmpty()){
                ans+= priorityQueue.poll();
            }
        }

        System.out.println(ans);

    }


}

class Jewelry {
    int mass; // 무게
    int value; // 가격

    Jewelry(int mass, int value) {
        this.mass = mass;
        this.value = value;
    }
}