package level1.remainzero;

import java.util.Arrays;

public class RemainZero {

    public int[] solution(int[] arr, int divisor) {
        int[] ints;
        ints = Arrays.stream(arr).filter(i -> (i % divisor) == 0).sorted().toArray();
        if (ints.length == 0) {
            ints =new int[1];
            ints[0] = -1;
        }
        return ints;
    }

}
