import java.util.*;

class Solution {
    public String[] solution(int[][] line) {


        Set<Point> star_list = new HashSet<>();
        List<Point> lists = new ArrayList<>();


        //최소좌표
        //최대 좌표
        long min_row = Long.MAX_VALUE;
        long min_col = Long.MAX_VALUE;
        long max_row = Long.MIN_VALUE;
        long max_col = Long.MIN_VALUE;
        //교점 체크
        for (int row = 0; row < line.length; row++) {
            for (int col = row + 1; col < line.length; col++) {
                int[] line1 = line[row];
                int[] line2 = line[col];

                Point point = intersection(line1, line2);

                if (point != null && !star_list.contains(point)) {
                    min_row = Math.min(min_row, point.x);
                    min_col = Math.min(min_col, point.y);
                    max_row = Math.max(max_row, point.x);
                    max_col = Math.max(max_col, point.y);
                    star_list.add(point);
                    lists.add(point);
                }
            }
        }

        int width = (int) (max_row - min_row);
        int height = (int) (max_col - min_col);

        char[][] matrix = new char[width + 1][height + 1];
        for (int row = 0; row < matrix.length; row++) {
            Arrays.fill(matrix[row], '.');
        }

        //리스트에서 꺼내서 찍기
        while (!lists.isEmpty()) {
            Point checking = lists.get(0);
            checking.x -= min_row;
            checking.y -= min_col;

            matrix[(int) checking.x][(int) checking.y] = '*';
            lists.remove(0);
        }

        String[] answer = new String[matrix[0].length];
        Arrays.fill(answer, "");

        for (int col = answer.length - 1; col >= 0; col--) {
            for (int row = 0; row < matrix.length; row++) {
                answer[answer.length - 1 - col] += matrix[row][col];
            }
        }


        return answer;
    }


    public Point intersection(int[] line1, int[] line2) {

        long A = line1[0];
        long B = line1[1];
        long E = line1[2];

        long C = line2[0];
        long D = line2[1];
        long F = line2[2];

        double divisor =(double)(A * D) - (double)(B * C);
        //0과 같을경우 에러
        if (divisor == 0) {
            return null;
        }
        double x =  ((B * F - E * D) / divisor);
        double y =  ((E * C - A * F) / divisor);


        //정수가 아닌경우 null 리턴
        if (x != (long) x) return null;
        if (y != (long) y) return null;

        return Point.of(x, y);
    }


}

class Point {
    public long x;
    public long y;

    private Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(long x, long y) {
        return new Point(x, y);
    }

    public static Point of(double x, double y) {
        return of((long) x, (long) y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}