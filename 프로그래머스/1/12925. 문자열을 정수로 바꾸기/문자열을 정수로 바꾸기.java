class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] str = s.split("\\- | \\+");
        answer = Integer.parseInt(str[str.length-1]);
        return answer;
    }
}