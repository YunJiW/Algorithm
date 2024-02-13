import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Point[] p = new Point[N+1];

        for(int idx = 1; idx <=N;idx++){
            int tmp = Integer.parseInt(br.readLine());
            p[idx] = new Point(tmp,idx);
        }

        Arrays.sort(p,1,N+1);

        int max = 0;
        for(int idx =1;idx <=N;idx++){
            max = Math.max(max,p[idx].idx -idx);
        }

        System.out.println(max+1);
        br.close();

    }

}

class Point implements Comparable<Point>{
    int num;
    int idx;

    public Point(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }

    @Override
    public int compareTo(Point o) {
        return num - o.num;
    }
}
