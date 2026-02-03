package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * QUESTION:
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen
 * numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen
 * numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to
 * target is less than 150 combinations for the given input.
 *
 * @author m.yusufsonmez03@gmail.com
 *
 **/

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    public static void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> currentList, int i) {
        if (target < 0 || i == candidates.length)  {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        currentList.add(candidates[i]);
        backtrack(candidates, target - candidates[i], result, currentList, i);

        currentList.remove(currentList.size() - 1);
        backtrack(candidates, target, result, currentList, i  + 1);
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }

}
