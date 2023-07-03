class Solution {

    static char map[][];


    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int t = 0; t < places.length; t++) {
            map = new char[5][5];
            for (int idx = 0; idx < places[t].length; idx++) {
                map[idx] = places[t][idx].toCharArray();
            }
            //응시자수 체크용
            int pcount = 0;
            //최대 인원수
            Person person[] = new Person[25];
            //응시자 체크
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    if (map[row][col] == 'P') {
                        Person person1 = new Person(row, col);
                        person[pcount++] = person1;
                    }
                }
            }
            //응시자가 1명인경우
            if(pcount==1){
                answer[t] = 1;
                continue;
            }

            //각 응시자들의 거리 계산 -> 이상없는경우 true 이상있을경우 false 리턴
            if (distanceP(person, pcount)) {
                answer[t] = 1;
            } else {
                answer[t] = 0;
            }
        }


        return answer;
    }

    private boolean distanceP(Person[] person, int pcount) {
        for (int idx = 0; idx < pcount; idx++) {
            for (int j = idx + 1; j < pcount; j++) {
                if ((Math.abs(person[idx].row - person[j].row) + Math.abs(person[idx].col - person[j].col)) <= 1) {
                    return false;
                }

                //맨해튼 거리가 2이하일경우
                if ((Math.abs(person[idx].row - person[j].row) + Math.abs(person[idx].col - person[j].col)) <= 2) {
                    //빈테이블이 있는경우 -> 불가능한경우
                    if (!isPossible(person[idx], person[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isPossible(Person person, Person person1) {
        int min_row = Math.min(person.row, person1.row);
        int max_row = Math.max(person.row, person1.row);
        int min_col = Math.min(person.col, person1.col);
        int max_col = Math.max(person.col, person1.col);

        for (int row = min_row; row <= max_row; row++) {
            for (int col = min_col; col <= max_col; col++) {
                //빈테이블이 있는경우 끝
                if(map[row][col] == 'O')
                    return false;
            }
        }
        return true;
    }

    static class Person {
        int row;
        int col;

        Person(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}