import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    //건설한 건축물들 모아놓기.
    List<Build> buildList = new ArrayList<>();

    int size = 0;

    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        size = n;

        //kind 종류
        //check : 0 삭제 1 설치
        for (int idx = 0; idx < build_frame.length; idx++) {
            int col = build_frame[idx][0];
            int row = build_frame[idx][1];
            int kind = build_frame[idx][2];
            int check = build_frame[idx][3];

            Build builder = new Build(col, row, kind);

            //설치
            if (check == 1) {
                //기둥
                if (kind == 0) {
                    if (isPossiblePillar(builder)) {
                        buildList.add(builder);
                    }

                    //보 설치
                } else {
                    if (isPossibleBeam(builder)) {
                        buildList.add(builder);
                    }

                }

                //삭제
            } else {
                buildList.remove(builder);
                if(!isDelete()){
                    buildList.add(builder);
                }
            }
        }


        //정렬
        Collections.sort(buildList, (o1, o2) -> {
            if (o1.col == o2.col) {
                if(o1.row == o2.row){
                    return o1.type - o2.type;
                }
                return o1.row - o2.row;
            }

            return o1.col - o2.col;
        });


        answer = new int[buildList.size()][3];
        for (int idx = 0; idx < buildList.size(); idx++) {
            Build build = buildList.get(idx);
            answer[idx][0] = build.col;
            answer[idx][1] = build.row;
            answer[idx][2] = build.type;
        }

        return answer;
    }

    private boolean isDelete() {

        for(Build list : buildList){
            if(list.type == 0){
                if(!isPossiblePillar(list)){
                    return false;
                }

            }else{
                if(!isPossibleBeam(list)){
                    return false;
                }
            }
        }
        return true;
    }


    //기둥 설치가 가능한지 체크
    public boolean isPossiblePillar(Build build) {
        int row = build.row;
        int col = build.col;

        //바닥 위인지
        if (build.row == 0) {
            return true;
        }

        //보의 한쪽 끝인지 (세로 좌표는 같으면서 가로 좌표가 -1 인경우)
        if (col -1 >= 0 && buildList.contains(new Build(col-1,row,1))) {
            return true;
        }
        //현재 위치 보 도 확인
        if(buildList.contains(new Build(col,row,1))){
            return true;
        }

        //또 다른 기둥 위인지
        if (row -1 >= 0  && buildList.contains(new Build(col,row-1,0))) {
            return true;
        }


        return false;

    }

    //보 설치가 가능한지 체크
    public boolean isPossibleBeam(Build build) {
        int row = build.row;
        int col = build.col;
        //한쪽 끝부분이 기둥위인가
        if (row -1 >= 0 && (buildList.contains(new Build(col,row-1,0)) || buildList.contains(new Build(col+1,row-1,0)))) {
            return true;
        }
        //현재 좌표의 왼쪽에 보가 있고 오른쪽에도 보가 있는가
        if (col-1 >= 0 && (buildList.contains(new Build(col-1,row,1)) && buildList.contains(new Build(col+1,row,1)))) {
            return true;
        }

        return false;
    }

    public class Build {
        //row -> 세로좌표
        int col;

        //가로 좌표
        int row;
        // 0 은 기둥, 1은 보
        int type;

        public Build(int col, int row, int type) {
            this.col = col;
            this.row = row;
            this.type = type;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Build other = (Build) obj;
            if (type != other.type)
                return false;
            if (col != other.col)
                return false;
            if (row != other.row)
                return false;
            return true;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + type;
            result = prime * result + col;
            result = prime * result + row;
            return result;
        }

    }
}