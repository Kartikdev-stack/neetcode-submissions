class Solution {

    // Optimised solution with Hash Set
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        
        // dumping data to HashSet from array

         for(int num: nums){
            set.add(num);
         }

// the only reason to even use hash set is because of its ability for o(1) lookups
       
        int longest=0;
        for(int num: set){
            if(!set.contains(num-1)){  // we check if the previous element exists
                int length=1;
                while(set.contains(num+length)){
                    length++;
                }
                longest=Math.max(longest, length);
            }
        }
        return longest;
    }
}
