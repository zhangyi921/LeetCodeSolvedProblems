class Solution {
    public int maxProfit1(int[] prices) {
        int profit = 0;
        for (int buy = 0; buy < prices.length; ++buy){
            for (int sell = buy+1; sell < prices.length; ++sell){
                int currentProfit = prices[sell]-prices[buy];
                profit = profit > currentProfit ? profit: currentProfit;
            }
        }
        return profit;
    }
    
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}