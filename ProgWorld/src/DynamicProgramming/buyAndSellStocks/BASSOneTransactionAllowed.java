package DynamicProgramming.buyAndSellStocks;
public class BASSOneTransactionAllowed {
    public static void main(String[] args) {
        int n=3;
        int[] prices = new int[n];
        prices[0] = 1;
        prices[1] = 2;
        prices[2] = 3;
        int res = util(prices);
        System.out.println(res);
    }

    private static int util(int[] prices) {
        /*
            lsf = least so far
            pist = profit if sold today
            mp = maximum profit (answer)
        */

        int lsf = Integer.MAX_VALUE;
        int pist = 0;
        int mp = 0;

        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<lsf)
                lsf=prices[i];

            pist = prices[i] - lsf;

            if(pist>mp){
                mp=pist;
            }
        }
        return mp;
    }
}
