package solving.programmers.Level1;

public class 문제_3진법_뒤집기 {
    public int solution(int n) {
        int answer = 0;

        // n -> 3진법 & 결과는 뒤부터 저장됨
        ArrayList<Integer> arith = new ArrayList();
        int now = n;
        while(true) {
            if(now == 1) {
                arith.add(1);
                break;
            }

            int share = now/3;
            int remain = now%3;

            arith.add(remain);
            if(share == 0 || share == 1 || share == 2) {
                arith.add(share);
                break;
            }
            now = share;
        }

        //System.out.println(arith);

        // 10진법으로 변경
        for(int i=0; i<arith.size(); i++) {
            int opt = arith.size()-1-i;
            answer += arith.get(i) * Math.pow(3, opt);
        }

        return answer;
    }
}
