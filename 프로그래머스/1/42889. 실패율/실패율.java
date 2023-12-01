import java.util.*;
// 원소와 원래의 인덱스를 묶는 튜플 클래스
class Tuple {
    float value;
    int index;

    Tuple(float value, int index) {
        this.value = value;
        this.index = index;
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        // 스테이지에 도달한 유저
        int[] arrive = new int[N+1];
        
        // 스테이지를 클리어한 유저
        int[] fail = new int[N+1];
        
        for(int s : stages) {
            //1~s까지 도달 ++
            for(int i=1; i<=Math.min(s, N); i++){
                arrive[i]++;
            }
            
            //s fail ++
            if(s<=N) fail[s]++; 
        }
        
        float[] percent = new float[N+1];
        for(int i=1; i<=N; i++) {
            if (arrive[i] != 0) {
                percent[i] = (float)fail[i] / arrive[i];
            } else {
                percent[i] = 0;  // 도달한 유저가 없는 경우, 실패율은 0
            }
        } 
        
        Tuple[] tuples = new Tuple[N];
        for (int i = 1; i <=N; i++) {
            tuples[i-1] = new Tuple(percent[i], i);
        }
        
        Arrays.sort(tuples, (o1, o2) -> {
                    if (Float.compare(o2.value, o1.value) == 0) {
                        return Integer.compare(o1.index, o2.index);  // i가 작은 순으로 정렬
                    }
                    return Float.compare(o2.value, o1.value);  // 내림차순
                });

        // 정렬된 튜플에서 원래의 인덱스만 추출
        int[] answer = new int[tuples.length];
        for (int i = 0; i < tuples.length; i++) {
            answer[i] = tuples[i].index;
        }

        // 결과 출력
        //System.out.println(Arrays.toString(answer));

        return answer;
    }
}