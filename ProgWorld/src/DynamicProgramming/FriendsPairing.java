package DynamicProgramming;

public class FriendsPairing {
    public static void main(String[] args) {
        int n=3;
        System.out.println(solve(n));
    }
    private static int solve(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }

        return solve(n-1)+solve(n-2)*(n-1);

    }
}
