package DynamicProgramming.buyAndSellStocks;

import java.util.Scanner;

public class BASSTwoTransactionsAllowed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        int res = util(prices);
        System.out.println(res);
    }

    private static int util(int[] prices) {
        int mpist = 0;
        int leastsf = prices[0];
        int dpmpisut[] = new int[prices.length+1]; //dp maximum profit if sold upto today
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]<leastsf)
                leastsf=prices[i];
            mpist = prices[i]-leastsf;

            if(dpmpisut[i-1]<mpist)
                dpmpisut[i]=mpist;
            else
                dpmpisut[i] = dpmpisut[i-1];

        }
        int mpibt=0;
        int maxat=prices[prices.length-1]; //max after today
        int[] dpmpibat=new int[prices.length+1]; //dp maximum profit if bought after today

        for (int i = prices.length-2; i >= 0; i--) {
            if(prices[i]>maxat)
                maxat=prices[ i];

            mpibt=maxat-prices[i];

            if(mpibt>dpmpibat[i+1]){
                dpmpibat[i]=mpibt;
            }
            else {
                dpmpibat[i] = dpmpibat[i + 1];
            }
        }
        int res = 0;
        int temp=0;
        for (int i = 0; i < prices.length; i++) {
            temp = dpmpibat[i]+dpmpisut[i];

            if(temp>res)
                res=temp;
        }
        return res;
    }
}
