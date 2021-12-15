package level1.budget;

import java.util.Arrays;

public class Budget2 {

    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;

        Arrays.sort(d);

        //부서수를 최대한 늘리기 위해 가장 작은 금액부터 추가
        for (int i=0; i<d.length; i++){
            sum += d[i];
            if (sum <= budget){
                answer++;
            }else break;
        }

        return answer;
    }

}
