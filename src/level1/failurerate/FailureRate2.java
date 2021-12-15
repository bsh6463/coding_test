package level1.failurerate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FailureRate2 {
    public int[] solution(int N, int[] stages) {
        int[] answer =  new int[N];
        int totalNumber = stages.length;
        ArrayList<Stage> container = new ArrayList<>(N);
        ArrayList<Double> count = new ArrayList<>(N);

        for (int i=0; i<N;i++){
            count.add(i, 0.0);
        }
        //1부터 N까지 돌면서
        // i  == stage -> 도달했으나, 깨지 못함.
        // i <= stage -> 현재 stage 도달, 넘어간 사람

        //각 단계에 몇명 있는지 구분 1 -> 0, 2 -> 1
        for (int i=0; i < stages.length;i++){
            count.add(stages[i]-1, count.get(stages[i]-1)+1);
        }

        int countPeople = 0;
        for (int i=1; i<=N; i++){
            int appAndPass = totalNumber - countPeople;
            if (appAndPass !=0){
                container.add(new Stage(count.get(i-1)/(appAndPass), i));
            }else {
                container.add(new Stage(0.0,i));
            }
            countPeople += count.get(i);
        }



        answer = container.stream().sorted(new Comparator<Stage>() {
            @Override
            public int compare(Stage o1, Stage o2) {
                if (o1.failureRate > o2.failureRate) {
                    return -1;
                } else if (o1.failureRate.equals(o2.failureRate)) {
                    return o1.stageNumber - o2.stageNumber;
                } else {
                    return 1;
                }
            }
        }).mapToInt(stage -> stage.stageNumber).toArray();
        return answer;
    }

    public static class Stage{
        Double failureRate;
        int stageNumber;

        public Stage(Double failureRate, int stageNumber) {
            this.failureRate = failureRate;
            this.stageNumber = stageNumber;
        }
    }

    public static void main(String[] args) {

        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        FailureRate2 failureRate = new FailureRate2();
        int[] solution = failureRate.solution(N, stages);

        System.out.println("====answer====");
        Arrays.stream(solution).forEach(System.out::println);
    }
}
