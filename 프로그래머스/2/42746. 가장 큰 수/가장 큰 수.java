import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strings = Arrays.stream(numbers)
                                .mapToObj(String::valueOf)
                                .toArray(String[]::new); 
        
        Arrays.sort(strings, (s1, s2) -> (s2+s1).compareTo(s1+s2));
        if(strings[0].equals("0")) return "0"; 
        return String.join("", strings);
    }
}