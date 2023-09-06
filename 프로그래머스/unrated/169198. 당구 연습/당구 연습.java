import java.util.*;
class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        Point border = new Point(m, n);
        Point Start = new Point(startX, startY);


        for (int idx = 0; idx < balls.length; idx++) {
            int[] ball = balls[idx];

            List<Point> transBall = PositionCheck(border,Start,new Point(ball[0],ball[1]));

            int minDistance = Integer.MAX_VALUE;
            for(Point point : transBall){
                int dis = calcDistance(Start,point);

                minDistance = Math.min(dis,minDistance);
            }
            answer[idx] = minDistance;
        }

        return answer;
    }

    private int calcDistance(Point start, Point point) {
        int Bx = Math.max(start.x,point.x);
        int By = Math.max(start.y,point.y);
        int sX = Math.min(start.x,point.x);
        int sy = Math.min(start.y,point.y);




        return (int)Math.pow(Bx-sX,2) + (int)Math.pow(By - sy,2);
    }

    private static List<Point> PositionCheck(Point bord,Point start,Point ball){
        List<Point> points = new ArrayList<>();
        //상
        if(!(start.x == ball.x && start.y < ball.y)){
            points.add(new Point(ball.x,2*bord.y - ball.y));
        }

        //하
        if(!(start.x == ball.x && start.y > ball.y)){
            points.add(new Point(ball.x,ball.y*-1));
        }

        //우
        if(!(start.y == ball.y && start.x < ball.x)){
            points.add(new Point(2*bord.x - ball.x, ball.y));
        }

        if(!(start.y == ball.y && start.x > ball.x)){
            points.add(new Point(ball.x*-1,ball.y));
        }

        return points;
    }


    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}