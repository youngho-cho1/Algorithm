package Hash;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion){
        String answer = "";
        // 1. Hash Map을 만든다
        HashMap<String, Integer> map = new HashMap<>();
        for(String player : participant)
            map.put(player, map.getOrDefault(player, 0)+1);
        // 2. Hash Map을 뺀다
        // 3. value가 0이 아닌 선수를 찾는다
        for(String player : completion)
            map.put(player, map.get(player)-1);
        /*for(String key : map.keySet()){
            if(map.get(key) != 0){
                answer = key;
                break;
            }
        }*/
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            if(entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }
    
    public static void main(String[] args){
        String[] part = {"leo", "kiki", "edan"};
        String[] comp = {"edan", "kiki"};
        Solution sol = new Solution();
        System.out.println(sol.solution(part, comp));
    }
}