package solving.programmers.Level1;

public class 가운데_글자_가져오기 {
    public String solution(String s) {

        int len = s.length();
        int div = len / 2;
        if(len%2 == 1) return Character.toString(s.charAt(div));
        else return s.substring(div-1, div+1);
    }
}
