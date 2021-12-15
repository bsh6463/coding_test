package level1.addtwonumber;

import java.util.Arrays;
import java.util.TreeSet;

public class AddTwoNumber2 {

    public int[] solution(int[] numbers) {
        //HashSet<Integer> set = new HashSet<>();
        TreeSet<Integer> set = new TreeSet<Integer>();

        for (int i=0; i<numbers.length; i++){
            for (int j=i+1; j<numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(c -> c).toArray();
    }

    public static void main(String[] args) {

        int[] nums = {5,0,2,7};
        AddTwoNumber2 addTwoNumber = new AddTwoNumber2();
        int[] solution = addTwoNumber.solution(nums);
        System.out.println("=====answer====");
        Arrays.stream(solution).forEach(System.out::println);
    }
}
