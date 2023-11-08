import java.util.*;
import java.io.*;

public class Main {

    static int N, sum;

    static int[][] map;

    static int[] students;

    static int[] dx ={0,-1,0,1};
    static int[] dy ={-1,0,1,0};

    static Map<Integer,Set<Integer>> preference;

    public static void main(String[] args) throws IOException {
        
        init();
        
        run();

        System.out.println(sum);
    }

    //초기 상황
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        sum = 0;

        map = new int[N][N];
        preference = new HashMap<>();
        students = new int[N*N];


        for(int idx =0; idx <N*N;idx++){
            st = new StringTokenizer(br.readLine());
            int std = Integer.parseInt(st.nextToken());

            students[idx] = std;

            preference.put(std,new HashSet<>());
            for(int like = 0; like <4;like++){
                int likeId = Integer.parseInt(st.nextToken());
                preference.get(std).add(likeId);
            }
        }
    }


    //핵심 로직
    private static void run() {

        for(int idx =0; idx < students.length;idx++){
            Seat seat = findSeat(students[idx]);
            map[seat.r][seat.c] = students[idx];
        }

        for(int row = 0; row < N;row++){
            for(int col = 0; col < N;col++){
                int count = getStudentSum(row,col,map[row][col]);
                if(count > 0){
                   sum += (int)Math.pow(10, count - 1);
                }
            }
        }
    }

    private static Seat findSeat(int student) {
        Seat s = null;
        for(int row =0; row <N;row++)
        {
            for(int col = 0; col <N ;col++){
                if(map[row][col] > 0){
                    continue;
                }

                Seat cur = new Seat(row,col,getStudentSum(row,col,student),getEmptySum(row,col));

                //비교할게 없을 경우
                if(s == null){
                    s = cur;
                    continue;
                }

                if(s.compareTo(cur) > 0){
                    s = cur;
                }
            }
        }
        return s;
    }

    // 빈 곳 사방 체크
    private static int getEmptySum(int row, int col) {
        int count = 0;

        for(int idx =0; idx <4;idx++){
            int nxtRow = row + dx[idx];
            int nxtCol = col + dy[idx];

            if(nxtRow < 0 || nxtRow >= N || nxtCol <0 || nxtCol >= N){
                continue;
            }

            if(map[nxtRow][nxtCol] == 0){
                count+=1;
            }
        }

        return count;
    }

    //좋아하는 사람이 있는지 사방 체크
    private static int getStudentSum(int row, int col, int student) {
        int count = 0;

        for(int idx =0; idx <4;idx++){
            int nxtRow = row + dx[idx];
            int nxtCol = col + dy[idx];

            if(nxtRow < 0 || nxtRow >= N || nxtCol <0 || nxtCol >= N){
                continue;
            }

            if(preference.get(student).contains(map[nxtRow][nxtCol])){
                count+=1;
            }
        }

        return count;
    }



    static class Seat implements Comparable<Seat>{

        int r;
        int c;
        int studentSum;
        int emptySum;

        public Seat(int r, int c, int studentSum, int emptySum) {
            this.r = r;
            this.c = c;
            this.studentSum = studentSum;
            this.emptySum = emptySum;
        }

        @Override
        public int compareTo(Seat o) {

            if(studentSum == o.studentSum){
                if(emptySum == o.emptySum){
                    if(r == o.r){
                        return c - o.c;
                    }
                    return r - o.r;
                }
                //내림차순 정렬 필요 -> 인접이 더 많은 거 찾아야함.
                return o.emptySum - emptySum;
            }
            //내림차순 정렬 필요 -> 인접이 더 많은 거 찾아야함.
            return  o.studentSum - studentSum;
        }
    }
}
