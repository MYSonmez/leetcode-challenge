package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        for (int i = 0; i < candidates.length; i++) {
            System.out.println(candidates[i]);
        }

        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, result, new ArrayList<>(), 0);
        return result;

    }

    public static void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> combination,
            int index) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if (target < 0 || index == candidates.length) {
            return;
        }

        combination.add(candidates[index]);
        backtrack(candidates, target - candidates[index], result, combination, index + 1);

        combination.remove(combination.size() - 1);
        backtrack(candidates, target, result, combination, index + 1);

    }
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println(result);
    }

}
