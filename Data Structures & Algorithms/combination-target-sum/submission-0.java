class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result=new ArrayList<>();

        combinationSum(nums, target, new ArrayList<>(), 0);

        return result;  
    }

    public void combinationSum(int[] nums, int target, List<Integer> temp, int i){
         
        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }

        if(target<0 || i>=nums.length){
            return;
        }


         temp.add(nums[i]);  // case of inclusion

         combinationSum(nums, target - nums[i], temp, i);    // backtracking   

         temp.remove(temp.size()-1);  
         
         combinationSum(nums,target, temp, i+1);   // case of exclusion

    }
} 
