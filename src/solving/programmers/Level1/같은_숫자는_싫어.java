package solving.programmers.Level1;

import java.util.ArrayList;

public class 같은_숫자는_싫어 {
    public ArrayList<Integer> solution(int []arr) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i=1; i<arr.length; i++) {
            if(list.get(list.size()-1) != arr[i]) {
                list.add(arr[i]);
            }
        }

        return list;
    }
}
