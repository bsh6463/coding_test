package trinarydigit;

import java.util.ArrayList;

public class TrinaryDigit {

    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> trinary= new ArrayList<>();
        int Q = 0;
        int R = 0;
        while (true){
            Q = n / 3;
            R = n % 3;

            trinary.add(R);
            if (Q !=0){
            n=Q;
            }else {
                break;
            }
        }

        for (int i=trinary.size()-1; i>=0 ;i--){
            answer += trinary.get(i) * Math.pow(3, trinary.size()-1-i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 45;

        TrinaryDigit digit = new TrinaryDigit();
        int solution = digit.solution(n);

        System.out.println("======answer=====");
        System.out.println(solution);
    }

}
