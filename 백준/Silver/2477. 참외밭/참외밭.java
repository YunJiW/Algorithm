import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Line line[] = new Line[6];

        int Max_width = Integer.MIN_VALUE;
        int width_idx = 0;
        int Max_height = Integer.MIN_VALUE;
        int height_idx = 0;
        for(int idx = 0; idx <6;idx++){
            st = new StringTokenizer(br.readLine()," ");
            Line line1 = new Line();
            line1.pos=Integer.parseInt(st.nextToken());
            line1.length = Integer.parseInt(st.nextToken());
            if(line1.pos == 1 || line1.pos == 2){
                if(Max_width < line1.length){
                    Max_width = line1.length;
                    width_idx = idx;
                }
            }
            else{
                if(Max_height < line1.length){
                    Max_height = line1.length;
                    height_idx = idx;
                }
            }
            line[idx] = line1;
        }

        //전체 넓이
        int Max_St = Max_height * Max_width;
        int diff_width = 0;
        int diff_height = 0;
        if(width_idx == 0 ){
            diff_width= Math.abs(line[5].length - line[width_idx+1].length);
        }else if(width_idx == 5){
            diff_width = Math.abs(line[width_idx-1].length - line[0].length);
        }else{
            diff_width = Math.abs(line[width_idx-1].length - line[width_idx+1].length);
        }
        if (height_idx == 0){
            diff_height = Math.abs(line[5].length - line[height_idx+1].length);
        }else if(height_idx == 5){
            diff_height = Math.abs(line[height_idx-1].length - line[0].length);
        }else{
            diff_height = Math.abs(line[height_idx-1].length - line[height_idx+1].length);
        }

        int result = Max_St - (diff_width * diff_height);



        System.out.println(result*N);

    }

    static class Line{
        int pos;
        int length;
    }
}
