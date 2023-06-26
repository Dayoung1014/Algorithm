package solving.programmers.Level1;

public class 핸드폰_번호_가리기 {
    public String solution(String phone_number) {
        String answer = "*".repeat(phone_number.length()-4);
        answer = answer + phone_number.substring(phone_number.length()-4, phone_number.length());
        return answer;
    }
}
