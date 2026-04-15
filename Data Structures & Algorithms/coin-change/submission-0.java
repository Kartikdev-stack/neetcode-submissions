public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0; // If no amount to make, no coins are needed.
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // Fill with a large number to denote that the value has not been calculated yet.
        dp[0] = 0; // Base case: No coins are needed to make 0 amount.

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
