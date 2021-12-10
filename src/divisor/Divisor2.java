package divisor;

public class Divisor2 {

    public int solution(int left, int right) {

        int answer = 0;

        //제곱수는 약수의 개수가 홀수임, 1, ..,n,.., n^2

        for (int i = left; i <= right; i++) {
            if ((i % Math.sqrt(i)) == 0) {
                answer -= i;
            } else {
                answer += i;
            }

        }

        return answer;
    }
}
