
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String Word = br.readLine();
		
		String[] Word_3 = new String[3];
		
		//단어들 다 받아두기
		ArrayList<String> Words = new ArrayList<>();
		
		
		for(int first = 1; first < Word.length()-1; first++)
		{
			for(int second = first+1; second< Word.length(); second++)
			{
				Word_3[0] = Word.substring(0, first);
				Word_3[1] = Word.substring(first,second);
				Word_3[2] = Word.substring(second,Word.length());
				
				StringBuffer sb = new StringBuffer();
				
				for(int index =0; index < 3 ; index++)
				{
					for(int i = Word_3[index].length()-1; i >= 0; -- i)
					{
						sb.append(Character.toString(Word_3[index].charAt(i)));
					}
				}
				
				Words.add(sb.toString());
				sb.setLength(0);
			}
		}
		
		Collections.sort(Words);
		
		System.out.println(Words.get(0));
		
		
	}
}
