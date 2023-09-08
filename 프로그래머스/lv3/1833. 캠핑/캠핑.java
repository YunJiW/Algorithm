import java.util.*;

class Solution {


    public int solution(int n, int[][] data) {

        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();

        int[][] dp = new int[5000][5000];

        //좌표 압축 진행
        for (int idx = 0; idx < data.length; idx++) {
            xList.add(data[idx][0]);
            yList.add(data[idx][1]);
        }

        ArrayList<Integer> uniqueXList = new ArrayList<>(new HashSet<>(xList));
        ArrayList<Integer> uniqueYList = new ArrayList<>(new HashSet<>(yList));


        Collections.sort(uniqueXList);
        Collections.sort(uniqueYList);

        //좌표 압축 완료
        for (int idx = 0; idx < n; idx++) {
            data[idx][0] = uniqueXList.indexOf(xList.get(idx));
            data[idx][1] = uniqueYList.indexOf(yList.get(idx));

            dp[data[idx][0]][data[idx][1]] = 1;
        }


        // N^2 구간합 구하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                dp[i][j] += (i - 1 >= 0 ? dp[i - 1][j] : 0)
                        + (j - 1 >= 0 ? dp[i][j - 1] : 0)
                        - (i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1] : 0);
            }
        }


        int ans = 0;
        // N^2 모든 쐐기 조합에 대하여 검사
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                // 조건#1 검사 : 직사각형이 아닌 경우
                if (data[i][0] == data[j][0] || data[i][1] == data[j][1]) continue;

                // 조건#2 검사 : 내부에 쐐기가 존재하는 경우
                int startX, startY, endX, endY;

                startX = Math.min(data[i][0], data[j][0]);
                startY = Math.min(data[i][1], data[j][1]);
                endX = Math.max(data[i][0], data[j][0]);
                endY = Math.max(data[i][1], data[j][1]);

                int cnt;

                if (startX + 1 > endX - 1 || startY + 1 > endY - 1) {

                    cnt = 0;
                } else {

                    cnt = dp[endX - 1][endY - 1] - dp[endX - 1][startY] - dp[startX][endY - 1] + dp[startX][startY];
                }

                if (cnt == 0) ans++;
            }
        }
        return ans;
    }
}