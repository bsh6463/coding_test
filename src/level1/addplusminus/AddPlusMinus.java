package level1.addplusminus;

import java.util.HashMap;

public class AddPlusMinus {

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        HashMap<Boolean, Integer> translator = new HashMap<>();
        translator.put(true, 1);
        translator.put(false, -1);

        for (int i=0; i<absolutes.length; i++){
            answer += absolutes[i] * translator.get(signs[i]);
        }
        return answer;
    }



}
