import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution 
{
	
	class records{
		String gen;
		int play;
		int idx;
		
		public records(String gen,int play,int idx) {
			this.gen =gen;
			this.play =play;
			this.idx= idx;
		}
	}
	
	
	public int[] solution(String[] genres,int[] plays) {
		
		HashMap<String,Integer> genre_check= new HashMap<>();
		
		for(int index = 0;index <genres.length;index++)
		{
			genre_check.put(genres[index],genre_check.getOrDefault(genres[index], 0) + plays[index]);
		}
		
		//장르 순서 먼저
		ArrayList<String> list = new ArrayList<>();
		
		while(!genre_check.isEmpty())
		{
			int max = -1;
			String tmp = "";
			for(String genre : genre_check.keySet())
			{
				if(max < genre_check.get(genre))
				{
					max = genre_check.get(genre);
					tmp = genre;
				}
			}
			list.add(tmp);
			genre_check.remove(tmp);
		}
		//장르 내 순서 
		ArrayList<records> List = new ArrayList<>();
		for(String genre_name : list) {
			ArrayList<records> lists = new ArrayList<>();
			for(int index = 0; index < genres.length;index++)
			{
				if(genres[index].equals(genre_name))
				{
					lists.add(new records(genre_name,plays[index],index));;
				}
			}
			//내림차순 정렬
			Collections.sort(lists, new Comparator<records>() {

				@Override
				public int compare(records o1, records o2) {
                    
                    if(o1.play == o2.play){
                        return o1.idx - o2.idx;
                    }      
                    
					return o2.play - o1.play;
				}
				
			});
			
			List.add(lists.get(0));
			if(lists.size() != 1)
			{
				List.add(lists.get(1));
			}
			
		}
		
		int answer[] = new int[List.size()];
		
		for(int idx = 0; idx<List.size();idx++)
		{
			answer[idx] = List.get(idx).idx;
		}
		
		return answer;
	}
}