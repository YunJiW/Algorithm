import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> words = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char box[][] = new char[R][C];
		
		
		
		for(int rows=0;rows <R;rows++)
		{
			String line =br.readLine();
			for(int cols=0;cols<C;cols++)
			{
				box[rows][cols] = line.charAt(cols);
			}
		}
		
		
		//가로 체크
		for(int rows=0;rows <R;rows++)
		{
			String word ="";
			for(int cols=0;cols<C;cols++)
			{
				//벽을 만났을때 2자 이상일경우 넣어둠.
				if(box[rows][cols] == '#')
				{
					if(word.length() >=2)
					{
						words.add(word);
					}
					word="";
				}
				else
				{
					word+=box[rows][cols];
				}
			}
			//한줄 다돌고나서 단어가 2자 이상일경우 추가해둠
			if(word.length()>=2)
			{
				words.add(word);
			}
		}
		

		//세로 체크
		for(int cols=0;cols<C;cols++) {
			String word ="";
			for(int rows=0;rows <R;rows++) {
				if(box[rows][cols] == '#')
				{
					if(word.length()>=2)
					{
						words.add(word);
					}
					word="";
				}
				else
				{
					word+=box[rows][cols];
				}
			}
			
			if(word.length()>=2)
			{
				words.add(word);
			}
		}
		
		
		
		
		
		Collections.sort(words);
		
		System.out.println(words.get(0));
		
	}
}
