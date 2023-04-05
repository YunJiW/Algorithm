class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        musics check_music = new musics();

        m = translate(m);
        for(int idx = 0; idx < musicinfos.length;idx++){
            //전부 분리
            String comment[] = musicinfos[idx].split(",");
            String start[] = comment[0].split(":");
            String end[] = comment[1].split(":");

            String Music_subject = comment[2];
            //변환
            String pitch = translate(comment[3]);

            int start_hour = Integer.parseInt(start[0]);
            int start_min = Integer.parseInt(start[1]);

            int end_hour = Integer.parseInt(end[0]);
            int end_min = Integer.parseInt(end[1]);

            if( end_min < start_min){
                end_hour -= 1;
                end_min+=60;
            }

            //플레이타임 체크
            int check_time = (end_hour - start_hour) *60 + (end_min - start_min);

            System.out.println("플레이타임 : " + check_time);
            String Music_pitch="";
            int Music_length = pitch.length();
            //음의 길이보다 작거나 같은 경우 자르기
            if(Music_length >= check_time){
                Music_pitch = pitch.substring(0,check_time);
            }
            //음 길이보다 긴 경우 자르기
            else {
                int per = check_time / Music_length;
                int div = check_time % Music_length;
                Music_pitch = pitch.repeat(per) + pitch.substring(0,div);
            }


            if(Music_pitch.contains(m))
            {
                //0인경우 없는 경우다.
                if(!check_music.checking){
                    check_music.checking = true;
                    check_music.playtime = check_time;
                    check_music.name = Music_subject;
                    continue;
                }
                //만약 플레이타임이 더 긴게 등장한경우 변경
                if(check_time > check_music.playtime){
                    check_music.playtime = check_time;
                    check_music.name = Music_subject;
                }
            }

        }
        if(!check_music.checking)
            answer = "(None)";
        else
            answer = check_music.name;
        return answer;
    }

    class musics{
        boolean checking = false;
        int playtime;
        String name;

    }

    //변환
    public String translate(String alpa){
        alpa = alpa.replace("A#" ,"a");
        alpa = alpa.replace("C#", "c");
        alpa = alpa.replace("D#","d");
        alpa = alpa.replace("F#","f");
        alpa = alpa.replace("G#","g");

        return alpa;
    }

}