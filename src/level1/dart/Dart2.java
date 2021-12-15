package level1.dart;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Dart2 {

    public int solution(String dartResult) {
        int[] result = new int[3];
        int index = 0;
        StringTokenizer tokenizer =  new StringTokenizer(dartResult, "SDT*#", true);

        while (tokenizer.hasMoreTokens()){
            String s = tokenizer.nextToken();
            Integer point = getPoint(s);
            if (point != null){
                //숫자인 경우
                result[index] = point;
                index++;
            }else {
                if (s.equals("S")){
                    result[index-1] = (int) Math.pow(result[index-1], 1);
                }else if (s.equals("D")){
                    result[index-1] = (int) Math.pow(result[index-1], 2);
                }else if (s.equals("T")){
                    result[index-1] = (int) Math.pow(result[index-1], 3);
                }else if (s.equals("*")){
                    result[index-1] = result[index-1] * 2;
                    if(index > 1){
                        result[index-2] = result[index-2] * 2;
                    }
                }else if (s.equals("#")){
                    result[index-1] = result[index-1]*(-1);
                }
            }

        }

        return Arrays.stream(result).sum();
    }
    public Integer getPoint(String c){
        switch (c){
            case "0": return 0;
            case "1": return 1;
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "10": return 10;
        }
        return null;
    }

    public static void main(String[] args) {

        Dart2 dart = new Dart2();
        String dartResult = "1D2S#10S";
        int solution = dart.solution(dartResult);
        System.out.println("====answer===");
        System.out.println(solution);
    }

}
