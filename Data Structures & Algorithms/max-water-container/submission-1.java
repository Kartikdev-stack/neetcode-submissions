class Solution {
    public int maxArea(int[] heights) {
        if( heights == null || heights.length < 2){
            return 0;
        }

        int left=0;
        int right=heights.length-1;
        int maxArea=0; 
        while(left < right){
            if(heights[left] < heights[right]){
                maxArea=Math.max(maxArea, heights[left] * (right -left));
                left++;
            }else{
                maxArea=Math.max(maxArea, heights[right] * (right - left));
                right--;
            }

        }
        return maxArea;
    }
}
