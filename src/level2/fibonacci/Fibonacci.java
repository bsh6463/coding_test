package level2.fibonacci;

public class Fibonacci {
    public long solution(int n) {
        int number = 1234567;
        long f1 = 0 % number;
        long f2 = 1 % number;
        int cnt = 1;
        long answer=0;

        if(n<2){
            return 1;
        }

        while(cnt<=n){
            cnt++;
            long f = (f1 + f2)%number;
            f1 = f2;
            f2 = f;
            //System.out.println(f);

            if(cnt == n) {
                answer = f;
                break;
            }

        }
        return answer;
    }
}
