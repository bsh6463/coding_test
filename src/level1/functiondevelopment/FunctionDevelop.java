package level1.functiondevelopment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelop {

    public int[] solution(int[] progresses, int[] speeds) {

       int[] answer;
        Queue<Integer> answerQueue = new LinkedList<>();

        ArrayList<Function> functionList = new ArrayList<>();

        for (int i=0; i<progresses.length; i++){
            functionList.add(new Function(progresses[i], speeds[i]));
        }

        int cnt = 0;
        int temp =0;
        for (int i=0; i<functionList.size(); i++){
            if (i == 0){
                temp = functionList.get(0).getRemain();
              cnt = 1;
            }
            else if (functionList.get(i).getRemain() <= temp){
                cnt++;
            }else {
                /**
                 * 현재 기능의 남을 일수가 temp(앞의 기능)보다 큰 경우 앞의 기능과 같이 배포 불가
                 * 현재까지 cnt를 answer에 넣어준다.
                 * temp를 현재 기능으로 변경한다.
                 * 새로 cnt를 시작한다. cnt=1
                 */
                temp = functionList.get(i).getRemain();
                answerQueue.add(cnt);
                cnt=1;
            }
        }


        //마지막에 증가된 cnt 반영.
        answerQueue.add(cnt);

        //queue를 배열로
        answer = new int[answerQueue.size()];
        int i=0;
        for (Integer integer : answerQueue) {
            if (integer !=0){
                answer[i] = integer;
                i++;
            }else {
                break;
            }
        }

        return  answer;
    }

    public class Function {

        private int remain;

        public Function(int progress, int speed) {
            this.remain = calculateRemain(progress, speed);
        }

        private int calculateRemain(int progress, int speed) {
            int quotient = (100 - progress) / speed;
            int remainder = (100 - progress) % speed;

            if (remainder > 0){
                quotient++;
            }

            return quotient;
        }

        public int getRemain() {
            return remain;
        }
    }

    public static void main(String[] args) {
        FunctionDevelop functionDevelop = new FunctionDevelop();

        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};

        int[] result1 = functionDevelop.solution(progresses1, speeds1);

        System.out.println("===================");
        Arrays.stream(result1).forEach(System.out::println);
        System.out.println("===================");

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};

        int[] result2 = functionDevelop.solution(progresses2, speeds2);

        System.out.println("===================");
        Arrays.stream(result2).forEach(System.out::println);
        System.out.println("===================");
    }

}
