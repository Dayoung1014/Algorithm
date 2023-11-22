class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        int[] answer = new int[str.length()];
        for(int i=0; i<answer.length; i++) { 
           answer[i] =str.charAt(answer.length-1-i)-'0';
        }
        return answer;
    }
}