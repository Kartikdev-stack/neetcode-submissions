class Solution {
    public int trap(int[] height) {
        if(height==null || height.length < 3){
            return 0;
        }

        int start=0;
        int end=height.length-1;
        int leftMax=0;
        int rightMax=0;

        int totalWater=0;

        while(start < end){
            if(height[start] < height[end]){
                if(height[start] >= leftMax){
                    leftMax=Math.max(height[start], leftMax);
                }else{
                    totalWater+=leftMax - height[start];
                }
                start++;
            }else{
                if(height[end] >= rightMax){
                    rightMax=Math.max(rightMax, height[end]);
                }else{
                    totalWater+=rightMax - height[end];
                }
                end--;
            }
        }
        return totalWater;
    }
}
