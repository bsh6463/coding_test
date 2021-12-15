package level1.dart;

import java.util.Arrays;

public class Dart {

    public int solution(String dartResult) {
        int[] result = new int[3];
        int beforeNumber = 0;
        int index = 0;

        for (int i=0; i< dartResult.length(); i++){
            char c = dartResult.charAt(i);
            Integer point = getPoint(c);
            if (point != null){
                //숫자인 경우
                if (point == 0 && beforeNumber == 1){
                    point = 10;
                    index--;
                }
                result[index] = point;
                beforeNumber = point;
                index++;
            }else {
                if (c == 'S'){
                    result[index-1] = (int) Math.pow(result[index-1], 1);
                }else if (c == 'D'){
                    result[index-1] = (int) Math.pow(result[index-1], 2);
                }else if (c == 'T'){
                    result[index-1] = (int) Math.pow(result[index-1], 3);
                }else if (c == '*'){
                    result[index-1] = result[index-1] * 2;
                    if(index > 1){
                        result[index-2] = result[index-2] * 2;
                    }
                }else if (c == '#'){
                    result[index-1] = result[index-1]*(-1);
                }
            }
        }

        return Arrays.stream(result).sum();
    }


    public Integer getPoint(char c){
        switch (c){
            case '0': return 0;
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
        }
        return null;
    }


    public static void main(String[] args) {

        Dart dart = new Dart();
        String dartResult = "1D2S#10S";
        int solution = dart.solution(dartResult);
        System.out.println("====answer===");
        System.out.println(solution);
    }

}
