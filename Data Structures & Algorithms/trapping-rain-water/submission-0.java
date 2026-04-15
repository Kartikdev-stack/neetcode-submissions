class Solution {
    public int trap(int[] height) {
        
        if(height==null || height.length<3){
            return 0;
        }

        int totalWater=0;
        
        for(int i=1;i<height.length-1;i++){
            int leftMax=0;
            int rightMax=0;


            for(int j=0;j<i;j++){
                    leftMax=Math.max(leftMax, height[j]);
            }

            for(int j=i+1; j<height.length;j++){
                    rightMax=Math.max(rightMax, height[j]);
            }

            int waterLevel=Math.min(rightMax, leftMax);
            if(waterLevel > height[i]){
                totalWater+=waterLevel - height[i];
            }

        }

        return totalWater;
    }
}
