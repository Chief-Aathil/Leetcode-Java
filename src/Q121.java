public class Q121 {
    class Solution {
        public int maxProfit(int[] prices) {
            //Sliding window:
            //buyDay:lowest price so far
            //sellDay: highest price after buyDay

            //dayPrice>sellDayPrice>buyDayPrice: update sellDay
            //dayPrice<buyDayPrice: update buyDay and sellDay

            int buyDay=0, sellDay=1, maxProfit=0;
            for(int i=1; i<prices.length; i++){
                if(prices[i]>prices[buyDay]){
                    sellDay = prices[sellDay] > prices[i] ? sellDay: i;
                }else if(prices[i]<prices[buyDay]){
                    buyDay = i;
                    sellDay = i+1;
                }

                if(buyDay<prices.length && sellDay<prices.length && buyDay<sellDay){
                    maxProfit = Math.max(maxProfit,prices[sellDay]-prices[buyDay]);
                }

            }
            return maxProfit;
        }
    }

}
