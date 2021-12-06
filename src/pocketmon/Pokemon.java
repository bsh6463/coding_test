package pocketmon;

import java.util.Arrays;

public class Pokemon {
    public int solution(int[] nums) {
        int pokemonCount = 0;
        int n = nums.length/2; //n개를 뽑아야함.

        Arrays.sort(nums);

        int before=0;;
        for (int i=0; i<nums.length; i++){

            if (nums[i] != before){
                pokemonCount++;
                before = nums[i];
            }
        }

        if (pokemonCount >= n){
            return n;
        }else{
            return pokemonCount;
        }
    }
}
