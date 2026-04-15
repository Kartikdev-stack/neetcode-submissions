class Solution {
    //Binary Search Approach
    public int minEatingSpeed(int[] piles, int h) {
       Arrays.sort(piles);

       int start=1;
       int end=piles[piles.length-1]; // max value of array would be the scope of the range
       int result=-1;

       while(start<=end){
          int mid=start+(end-start)/2;
          int totalHours=0;

            for(int pile: piles){
                totalHours+=Math.ceil((double) pile/mid);
            }

            if(totalHours<=h){
                result=mid; // we store this value as this may be the result
                end=mid-1; // we search for more smaller values
            }else{
                start=mid+1; // in case speed is too slow
            }

        }
    
        return result;
    }
}
