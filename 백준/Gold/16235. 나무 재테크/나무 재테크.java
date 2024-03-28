import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];
        int[][] eat = new int[N+1][N+1];


        Deque<Tree> tree_list = new ArrayDeque<>();


        List<Tree> list = new ArrayList<>();
        //기본 입력으로 주어지는거 넣어주기.
        for(int row = 1; row <=N;row++){
            st= new StringTokenizer(br.readLine());
            for(int col=1;col<=N;col++){
                map[row][col] = Integer.parseInt(st.nextToken());
                eat[row][col] = 5;
            }
        }

        for(int idx =1 ;idx <=M;idx++){
            st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            int age = Integer.parseInt(st.nextToken());
            list.add(new Tree(row,col,age));
        }

        //처음 나무 나이순 정렬
        Collections.sort(list);
        for(Tree t : list){
            tree_list.offer(t);
        }

        while(K-->0){
            Queue<Tree> tree_die = new LinkedList<>();
            
            //봄
            for(int idx = 0; idx <tree_list.size();){
                Tree cur = tree_list.poll();
                if(eat[cur.row][cur.col] >= cur.age){
                    eat[cur.row][cur.col] -= cur.age;
                    cur.age+=1;
                    idx++;
                    tree_list.add(cur);
                }else{
                    tree_die.offer(cur);
                }
            }
            
            
            //여름
            for(Tree tree : tree_die){
                eat[tree.row][tree.col] += tree.age/2;
            }
            
            
            //가을
            Queue<Tree> temp = new LinkedList<>();
            //5의배수를 만족하면 넣어놓음.
            for(Tree tree : tree_list){
                if(tree.age % 5 == 0){
                    temp.offer(tree);
                }
            }
            while(!temp.isEmpty()){
                Tree t = temp.poll();

                for(int idx= 0 ; idx <8;idx++){
                    int nxt_row = t.row + dx[idx];
                    int nxt_col = t.col + dy[idx];

                    if(nxt_row > 0 && nxt_row <= N && nxt_col >0 && nxt_col <= N){
                        tree_list.addFirst(new Tree(nxt_row,nxt_col,1));
                    }
                }
            }
            
            //겨울
            for(int row =1 ;row <=N;row++){
                for(int col=1 ;col<=N;col++){
                    eat[row][col] += map[row][col];
                }
            }
        }

        System.out.println(tree_list.size());

        br.close();
    }



    public static class Tree implements Comparable<Tree>{
        int row;
        int col;
        int age;

        public Tree(int row, int col, int age) {
            this.row = row;
            this.col = col;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
}