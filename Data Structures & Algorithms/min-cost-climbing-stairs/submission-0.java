class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Map<Integer,Integer> memo=new HashMap<>();
        return minCostClimbingStairs(cost,cost.length,memo); // recursion call to get min cost after last element
    }

    public int minCostClimbingStairs(int[] cost,int i, Map<Integer,Integer> memo){
         // Base cases

         if(i==0){
            return 0;
         }

         if(i==1){
            return 0;
         }

         // Check for cache if the cost is aldrady calculated before

         if(memo.containsKey(i)){
            return memo.get(i);
         }

        int min_cost=Math.min(cost[i-1]+minCostClimbingStairs(cost,i-1,memo), cost[i-2]+minCostClimbingStairs(cost,i-2,memo));

        memo.put(i,min_cost);
        
         
        return min_cost;
    }

}
