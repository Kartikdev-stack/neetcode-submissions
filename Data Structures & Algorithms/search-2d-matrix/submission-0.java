class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int columns=matrix[0].length;

        int start=0;
        int end=(rows*columns)-1;

       while(start<=end){
         int mid=start+(end-start)/2;
         int mid_value=matrix[mid/columns][mid%columns];

         if(mid_value==target){
            return true;
         }else if(mid_value>target){
            end=mid-1;
         }else{
            start=mid+1;
         }
       }
      return false;
    }
}
