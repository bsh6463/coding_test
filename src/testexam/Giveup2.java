package testexam;

import java.util.Arrays;

public class Giveup2 {

    public int[] solution(int[] answers) {
        int[] temp;
        int[] result = new int[3];
        int[][] giveUpMembers = { {1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        int max=0;
        int size=0;
        for (int j=0; j<giveUpMembers.length;j++) {
            int[] member = giveUpMembers[j];

            for (int i=0; i<answers.length; i++){
                int answer = answers[i];

                if(answer == member[(i) % member.length]){
                    result[j]++;
                }
            }

            //max값 및 가장 많이 맞춘 사람 수 세기
            if (result[j] > max){
                //1등이 한명
                max= result[j];
                size =1;
            }else if (result[j] == max){
                //1등이 여러명
                size++;
            }
        }

        //최대값 가지는 index찾기.
        int j=0;
        temp = new int[size];
        for (int i=0; i<result.length; i++){
            if (result[i] == max){
                temp[j] = (i+1);
                j++;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] answers = {1, 3, 2, 4, 2};

        Giveup2 giveup = new Giveup2();
        int[] answer = giveup.solution(answers);

        System.out.println("===answer=====");
        Arrays.stream(answer).forEach(System.out::println);
    }

}
