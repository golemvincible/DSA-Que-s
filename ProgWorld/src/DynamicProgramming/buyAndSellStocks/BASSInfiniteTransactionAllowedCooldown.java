package DynamicProgramming.buyAndSellStocks;

import java.util.Scanner;

public class BASSInfiniteTransactionAllowedCooldown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] prices = new int[n];
        for(int i=0;i<n;i++){
            prices[i] = sc.nextInt();
        }
        int res = util(prices);
        System.out.println(res);
    }

    private static int util(int[] prices) {
        int obsp = -prices[0];
        int ossp = 0;
        int ocsp = 0;

        for (int i = 1; i < prices.length; i++) {

            int ncsp = Math.max(ocsp,ossp);
            int nbsp = Math.max(obsp,ocsp-prices[i]);
            int nssp = Math.max(ossp,obsp+prices[i]);

            obsp=nbsp;
            ossp=nssp;
            ocsp=ncsp;
        }

        return ossp;
    }
}
