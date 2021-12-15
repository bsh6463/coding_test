package level1.secretmap;

import java.util.Arrays;

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i=0; i<n; i++){

            int[] digit1 = getDigit(arr1[i], n);
            int[] digit2 = getDigit(arr2[i], n);

            StringBuilder temp = new StringBuilder();

            for (int j=0; j<n; j++){
                if (digit1[j] == 0 && digit2[j] == 0){
                    temp.append(" ");
                }
                else{
                    temp.append("#");
                }
            }

            answer[i] = temp.toString();
        }

        return answer;
    }

    public int[] getDigit(int n, int size){
        int[] digits = new int[size];
        int Q = 0;
        int R = 0;

        for (int i=0; i<size; i++){
            Q = n/2;
            R = n%2;
            digits[size-1-i] = R;
            if (Q != 0){
                n =Q;
            }else {
                return digits;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int n= 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2= {30, 1, 21, 17, 28};

        SecretMap secretMap =new SecretMap();
        String[] answer = secretMap.solution(n, arr1, arr2);

        System.out.println("===answer====");
        Arrays.stream(answer).forEach(System.out::println);
    }

}
