class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
           int[] result=new int[temperatures.length];
           Arrays.fill(result,0);

           if(temperatures==null || temperatures.length==0)
               return result;

           for(int i=0;i<temperatures.length;i++){
               for (int j=i+1;j<temperatures.length;j++){
                   if(temperatures[i]<temperatures[j]){
                       result[i]=j-i;
                       break;
                   }
               }
           }

           return result;
    }
}
