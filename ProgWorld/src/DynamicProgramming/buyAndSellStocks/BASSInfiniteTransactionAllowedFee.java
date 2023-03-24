package DynamicProgramming.buyAndSellStocks;

import java.util.Scanner;

public class BASSInfiniteTransactionAllowedFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int fees = sc.nextInt();
        int[] prices = new int[n];
        for(int i=0;i<n;i++){
            prices[i] = sc.nextInt();
        }
        int res = util(prices,fees);
        System.out.println(res);
    }

    private static int util(int[] prices, int fees) {
        /*
            bsp = bought state profit
            ssp = sold state profit
        */
        int obsp = -prices[0];
        int ossp = 0;
        for (int i = 1; i < prices.length; i++) {

            int nbsp = Math.max(ossp-prices[i],obsp);
            int nssp = Math.max(obsp+prices[i]-fees,ossp);

            obsp=nbsp;
            ossp=nssp;
        }
        return obsp;
    }
}
