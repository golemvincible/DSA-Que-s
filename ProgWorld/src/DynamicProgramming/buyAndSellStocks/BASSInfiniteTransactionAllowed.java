package DynamicProgramming.buyAndSellStocks;

import java.util.Scanner;

public class BASSInfiniteTransactionAllowed {
    private static int util(int[] prices) {
        int profit=0;
        int sd,bd;
        sd=bd=0;
        for (int i = 1; i < prices.length; i++) {

            //upstream
            if(prices[i-1]<=prices[i]){
                sd++;
            }
            //downstream
            else{
                profit+= prices[sd] - prices[bd];
                bd=sd=i;
            }
        }
        profit+= prices[sd] - prices[bd];
        return profit;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] prices = new int[n];
        for(int i=0;i<n;i++){
            prices[i] = sc.nextInt();
        }
        int res = util(prices);
        System.out.println(res);
    }
}
