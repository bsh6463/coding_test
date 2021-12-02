package kthnumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> temp = new ArrayList<>();

        int j=0;
        for (int[] command : commands) {
            for (int i=command[0] -1; i <command[1]; i++ ){
                temp.add(array[i]);
            }
            temp.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });

            answer[j] = temp.get(command[2]-1);
            j++;
            temp.clear();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1}, {1,7,3}};

        KthNumber kthNumber = new KthNumber();

        int[] answer = kthNumber.solution(array, commands);

        System.out.println("========answer=========");
        Arrays.stream(answer).forEach(System.out::println);
    }

}
