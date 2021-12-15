package lotto;

import java.util.Arrays;

public class Lotto {

    public int[] solution(int[] lottos, int[] win_nums) {

        int[] answer = new int[2];
        int countZeros = 0;
        int winCount = 0;

        for(int i=0; i < lottos.length; i++){
            int num = lottos[i];
            if (num == 0){
                countZeros++;
            }
            for (int j=0;j<win_nums.length; j++){
                if (num == win_nums[j]){
                    winCount++;
                }
            }
        }

        int max = countZeros + winCount;
        int min = winCount;


        answer[0] = getRank(max);
        answer[1] = getRank(min);

        return answer;

    }

    public int getRank(int number) {

        switch (number) {

            case 6:
                return 1;

            case 5:
                return 2;

            case 4:
                return 3;

            case 3:
                return 4;

            case 2:
                return 5;

            case 1:
                return 6;

            case 0:
                return 6;

        }

        return 0;
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] winNums = {31, 10, 45, 1, 6, 19};

        Lotto lotto = new Lotto();
        int[] answer = lotto.solution(lottos, winNums);

        System.out.println("====answer===");
        Arrays.stream(answer).forEach(System.out::println);
    }

}
