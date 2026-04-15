class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList=new ArrayList<>();
        backtrack(resultList, new ArrayList<>(), nums, 0); // backtracking from first element
        return resultList;
    }

    public void backtrack(List<List<Integer>> resultSet, List<Integer> tempSet, int[] nums, int start){
        
        resultSet.add(new ArrayList<>(tempSet));

        for(int i=start; i<nums.length;i++){

            // Case of including the number

            tempSet.add(nums[i]);

            // Backtracking the number

            backtrack(resultSet, tempSet, nums, i+1);

            // Case of not including the number

            tempSet.remove(tempSet.size()-1);
        }

    }


}
