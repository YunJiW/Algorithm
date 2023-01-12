import java.util.LinkedHashSet;

class Solution
{
	public int solution(int cacheSize,String[] cities) {
		int Runtime = 0;
		LinkedHashSet<String> cache = new LinkedHashSet<>();
		
        if(cacheSize == 0)
        {
            Runtime+=(cities.length *5);
            return Runtime;
        }
        
		for(int index = 0;index <cities.length;index++)
		{
			String city_name = cities[index].toLowerCase();
            
            
            if(cache.isEmpty())
            {
                cache.add(city_name);
                Runtime+=5;
                continue;
            }
            
            if(cache.size() < cacheSize && !(cache.contains(city_name))){
                cache.add(city_name);
                Runtime+=5;
                continue;
            }
			
			if(cache.contains(city_name))
			{
				cache.remove(city_name);
				cache.add(city_name);
				Runtime+=1;
				continue;
			}
			
			if(cache.size() == cacheSize) {
				cache = Remove(cache);
				cache.add(city_name);
				Runtime+=5;
				continue;
			}
			
			
		}
		
		return Runtime;
	}

	private LinkedHashSet<String> Remove(LinkedHashSet<String> cache) {
		for(String name : cache)
		{
			cache.remove(name);
			break;
		}
		
		return cache;
	}
}
