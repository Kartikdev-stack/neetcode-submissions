class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(nums[mid]==target)
                return mid;

            if(nums[mid] >= nums[start]){
                // suggests left half is sorted

                if(nums[start] <= target  && nums[mid] > target){
                    end=mid-1;  // lies in the left
                }else{
                    start=mid+1; // lies in the right
                }
            }else{
                // suggests right half is sorted

                if(nums[mid]<target && nums[end] >= target){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return -1; // target doesnt exist
    }
}
