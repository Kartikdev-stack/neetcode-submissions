// Brute Force Approach
class Solution {
    public int longestConsecutive(int[] nums) {
        // lets first check if there eksists any preceding element

        int longestStreak=0;

        for(int i=0;i<nums.length;i++){
           boolean isStart=true;

           for(int j=0;j<nums.length;j++){
                if(nums[j]==(nums[i]-1)){
                    isStart=false;
                    break;
                }
           }

           // now we have identified whether we have the most starting element

           if(isStart){
            int currentNum=nums[i];
            int currentStreak=1;

            while(contains(nums, currentNum+1)){
                currentStreak++;
                currentNum++;
            }

            longestStreak=Math.max(longestStreak,currentStreak);

           }
        }
        return longestStreak;
    }

    public boolean contains(int[] nums, int target){
        for(int num: nums){
            if(num==target)
               return true;
        }
        return false;
    }

}
