package src.primeNos;

import java.util.ArrayList;
import java.util.List;

public class SieveofEratosthenes {
    private static void seiveAlgo(boolean[] isPrime,int n){

        //as we know 0 and 1 are not prime no.
        isPrime[0]=false;
        isPrime[1]=false;

        for(int i=2;i<=n;i++){
            if(!isPrime[i]){
                for(int j=i*i;j<=n;j+=i){
                    isPrime[j]=true;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        //all the non primes are marked

        for(int i=0;i<1005;i++){
            if(!isPrime[i])
                primes.add(i);
        }
        System.out.println(primes);
    }
    public static void main(String[] args) {
        boolean[] isPrime=new boolean[1006];
        //it will print all the prime no.s from 0 to 1004
        seiveAlgo(isPrime,1005);
    }
}
