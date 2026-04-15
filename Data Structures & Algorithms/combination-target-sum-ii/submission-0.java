class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        int sum=0; // initialise sum to 0

        Arrays.sort(candidates);
        backtrack(candidates, target, sum, new ArrayList<>(), 0, result);

        return result;
    }

    public void backtrack(int[] candidates, int target, int sum, List<Integer> tempList, int start, List<List<Integer>> result){
        if(sum==target){
            result.add(new ArrayList<>(tempList)); 
            return;
        }

        for(int i=start;i<candidates.length;i++){ 
            
            if(i>start && candidates[i]==candidates[i-1])
                continue; // same element detected, can result in duplicate combinations
            

            if(sum+candidates[i] > target)
                break;

            tempList.add(candidates[i]); // including the present element

            backtrack(candidates, target, sum+ candidates[i], tempList, i+1, result); // eksplore the nekst element
            
            tempList.remove(tempList.size()-1); // removing the present element

        }
       
    }

}
