package gymsuit;

public class GymSuit {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] count = new int[n];
        int answer = n;
        for (int surplus : reserve) {
            count[surplus-1]++;
        }

        for (int minus : lost) {
            if (--count[minus-1] < 0){
             answer--;
            }

        }

        //-1: 없음 , 0: 1개있음, 1: 2개있음
        // 0보타 크냐 작냐가 중요함.
        for (int i=1; i<n-1; i++){
            if (count[i] > 0){
                if (count[i-1] < 0){
                    count[i]--;
                    count[i-1]++;
                    answer++;
                }else if (count[i+1] <0){
                    count[i]--;
                    count[i+1]++;
                    answer++;
                }

            }else if (count[i] < 0){
                if (count[i-1] > 0){
                    count[i]++;
                    count[i-1]--;
                    answer++;
                }else if (count[i+1] > 0){
                    count[i]++;
                    count[i+1]--;
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        GymSuit gymSuit =new GymSuit();
        int answer = gymSuit.solution(n, lost, reserve);
        System.out.println("====answer=====");
        System.out.println(answer);

    }
}
