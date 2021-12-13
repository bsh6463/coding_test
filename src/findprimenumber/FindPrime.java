package findprimenumber;

public class FindPrime {

    public int solution(int n) {
        int answer = 1; // 2 반영

        for (int i=3; i<=n; i=i+2){
            if (isPrime(i)) answer++;
        }
        return answer;
    }

    private boolean isPrime(int number) {

        for (int i=3; i<=Math.sqrt(number); i=i+2){
            if ((number%i) == 0){
                return false;
            }
        }
        return true;
    }

}
