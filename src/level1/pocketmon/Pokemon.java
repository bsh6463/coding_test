package level1.pocketmon;

import java.util.Arrays;

public class Pokemon {
    public int solution(int[] nums) {
        int pokemonCount = 0;
        int n = nums.length/2; //n개를 뽑아야함.

        Arrays.sort(nums);

        int before=0;;
        for (int num : nums) {
            if (num != before) {
                pokemonCount++;
                before = num;
            }
        }

        return Math.min(pokemonCount, n);
    }
}
