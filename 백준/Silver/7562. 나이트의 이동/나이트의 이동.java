import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point{
        int row;
        int col;
        int moving;

        public Point(int row,int col, int moving){
            this.row = row;
            this.col = col;
            this.moving = moving;
        }
        public Point(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    private static int T;

    //이동 방법 8가지
    static int dx[] ={-1,-2,-2,-1,1,2,2,1};
    static int dy[] ={-2,-1,1,2,2,1,-1,-2};

    static int Map_size;
    static boolean check[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringBuilder sb= new StringBuilder();
        StringTokenizer st;

        for(int test = 0; test < T; test++){
            int move = -1;
            Map_size = Integer.parseInt(br.readLine());
            check = new boolean[Map_size][Map_size];
            st = new StringTokenizer(br.readLine());
            //시작점
            Point start = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
            st= new StringTokenizer(br.readLine());
            //도착점
            Point end = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            if(start.row == end.row && start.col == end.col){
                sb.append(0).append("\n");
                continue;
            }else{
                move = BFS(start,end);
                sb.append(move).append("\n");
            }

        }
        System.out.println(sb);
    }

    //BFS 탐색으로 나이트를 이동시키면서 이동 횟수 누적
    public static int BFS(Point start,Point end){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        check[start.row][start.col] = true;
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            if(cur.row == end.row && cur.col == end.col){
                return cur.moving;
            }
            for(int idx = 0; idx <8;idx++){
                int nxt_x = cur.row + dx[idx];
                int nxt_y = cur.col + dy[idx];

                //맵을 벗어나는경우는 제외
                if(nxt_x < 0 || nxt_x >= Map_size || nxt_y <0 ||nxt_y >= Map_size || check[nxt_x][nxt_y]){
                    continue;
                }
                queue.offer(new Point(nxt_x,nxt_y, cur.moving+1));
                check[nxt_x][nxt_y] = true;
            }
        }

        return 0;
    }
}
