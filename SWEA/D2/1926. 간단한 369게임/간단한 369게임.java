
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int index =1 ; index <=N;index++)
        {
                String S = String.valueOf(index);
                if(index <10)
                {
                    if(index == 3 || index == 6 || index == 9)
                        sb.append("-").append(" ");
                    else
                        sb.append(index).append(" ");
                }else if(index <100){
                    int cnt = 0;
                    for(int k = 0; k<S.length();k++)
                    {
                        if((S.charAt(k) - '0' == 3) || (S.charAt(k) - '0' == 6)  ||(S.charAt(k) - '0' == 9))
                            cnt++;
                    }
                    if(cnt == 0)
                        sb.append(index).append(" ");
                    else if(cnt == 1)
                        sb.append("-").append(" ");
                    else
                        sb.append("--").append(" ");
                }else{
                    int cnt = 0;
                    for(int k = 0; k<S.length();k++)
                    {
                        if((S.charAt(k) - '0' == 3) || (S.charAt(k) - '0' == 6)  ||(S.charAt(k) - '0' == 9))
                            cnt++;
                    }
                     if(cnt == 0)
                        sb.append(index).append(" ");
                    else if(cnt == 1)
                        sb.append("-").append(" ");
                    else if(cnt == 2)
                        sb.append("--").append(" ");
                    else
                        sb.append("---").append(" ");
            }
        }
        System.out.print(sb);
	}
        
    }
