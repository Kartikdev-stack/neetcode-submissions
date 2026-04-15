class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), result);
        return result;

        // 1,2,3 
    }

    public void subsets(int[] nums, int idx, List<Integer> path, List<List<Integer>> res){
        
        if(idx==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }


        // Choice 1: We ignore the current idx value

        subsets(nums,idx+1,path, res);

        // Choice 2: We proceed with current idx value

        path.add(nums[idx]); // choose the value
        subsets(nums, idx+1, path, res);  // choose next value
        path.remove(path.size()-1);  // initiate backtracking
    }
}
