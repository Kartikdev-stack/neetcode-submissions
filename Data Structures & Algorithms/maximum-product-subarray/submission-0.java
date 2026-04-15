class Solution {
    public int maxProduct(int[] nums) {
        
        if(nums.length==0 || nums==null){
            return 0;
        }

        int result=nums[0];
        int max_product=nums[0];
        int min_product=nums[0];


        for(int i=1;i<nums.length;i++){
            
           int num=nums[i];
           
           if(num<0){
              int temp=max_product;
              max_product=min_product;
              min_product=temp;
           }else if(num==0){
               max_product=1;
               min_product=1;
           }

           max_product=Math.max(num,max_product*num); // current max
           min_product=Math.min(num,min_product*num); // current min

           result=Math.max(result, max_product);
        }

        return result;
    }
}
