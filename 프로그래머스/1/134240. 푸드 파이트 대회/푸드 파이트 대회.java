class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<food.length; i++) {
            if(food[i] == 0) continue;
            int num = food[i]/2; 
            for(int j=0; j<num; j++) sb.append(Integer.toString(i));
        } 
        String per1 = sb.toString();
        String per2 = sb.reverse().toString();  
        answer = per1+"0"+per2;
        return answer;
    }
}