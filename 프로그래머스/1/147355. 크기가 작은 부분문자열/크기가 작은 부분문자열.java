class Solution {
    public int solution(String t, String p) {
        //범위가 아닌 문자열의 길이가 10,000까지이기 때문에 long 사용
        int cnt = 0;
        int len = p.length();
        for(int i=0; i<t.length()-len+1; i++) {
            if(Long.parseLong(t.substring(i, i+len)) <= Long.parseLong(p)) cnt++;
        }
         
        return cnt;
    }
}