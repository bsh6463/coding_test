package addtwonumber;

import java.util.*;

public class AddTwoNumber {

    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();

        for (int i=0; i<numbers.length; i++){
            for (int j=i+1; j<numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().sorted().mapToInt(c -> c).toArray();
    }

    public static void main(String[] args) {

        int[] nums = {5,0,2,7};
        AddTwoNumber addTwoNumber = new AddTwoNumber();
        int[] solution = addTwoNumber.solution(nums);
        System.out.println("=====answer====");
        Arrays.stream(solution).forEach(System.out::println);
    }
}
