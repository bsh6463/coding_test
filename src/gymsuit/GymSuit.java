package gymsuit;

import java.util.Arrays;

public class GymSuit {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] count = new int[n];

        //각자 가지고 있는 체육복 수량
        for (int i=0; i<n; i++){
            count[i] = 1;
            for (int surplus : reserve) {
                if (i+1 == surplus){
                    count[i]++;
                }
            }

            for (int minus : lost) {
                if (i+1 == minus){
                    count[i]--;
                }
            }
        }

        for (int i=1; i<n-1; i++){
            if (count[i] > 1){
                if (count[i-1] == 0){
                    count[i]--;
                    count[i-1]++;
                }else if (count[i+1]==0){
                    count[i]--;
                    count[i+1]++;
                }

            }else if (count[i] ==0 ){
                if (count[i-1] > 1){
                    count[i]++;
                    count[i-1]--;
                }else if (count[i+1] > 1){
                    count[i]++;
                    count[i+1]--;
                }
            }
        }

        return (int) Arrays.stream(count).filter(c -> c != 0).count();
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        GymSuit gymSuit =new GymSuit();
        int answer = gymSuit.solution(n, lost, reserve);
        System.out.println("====answer=====");
        System.out.println(answer);

    }
}
