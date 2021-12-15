package level1.divisor;

public class Divisor {

    public int solution(int left, int right) {
        int answer = 0;
        int count=0;

        for (int i=left;i<=right; i++){
            //i의 약수의 개수 확인
            count = getDivisorCount(i);
            //i의 약수의 개수가 짝수면??
            if ((count%2) ==0){
                answer+=i;
            }else {
                answer-= i;
            }
            //i의 약수의 개수가 홀수면??
        }

        return answer;
    }

    private int getDivisorCount(int number) {
        int count = 0;
        for (int i=1; i<=number;i++){
            int remainder = number % i;
            if (remainder == 0){
                count++;
            }
        }
        return count;
    }


}
