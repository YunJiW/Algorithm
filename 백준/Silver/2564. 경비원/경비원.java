import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int row;
    static int col;

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        Point points[] = new Point[N];

        Point sang = new Point();

        for (int idx = 0; idx <= N; idx++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());

            int checking = Integer.parseInt(st.nextToken());

            if (idx != N) {
                //상점위치 넣어두기.
                //번호대로 북,남,서,동
                Point p = point_check(dir, checking);
                points[idx] = p;
            } else {
                //상근이 위치 체크
                sang = point_check(dir, checking);
            }


        }
        Start(points, sang);
        System.out.println(result);

    }


    private static void Start(Point[] points, Point sang) {

        for (int idx = 0; idx < points.length; idx++) {

            //마주 보는 경우
            if(sang.dir + points[idx].dir == 3 || sang.dir + points[idx].dir == 7){

                if(sang.dir == 1 || sang.dir == 2){
                    result += Math.min(sang.col + points[idx].col,2*col -(sang.col + points[idx].col));
                    result += row;
                }
                else{
                    result += col;
                    result += Math.min(sang.row + points[idx].row,2*row -(sang.row + points[idx].row));
                }
                //90도 거나 같은줄에 있는 경우
            }else{
                result += Math.abs(points[idx].row - sang.row);
                result += Math.abs(points[idx].col - sang.col);
            }

        }
    }

    private static Point point_check(int dir, int checking) {
        Point p = new Point();
        p.dir = dir;
        switch (dir) {
            case 1:
                p.col = checking;
                p.row = 0;
                break;
            case 2:
                p.col = checking;
                p.row = row;
                break;
            case 3:
                p.col = 0;
                p.row = checking;
                break;
            case 4:
                p.col = col;
                p.row = checking;
                break;
        }

        return p;
    }


    public static class Point {
        int row;
        int col;

        int dir;
    }
}
