import java.util.*;

class Solution { 
    public int[] solution(int[] answers) { 
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int score1 = 0, score2 = 0, score3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == pattern1[i % pattern1.length]) score1++;
            if(answers[i] == pattern2[i % pattern2.length]) score2++;
            if(answers[i] == pattern3[i % pattern3.length]) score3++;
        }
        
        int maxScore = Math.max(score1, Math.max(score2, score3));
        ArrayList<Integer> arr = new ArrayList();
        if(score1==maxScore) arr.add(1);
        if(score2==maxScore) arr.add(2);
        if(score3==maxScore) arr.add(3);
         
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
         
        return answer;
    }
}