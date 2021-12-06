package failurerate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FailureRate2 {
    public int[] solution(int N, int[] stages) {
        int[] answer =  new int[N];
        double approached = 0; //나누기 해서 소수표시하려고
        double appAndPass = 0;
        ArrayList<Stage> container = new ArrayList<>();

        //1부터 N까지 돌면서
        // i  == stage -> 도달했으나, 깨지 못함.
        // i <= stage -> 현재 stage 도달, 넘어간 사람

        for(int i=1; i<=N; i++){
            for (int stage : stages) {
                if (stage == i){
                    approached++;
                    appAndPass++;
                }else if (stage > i){
                    appAndPass++;
                }
            }

            //분모로 들어가는 현재 스테이지 도달한 사람의 수가 0일 수 있음.
            if (appAndPass != 0){
                container.add(new Stage(approached / appAndPass, i));
            }else {
                container.add(new Stage(0.0, i));
            }
            approached = 0;
            appAndPass = 0;
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

        int N = 4;
        int[] stages = {4,4,4,4,4};

        FailureRate2 failureRate = new FailureRate2();
        int[] solution = failureRate.solution(N, stages);

        System.out.println("====answer====");
        Arrays.stream(solution).forEach(System.out::println);
    }
}
