class Solution {
    public String solution(String phone_number) {
        String answer = "*".repeat(phone_number.length()-4);
        answer = answer + phone_number.substring(phone_number.length()-4, phone_number.length());
        return answer;
    }
}