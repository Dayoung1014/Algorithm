package solving.programmers.Level1;

public class 숫자_문자열과_영단어 {
    public int solution(String s) {
        // 영어 숫자 섞인 문자열 주어지면 -> 숫자로 반환하기
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String res = "";

        // 숫자 0~9 아스키 코드값 48~57
        String word="";
        for(int i=0; i<s.length(); i++) {
            char now = s.charAt(i);
            if((now - '0') == Character.getNumericValue(now)) {
                res += now;
            }
            else {
                word += now;
                for(int w=0; w<10; w++) {
                    if(word.equals(arr[w])) {
                        res += w;
                        word = "";
                    }
                }

            }
        }

        return Integer.parseInt(res);
    }
}
