class Solution {
    public int search(int[] nums, int target) {
        // 3,4,5,6,1,2

        int start=0;
        int end=nums.length-1;

        while(start<=end){
            int mid=start+(end-start)/2; // calculate the mid
            if(nums[mid]==target){
                return mid;
            }

            if(nums[start]<=nums[mid]){
               // this means left half is sorted
               if(nums[start]<=target && target<nums[mid]){
                    end=mid-1;
               }else{
                    start=mid+1;
               }
            }else{
                // right half is sorted
                if(nums[mid]<target && target<=nums[end]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
    
}
