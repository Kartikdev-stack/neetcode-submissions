class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();

        Arrays.sort(nums);
        backtrack(nums, result, 0, new ArrayList<>());

        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, int start, List<Integer> temp ){

        result.add(new ArrayList<>(temp));

        for(int i=start; i< nums.length;i++){
            
            if( i>start && nums[i]==nums[i-1])
                continue; // ekscluding when starting element is same

            temp.add(nums[i]); // case of considering the element

            backtrack(nums, result, i+1, temp); // eksploring the path

            temp.remove(temp.size()-1); // case of not considering the element
        }
    }
}
