package src.primeNos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveofEratosthenes {
    private static void seiveAlgo(boolean[] isPrime,int n){

        //as we know 0 and 1 are not prime no.
        isPrime[0]=false;
        isPrime[1]=false;

//        for(int i=2;i<=n;i++){
//            if(!isPrime[i]){
//                for(int j=i*i;j<=n;j+=i){
//                    isPrime[j]=true;
//                }
//            }
//        }

        for (int i = 2; i*i <= n; i++) {
            if(isPrime[i]){

                //jese 3 ki table mein har baar 3 increment hota hai wese hi bss table likhne wala loop hai ye
                for (int j = 2*i; j <= n; j+=i) {
                    isPrime[j]=false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        //all the non primes are marked

        for(int i=0;i<1005;i++){
            if(isPrime[i])
                primes.add(i);
        }
        System.out.println(primes);
    }
    public static void main(String[] args) {
        boolean[] isPrime=new boolean[1006];
        Arrays.fill(isPrime,true);
        //it will print all the prime no.s from 0 to 1004
        seiveAlgo(isPrime,1005);
    }
}
