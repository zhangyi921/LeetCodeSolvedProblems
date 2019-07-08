class Solution {
    public int maxProfit(int[] prices) {
        int i=0, j=1, profit=0, priceBought = 0;
        boolean bought=false;
        for (; j < prices.length; ++i, ++j){
            //System.out.println(prices[j]);
            if (!bought && prices[i] < prices[j]){
                // System.out.println("bought at " + prices[i]);
                // buy
                priceBought = prices[i];
                bought = true;
            }
            else if (bought && prices[i] > prices[j]){
                // sell
                // System.out.println("sold at " + prices[i]);
                profit += prices[i] - priceBought;
                bought = false;
            }
        }
        if (bought){
            // System.out.println("sold at " + prices[prices.length-1]);
            profit += prices[prices.length-1] - priceBought;
        }
        return profit;
    }
}