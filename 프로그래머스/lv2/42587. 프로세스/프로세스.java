import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Point> process = new LinkedList<>();
        for(int idx=0;idx < priorities.length;idx++){
            Point point = new Point();
            point.idx = idx;
            point.pri = priorities[idx];
            process.offer(point);

        }

        Arrays.sort(priorities);
        int index = priorities.length-1;

        while(!process.isEmpty()){
            Point point = process.poll();
            if(point.pri == priorities[index]){
                if(location == point.idx){
                    answer+=1;
                    break;
                }else{
                    answer+=1;
                    index-=1;
                }
            }else{
                process.offer(point);
            }
        }




        return answer;
    }

    class Point{
        int idx;
        int pri;
    }
}