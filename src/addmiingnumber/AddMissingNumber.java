package addmiingnumber;

import java.util.Arrays;

public class AddMissingNumber {

    public int solution(int[] numbers) {
        int sum = Arrays.stream(numbers).sum();
        return 45-sum;
    }


}
