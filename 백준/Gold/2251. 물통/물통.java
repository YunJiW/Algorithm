import java.util.*;
import java.io.*;

public class Main {

    static boolean visited[][][] = new boolean[201][201][201];
    static ArrayList<Integer> result;
    static int A,B,C;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        result = new ArrayList<>();


        bfs();
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for(int idx =0; idx <result.size();idx++){
            sb.append(result.get(idx)).append(" ");
        }
        System.out.print(sb);
    }

    private static void bfs() {
        Queue<Bottle> que = new LinkedList<>();
        que.add(new Bottle(0,0,C));

        while(!que.isEmpty()){
            Bottle cur = que.poll();
            int a = cur.a;
            int b = cur.b;
            int c = cur.c;

            //이미 체크가 된경우 패스
            if(visited[a][b][c]) continue;

            visited[a][b][c] = true;

            if(a == 0) result.add(c);

            //6가지 상황 존재

            //A -> B
            //넘치는 경우 -> 넘치는 만큼은 넘기지 않음.
            if(a+b >= B){
                que.offer(new Bottle(a-(B-b),B,c));
            }else{
                que.offer(new Bottle(0,a+b,c));
            }
            //A -> C
            if(a+c >= C){
                que.offer(new Bottle(a-(C-c),b,C));
            }else{
                que.offer(new Bottle(0,b,a+c));
            }

            //B -> A
            if(b+a >= A){
                que.offer(new Bottle(A,b-(A-a),c));
            }else{
                que.offer(new Bottle(a+b,0,c));
            }
            //B -> C
            if(b+c >= C){
                que.offer(new Bottle(a,b-(C-c),C));
            }else{
                que.offer(new Bottle(a,0,b+c));
            }

            //C -> A
            if(c+a >= A){
                que.offer(new Bottle(A,b,c-(A-a)));
            }
            else{
                que.offer(new Bottle(a+c,b,0));
            }

            //C -> B
            if(c+b >= B){
                que.offer(new Bottle(a,B,c-(B-b)));
            }
            else{
                que.offer(new Bottle(a,c+b,0));
            }
        }
    }


    public static class Bottle{
        int a;
        int b;
        int c;

        public Bottle(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}