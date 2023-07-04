class Solution {
    char[][] map;

    int rows;
    int cols;

    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        rows = park.length;
        cols = park[0].length();
        map = new char[rows][cols];

        Point Start = new Point();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                map[row][col] = park[row].charAt(col);
                //시작위치 체크
                if (park[row].charAt(col) == 'S') {
                    Start.row = row;
                    Start.col = col;
                }
            }
        }

        answer = routecheck(Start, routes);


        return answer;
    }

    private int[] routecheck(Point start, String[] routes) {
        int[] result = new int[2];
        for (int idx = 0; idx < routes.length; idx++) {
            String[] route = routes[idx].split(" ");
            int move = Integer.parseInt(route[1]);
            boolean isPossible = true;
            switch (route[0]) {
                //서
                case "W":
                    //범위를 벗어나는지 체크
                    if (start.col - move < 0) {
                        continue;
                    }
                    //사이에 장애물이 있는지
                    for (int col = start.col - 1; col >= start.col - move; col--) {
                        if (map[start.row][col] == 'X') {
                            isPossible = false;
                            break;
                        }
                    }
                    //둘다 아닌경우 그냥 빼준다.
                    if (isPossible) {
                        start.col -= move;
                    }

                    break;
                //동
                case "E":
                    if(start.col + move >= cols) {
                        continue;
                    }
                    for(int col = start.col+1; col <= start.col +move; col++) {
                        if(map[start.row][col] == 'X'){
                            isPossible=false;
                            break;
                        }
                    }
                    if(isPossible){
                        start.col+= move;
                    }
                    break;
                //남
                case "S":
                    if(start.row+move >= rows){
                        continue;
                    }
                    for(int row = start.row+1; row <= start.row +move;row++){
                        if(map[row][start.col] == 'X'){
                            isPossible=false;
                            break;
                        }
                    }
                    if(isPossible){
                        start.row+=move;
                    }
                    break;
                //북
                case "N":
                    if(start.row- move < 0){
                        continue;
                    }
                    for(int row = start.row-1;row >= start.row -move;row--){
                        if(map[row][start.col] =='X'){
                            isPossible=false;
                            break;
                        }
                    }
                    if (isPossible){
                        start.row-=move;
                    }
                    break;
            }

        }
        result[0] = start.row;
        result[1] = start.col;

        return result;
    }

    class Point {
        int row;
        int col;
    }


}