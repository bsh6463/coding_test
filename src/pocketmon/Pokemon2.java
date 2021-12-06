package pocketmon;

import java.util.HashSet;

public class Pokemon2 {
    public int solution(int[] nums) {

        HashSet<Integer> pokemon = new HashSet<>();

        for (int num : nums) {
            pokemon.add(num);
        }

        return Math.min(pokemon.size(), nums.length/2);
    }
}
