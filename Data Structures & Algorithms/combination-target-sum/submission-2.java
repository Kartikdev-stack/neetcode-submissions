class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        if(nums==null){
            return new ArrayList<>();
        }

        int currSum=0;
        List<List<Integer>> result=new ArrayList<>();
        backtrack(nums, new ArrayList<>(), target, currSum, 0, result);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> path, int target, int sum, int index, List<List<Integer>> result){

        // Base Case

        if(sum==target){
            result.add(new ArrayList<>(path));
            return;
        }

        if(index==nums.length){
            return;
        }

        if(sum>target){
            return;
        }

        // Choice: ignore the current number

        backtrack(nums, path, target, sum, index+1, result);

        // Choice: Pick the current value

        path.add(nums[index]); 
        backtrack(nums, path, target, sum + nums[index], index, result);
        path.remove(path.size()-1);

    }
}
