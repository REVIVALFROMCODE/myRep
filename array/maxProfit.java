//Best Time to Buy and Sell Stock II.
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}
/*
 * with greedy approach, each prices[i]>prices[i-1] offer a potential profit
 * key point is given array 1,2,3,4,5
 * diffence between each two numbers: 1+1+1+1= 4 =5-1;
 * 
 * 7,1,5,3,6,4
 * 1,5 3,6
 * =4+3=7
 * (5-1)+(6-3)=7 that are all potential apportunities
 */
/*
 * Here's why this greedy strategy is effective:
 * 
 * Key Reasons:
 * Independent Transactions:
 * 
 * Each opportunity to buy and sell is independent of other days. Whether you
 * buy today and sell tomorrow or next week, it doesn't affect other potential
 * transactions.
 * 
 * Local Profit Maximization:
 * 
 * By capturing every instance where the price increases, you ensure that you’re
 * taking advantage of each profitable opportunity. This local optimization
 * (buying at every local low and selling at every local high) leads to global
 * profit maximization.
 * 
 * Additivity of Profits:
 * 
 * The profit earned from different transactions can be summed up to get the
 * total profit. Therefore, by summing all individual profits from each upward
 * price movement, you achieve the maximum possible profit.
 */

// Similar issue: You want to maximize your profit by choosing a single day to
// buy {{one}} stock and choosing a different day in the future to sell that
// stock.
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > profit) {
                profit = prices[i] - min;
            }
        }
        return profit;
    }
}

// 7,1,5,3,6,4
// 1.buy
// 6.sell
