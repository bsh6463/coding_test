package kthnumber;

import java.util.ArrayList;
import java.util.Arrays;

public class KthNumber2 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        //ArrayList<Integer> temp = new ArrayList<>();
        int[] temp;

        int j=0;
        for (int[] command : commands) {
            temp = new int[command[1]-command[0]+1];
            int k=0;
            for (int i=command[0] -1; i <command[1]; i++ ){
                temp[k] = array[i];
                k++;
            }

            //Arrays.sort(temp);
            temp = sort(temp);
            answer[j] = temp[command[2]-1];
            j++;

        }

        return answer;
    }

    int[] sort(int[] array){
        int temp = 0;
        int size = array.length -1;

        for (int i=size; i>0; i--){
            for (int j=0; j < i; j++){
                if (array[j] > array[j+1]){
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }

       return array;
    }



    public static void main(String[] args) {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1}, {1,7,3}};

        KthNumber2 kthNumber = new KthNumber2();

        int[] answer = kthNumber.solution(array, commands);

        System.out.println("========answer=========");
        Arrays.stream(answer).forEach(System.out::println);
    }

}
