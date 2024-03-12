import java.util.*;
import java.io.*;

public class Main {
    public static class Info implements Comparable<Info>{
        int left, right;
        public Info(int l, int r){
            left = l; right = r;
        }
        public int compareTo(Info o){
            if(right==o.right) return left-o.left;
            else return right-o.right;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Info> list = new ArrayList<>();

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Info(Math.min(a,b), Math.max(a,b)));
        }

        int d = Integer.parseInt(br.readLine());
        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for(int i=0;i<N;i++){
            Info info = list.get(i);
            if(info.right - info.left>d) continue;

            pq.add(info.left);
            while(!pq.isEmpty()){
                if(info.right-pq.peek()<=d) break;
                pq.poll();
            }
            answer = Math.max(answer, pq.size());
        }

        System.out.println(answer);
    }
}