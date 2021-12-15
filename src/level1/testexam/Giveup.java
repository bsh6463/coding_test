package level1.testexam;

import java.util.Arrays;

public class Giveup {

    public int[] solution(int[] answers) {
        int[] temp;
        int[] result = new int[3];
        int[][] giveUpMembers = { {1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};


        for (int[] member : giveUpMembers) {

            for (int i=0; i<answers.length; i++){
                int answer = answers[i];
                int position = (i) % member.length;

                if (member.length == 5){
                    if (answer == member[position]){
                       result[0]++;
                    }
                }else if (member.length == 8){
                    if (answer == member[position]){
                        result[1]++;
                    }
                }else {
                    if (answer == member[position]){
                        result[2]++;
                    }
                }
            }
        }

        //최대값? 가장 많이 맞춘 사람 몇명?
        int max = Arrays.stream(result).max().getAsInt();
        int size = (int) Arrays.stream(result).filter(a -> a == max).count();
        temp = new int[size];

        //최대값 가지는 index찾기.
        int j=0;
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

        Giveup giveup = new Giveup();
        int[] answer = giveup.solution(answers);

        System.out.println("===answer=====");
        Arrays.stream(answer).forEach(System.out::println);
    }

}
