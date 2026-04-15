class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> resultList= new ArrayList<>();
        backtrack(resultList, new ArrayList<>(), nums, 0, target, 0 ); 

        return resultList;
    }

    public void backtrack(List<List<Integer>> resultList, List<Integer> tempList, int[] nums, int sum, int target, int start){

        // Base Case

        if(sum==target){
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        if(sum>target){
            return;
        }

        for(int i=start;i<nums.length;i++){

            tempList.add(nums[i]); // Case of considering the number

            backtrack(resultList, tempList, nums, sum+nums[i], target, i);   // exploring next combination

            tempList.remove(tempList.size()-1); // backtracknig when we reach the end 
        }

        
    }


}
