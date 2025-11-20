public class Q121 {
    class Solution {
        public int maxProfit(int[] prices) {
            int buyPrice = prices[0];
            int maxProfit = 0;
            for(int price: prices){
                if(price>buyPrice){
                    maxProfit= Math.max(maxProfit, price-buyPrice);
                }else if(price<buyPrice){
                    buyPrice = price;
                }
            }
            return maxProfit;
        }
    }

}
