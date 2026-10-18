class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min_price=prices[0]
        max_profit=0

        for i in range(1, len(prices)):
            price=prices[i]
            if price < min_price :
                min_price = price

            profit = price - min_price
            max_profit = max(profit, max_profit)
        
        return max_profit