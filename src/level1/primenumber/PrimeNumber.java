package level1.primenumber;

public class PrimeNumber {

    public int solution(int[] nums) {
        int answer = 0;
        int a=0;
        int b=0;
        int c=0;

        for (int i=0; i<nums.length; i++){
            a= nums[i];
            for (int j=i+1; j<nums.length; j++){
                b=nums[j];
                for (int k=j+1; k<nums.length; k++){
                    c = nums[k];

                    if (isPrime(a + b + c)){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public boolean isPrime(int number){
        for (int i=2; i< Math.sqrt(number); i++){
            if ((number % i) == 0){
                return false;
            }
        }
        return true;
    }
}
