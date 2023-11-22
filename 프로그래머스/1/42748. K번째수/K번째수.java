/*
i번째 ~ j번째까지 자르고 정렬
k번째 수 
순서는 1부터 시작
*/
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int c=0; c<answer.length; c++) {
            int[] com = commands[c];
            int i = com[0]-1;
            int j = com[1]-1;
            int k = com[2]-1;
            int[] cut = Arrays.copyOfRange(array, i, j+1); 
            Arrays.sort(cut);
            answer[c] = cut[k];
        }
        return answer;
    }
}