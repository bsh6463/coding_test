package level1.secretmap;

import java.util.Arrays;

public class SecretMap2 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i=0; i<n; i++){
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            answer[i]= String.format("%"+n+"s", answer[i]);
            answer[i]= answer[i].replace("1" , "#");
            answer[i]= answer[i].replace("0" , " ");
        }

        return answer;
    }

    public static void main(String[] args) {
        int n= 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2= {30, 1, 21, 17, 28};

        SecretMap2 secretMap =new SecretMap2();
        String[] answer = secretMap.solution(n, arr1, arr2);

        System.out.println("===answer====");
        Arrays.stream(answer).forEach(System.out::println);

    }

}
